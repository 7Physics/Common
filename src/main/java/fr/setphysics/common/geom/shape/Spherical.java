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
		addVertex(a);
		addVertex(b);
		addVertex(c);
		addVertex(d);
		test = findPoints(a,b,c,d);
		test.forEach(p -> addVertex(p));

		// Face devant
		addVertex(d);
		addVertex(a);
		addVertex(e);
		addVertex(h);

		// Face gauche
		addVertex(h);
		addVertex(d);
		addVertex(c);
		addVertex(g);

		// Face supérieure
		addVertex(g);
		addVertex(h);
		addVertex(e);
		addVertex(f);

		// Face derriere
		addVertex(f);
		addVertex(g);
		addVertex(c);
		addVertex(b);

		// Face droite
		addVertex(b);
		addVertex(f);
		addVertex(e);
		addVertex(a);

	}

	private List<Vec3> findPoints(Vec3 a, Vec3 b, Vec3 c, Vec3 d) {
		List<Vec3> res = new ArrayList<Vec3>();
		res.add(new Vec3((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2, (a.getZ() + b.getZ()) / 2));
		res.add(new Vec3((b.getX() + c.getX()) / 2, (b.getY() + c.getY()) / 2, (b.getZ() + c.getZ()) / 2));
		res.add(new Vec3((c.getX() + d.getX()) / 2, (c.getY() + d.getY()) / 2, (c.getZ() + d.getZ()) / 2));
		res.add(new Vec3((a.getX() + d.getX()) / 2, (a.getY() + d.getY()) / 2, (a.getZ() + d.getZ()) / 2));
		return res;
	}
}
