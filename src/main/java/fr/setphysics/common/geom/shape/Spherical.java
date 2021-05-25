package fr.setphysics.common.geom.shape;

import java.util.ArrayList;
import java.util.List;

import fr.setphysics.common.geom.Shape;
import fr.setphysics.common.geom.Vec3;

public class Spherical extends Shape {
	private double radius;

	public Spherical(double radius) {
		super();
		this.radius = radius;
		List<Vec3> pointsList = new ArrayList<Vec3>();
		double first_coords = radius / Math.sqrt(2);
		Vec3 a = new Vec3(-first_coords / 2, -first_coords / 2, -first_coords / 2);
		Vec3 b = new Vec3(-first_coords / 2, -first_coords / 2, first_coords / 2);
		Vec3 c = new Vec3(first_coords / 2, -first_coords / 2, first_coords / 2);
		Vec3 d = new Vec3(first_coords / 2, -first_coords / 2, -first_coords / 2);

		Vec3 e = new Vec3(-first_coords / 2, first_coords / 2, -first_coords / 2);
		Vec3 f = new Vec3(-first_coords / 2, first_coords / 2, first_coords / 2);
		Vec3 g = new Vec3(first_coords / 2, first_coords / 2, first_coords / 2);
		Vec3 h = new Vec3(first_coords / 2, first_coords / 2, -first_coords / 2);

		// Face inférieure
		pointsList = findPoints(a, b, c, d);

		// Face devant
		pointsList.addAll(findPoints(d, a, e, h));
		// Face gauche
		pointsList.addAll(findPoints(h, d, c, g));
		// Face supérieure
		pointsList.addAll(findPoints(g, h, e, f));
		// Face derriere
		pointsList.addAll(findPoints(f, g, c, b));
		// Face droite
		pointsList.addAll(findPoints(b, f, e, a));

		pointsList.forEach(p -> addVertex(p));
	}
	
	private Vec3 pointOnSphere(Vec3 pointOnCube) {
		double ratio = this.radius
				/ Math.sqrt(Math.pow(pointOnCube.getX(), 2) + Math.pow(pointOnCube.getY(), 2) + Math.pow(pointOnCube.getZ(), 2));

		return new Vec3(pointOnCube.getX() * ratio, pointOnCube.getY() * ratio, pointOnCube.getZ() * ratio);
	}

	private List<Vec3> findPoints(Vec3 a, Vec3 b, Vec3 c, Vec3 d) {
		List<Vec3> res = new ArrayList<Vec3>();
		Vec3 mAB = new Vec3((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2, (a.getZ() + b.getZ()) / 2);
		Vec3 mBC = new Vec3((b.getX() + c.getX()) / 2, (b.getY() + c.getY()) / 2, (b.getZ() + c.getZ()) / 2);
		Vec3 mCD = new Vec3((c.getX() + d.getX()) / 2, (c.getY() + d.getY()) / 2, (c.getZ() + d.getZ()) / 2);
		Vec3 mAD = new Vec3((a.getX() + d.getX()) / 2, (a.getY() + d.getY()) / 2, (a.getZ() + d.getZ()) / 2);
		Vec3 mFace = new Vec3((mAB.getX() + mCD.getX()) / 2, (mAB.getY() + mCD.getY()) / 2,
				(mAB.getZ() + mCD.getZ()) / 2);

		Vec3 pAB = pointOnSphere(mAB);
		Vec3 pBC = pointOnSphere(mBC);
		Vec3 pCD = pointOnSphere(mCD);
		Vec3 pAD = pointOnSphere(mAD);
		Vec3 pFace = pointOnSphere(mFace);

		res.add(pFace);
		res.add(pAD);
		res.add(a);
		res.add(pAB);

		res.add(pFace);
		res.add(pAB);
		res.add(b);
		res.add(pBC);

		res.add(pFace);
		res.add(pBC);
		res.add(c);
		res.add(pCD);

		res.add(pFace);
		res.add(pCD);
		res.add(d);
		res.add(pAD);

		return res;
	}
}
