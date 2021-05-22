package fr.setphysics.common.geom;

/**
 * Vecteur à trois dimensions
 */
public class Vec3 implements Cloneable{
    /** x abscisse */
    private double x;
    /** y ordonnée */
    private double y;
    /** z profondeur*/
    private double z;

    /**
     * Construire un vecteur à trois dimentions avec des coordonnées
     * @param x abscisse
     * @param y ordonnée
     * @param z profondeur
     */
    public Vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Ajoute les coordonnées d'un autre vecteur à ce vecteur.
     * @param vec3 Vecteur à ajouter.
     */
    public void add(Vec3 vec3) {
        this.x += vec3.x;
        this.y += vec3.y;
        this.z += vec3.z;
    }

    /**
     * Multiplie les coordonnées de ce vecteur par un facteur.
     * @param factor Facteur de multiplication.
     */
    public void scale(double factor) {
        this.x *= factor;
        this.y *= factor;
        this.z *= factor;
    }

    /**
     * Retourne une copie de ce vecteur.
     */
    @Override
    public Vec3 clone() {
        return new Vec3(this.x, this.y, this.z);
    }
}
