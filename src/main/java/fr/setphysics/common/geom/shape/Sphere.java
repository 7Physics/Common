package fr.setphysics.common.geom.shape;

import java.util.ArrayList;
import java.util.List;

import fr.setphysics.common.geom.Shape;
import fr.setphysics.common.geom.Vec3;

/**
 * Classe representant une Sphere. Les sommets d'un cube sont d'abord
 * selectionnes puis chaque face est scindee en 4 parties egales elles-memes a
 * nouveau scindees en 4 et ainsi de suite. Chaque point trouve sera alors place
 * a equidistance du centre du cube originel.
 */
public class Sphere extends RoundedFace {
	// rayon de la sphere
	private double radius;

	/**
	 * Constructeur permettant de specifier le rayon et la resolution de la sphere
	 * (lie au nombre d'iteration).
	 * 
	 * @param radius : rayon souhaite
	 * @param nbIt   : nombre d'iteration a effectuer
	 */
	public Sphere(double radius, int nbIt) {
		super();
		this.radius = radius;

		// Liste contenant tous les points a afficher
		List<Vec3> pointsList = new ArrayList<Vec3>();

		// Calcul des coordonnees du sommet du cube
		double first_coords = radius / Math.sqrt(3);
		Vec3 a = new Vec3(-first_coords, -first_coords, -first_coords);
		Vec3 b = new Vec3(-first_coords, -first_coords, first_coords);
		Vec3 c = new Vec3(first_coords, -first_coords, first_coords);
		Vec3 d = new Vec3(first_coords, -first_coords, -first_coords);

		Vec3 e = new Vec3(-first_coords, first_coords, -first_coords);
		Vec3 f = new Vec3(-first_coords, first_coords, first_coords);
		Vec3 g = new Vec3(first_coords, first_coords, first_coords);
		Vec3 h = new Vec3(first_coords, first_coords, -first_coords);

		// Face inferieure
		pointsList.addAll(findPoints(a, b, c, d, nbIt));
		// Face devant
		pointsList.addAll(findPoints(d, a, e, h, nbIt));
		// Face gauche
		pointsList.addAll(findPoints(h, d, c, g, nbIt));
		// Face superieure
		pointsList.addAll(findPoints(g, h, e, f, nbIt));
		// Face derriere
		pointsList.addAll(findPoints(f, g, c, b, nbIt));
		// Face droite
		pointsList.addAll(findPoints(b, f, e, a, nbIt));

		// Ajout a la liste des vertex tous les points a afficher
		pointsList.forEach(p -> addVertex(pointOnCircle(p, this.radius)));
	}

	/**
	 * Positionnement d'un point sur la surface de la sphere a partir d'un point sur
	 * la surface du cube.
	 * Redefinition avec une sphere
	 * 
	 * @param pointOnCube : point present sur la surface du cube
	 * @return point sur la surface de la sphere
	 */
	@Override
	protected Vec3 pointOnCircle(Vec3 pointOnCube, double radius) {
		// Rapport entre le rayon de la sphere et la distance entre le centre du cube et
		// le point donne en parametre
		double ratio = this.radius / Math.sqrt(
				Math.pow(pointOnCube.getX(), 2) + Math.pow(pointOnCube.getY(), 2) + Math.pow(pointOnCube.getZ(), 2));

		return new Vec3(pointOnCube.getX() * ratio, pointOnCube.getY() * ratio, pointOnCube.getZ() * ratio);
	}

	/**
	 * Calcul des points necessaires a la separation d'une face donnee en 4 parties
	 * egales.
	 * 
	 * @param a    : sommet de la face
	 * @param b    : sommet de la face
	 * @param c    : sommet de la face
	 * @param d    : sommet de la face
	 * @param nbIt : nombre d'iterations requises
	 * @return liste des points desormais present sur la face
	 */
	private List<Vec3> findPoints(Vec3 a, Vec3 b, Vec3 c, Vec3 d, int nbIt) {
		List<Vec3> res = new ArrayList<Vec3>();

		// Calcul des coordonnees du milieu de chaque arete
		Vec3 mAB = findMiddle(a, b);
		Vec3 mBC = findMiddle(b, c);
		Vec3 mCD = findMiddle(c, d);
		Vec3 mAD = findMiddle(a, d);

		// Calcul des coordonnees du milieu de la face
		Vec3 mFace = findMiddle(mAB, mCD);

		// Verification du nombre d'iterations restantes
		if (nbIt > 1) {
			// Appel recursif pour chacune des 4 parties trouvees
			res.addAll(findPoints(a, mAB, mFace, mAD, nbIt - 1));
			res.addAll(findPoints(mAB, b, mBC, mFace, nbIt - 1));
			res.addAll(findPoints(mFace, mBC, c, mCD, nbIt - 1));
			res.addAll(findPoints(mAD, mFace, mCD, d, nbIt - 1));

		} else {
			// Ajout de la partie superieure gauche
			res.add(mFace);
			res.add(mAD);
			res.add(a);
			
			res.add(mFace);
			res.add(a);
			res.add(mAB);

			// Ajout de la partie superieure droite
			res.add(mFace);
			res.add(mAB);
			res.add(b);
			
			res.add(mFace);
			res.add(b);
			res.add(mBC);

			// Ajout de la partie inferieure droite
			res.add(mFace);
			res.add(mBC);
			res.add(c);
			
			res.add(mFace);
			res.add(c);
			res.add(mCD);

			// Ajout de la partie inferieure gauche
			res.add(mFace);
			res.add(mCD);
			res.add(d);
			
			res.add(mFace);
			res.add(d);
			res.add(mAD);
		}

		return res;
	}
}
