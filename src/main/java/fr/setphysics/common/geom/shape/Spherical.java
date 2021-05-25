package fr.setphysics.common.geom.shape;

import java.util.ArrayList;
import java.util.List;

import fr.setphysics.common.geom.Shape;
import fr.setphysics.common.geom.Vec3;

public class Spherical extends Shape {
	private double radius;

	public Spherical(double radius, int nbIt) {
		super();
		this.radius = radius;
		List<Vec3> pointsList = new ArrayList<Vec3>();
		double first_coords = radius / Math.sqrt(3);
		Vec3 a = new Vec3(-first_coords, -first_coords, -first_coords);
		Vec3 b = new Vec3(-first_coords, -first_coords, first_coords);
		Vec3 c = new Vec3(first_coords, -first_coords, first_coords);
		Vec3 d = new Vec3(first_coords, -first_coords, -first_coords);

		Vec3 e = new Vec3(-first_coords, first_coords, -first_coords);
		Vec3 f = new Vec3(-first_coords, first_coords, first_coords);
		Vec3 g = new Vec3(first_coords, first_coords, first_coords);
		Vec3 h = new Vec3(first_coords, first_coords, -first_coords);
			
		
		// Face inférieure
		pointsList.addAll(findPoints(a, b, c, d, nbIt));
		// Face devant
		pointsList.addAll(findPoints(d, a, e, h, nbIt));
		// Face gauche
		pointsList.addAll(findPoints(h, d, c, g, nbIt));
		// Face supérieure
		pointsList.addAll(findPoints(g, h, e, f, nbIt));
		// Face derriere
		pointsList.addAll(findPoints(f, g, c, b, nbIt));
		// Face droite
		pointsList.addAll(findPoints(b, f, e, a, nbIt));
		
		pointsList.forEach(p -> addVertex(pointOnSphere(p)));
	}
	
	private Vec3 pointOnSphere(Vec3 pointOnCube) {
		double ratio = this.radius
				/ Math.sqrt(Math.pow(pointOnCube.getX(), 2) + Math.pow(pointOnCube.getY(), 2) + Math.pow(pointOnCube.getZ(), 2));

		return new Vec3(pointOnCube.getX() * ratio, pointOnCube.getY() * ratio, pointOnCube.getZ() * ratio);
	}

	private List<Vec3> findPoints(Vec3 a, Vec3 b, Vec3 c, Vec3 d, int nbIt) {
		List<Vec3> res = new ArrayList<Vec3>();
		Vec3 mAB = new Vec3((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2, (a.getZ() + b.getZ()) / 2);
		Vec3 mBC = new Vec3((b.getX() + c.getX()) / 2, (b.getY() + c.getY()) / 2, (b.getZ() + c.getZ()) / 2);
		Vec3 mCD = new Vec3((c.getX() + d.getX()) / 2, (c.getY() + d.getY()) / 2, (c.getZ() + d.getZ()) / 2);
		Vec3 mAD = new Vec3((a.getX() + d.getX()) / 2, (a.getY() + d.getY()) / 2, (a.getZ() + d.getZ()) / 2);
		Vec3 mFace = new Vec3((mAB.getX() + mCD.getX()) / 2, (mAB.getY() + mCD.getY()) / 2,
				(mAB.getZ() + mCD.getZ()) / 2);
		
		if(nbIt > 0) {
//			res.addAll(findPoints(mFace,mAD,a,mAB,nbIt-1));
//			res.addAll(findPoints(mFace,mAB,b,mBC,nbIt-1));
//			res.addAll(findPoints(mFace,mBC,c,mCD,nbIt-1));
//			res.addAll(findPoints(mFace,mCD,d,mAB,nbIt-1));
			res.addAll(findPoints(a,mAB,mFace,mAD,nbIt-1));
			res.addAll(findPoints(mAB,b,mBC,mFace,nbIt-1));
			res.addAll(findPoints(mFace,mBC,c,mCD,nbIt-1));
			res.addAll(findPoints(mAD,mFace,mCD,d,nbIt-1));
			
		} else {
			res.add(mFace);
			res.add(mAD);
			res.add(a);
			res.add(mAB);

			res.add(mFace);
			res.add(mAB);
			res.add(b);
			res.add(mBC);

			res.add(mFace);
			res.add(mBC);
			res.add(c);
			res.add(mCD);

			res.add(mFace);
			res.add(mCD);
			res.add(d);
			res.add(mAD);
		}

		return res;
	}
}
