package fr.setphysics.common.geom.shape;

import java.util.ArrayList;
import java.util.List;

import fr.setphysics.common.geom.Shape;
import fr.setphysics.common.geom.Vec3;

public class Spherical extends Shape {
	public Spherical(double radius) {
		super();
		List<Vec3> test = new ArrayList<Vec3>();
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
		test = findPoints(a, b, c, d);

		// Face devant
		test.addAll(findPoints(d, a, e, h));
		// Face gauche
		test.addAll(findPoints(h, d, c, g));
		// Face supérieure
		test.addAll(findPoints(g, h, e, f));
		// Face derriere
		test.addAll(findPoints(f, g, c, b));
		// Face droite
		test.addAll(findPoints(b, f, e, a));

		test.forEach(p -> addVertex(p));
	}

	private List<Vec3> findPoints(Vec3 a, Vec3 b, Vec3 c, Vec3 d) {
		List<Vec3> res = new ArrayList<Vec3>();
		Vec3 p1 = new Vec3((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2, (a.getZ() + b.getZ()) / 2);
		Vec3 p2 = new Vec3((b.getX() + c.getX()) / 2, (b.getY() + c.getY()) / 2, (b.getZ() + c.getZ()) / 2);
		Vec3 p3 = new Vec3((c.getX() + d.getX()) / 2, (c.getY() + d.getY()) / 2, (c.getZ() + d.getZ()) / 2);
		Vec3 p4 = new Vec3((a.getX() + d.getX()) / 2, (a.getY() + d.getY()) / 2, (a.getZ() + d.getZ()) / 2);
		Vec3 p5 = new Vec3((p1.getX() + p3.getX()) / 2, (p1.getY() + p3.getY()) / 2, (p1.getZ() + p3.getZ()) / 2);
		res.add(a);
		res.add(p1);
		res.add(p5);
		res.add(p4);

		res.add(p1);
		res.add(b);
		res.add(p2);
		res.add(p5);

		res.add(p5);
		res.add(p2);
		res.add(c);
		res.add(p3);

		res.add(p4);
		res.add(p5);
		res.add(p3);
		res.add(d);

		return res;
	}
}
