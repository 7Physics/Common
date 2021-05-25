package fr.setphysics.common.geom.shape;

import fr.setphysics.common.geom.Shape;
import fr.setphysics.common.geom.Vec3;

public class Spherical extends Shape {
    public Spherical(double radius) {
        super();
        double first_coords = radius / Math.sqrt(2);
        Vec3 a = new Vec3(-first_coords/2, -first_coords/2, -first_coords/2);
        Vec3 b = new Vec3(-first_coords/2, -first_coords/2, first_coords/2);
        Vec3 c = new Vec3(first_coords/2, -first_coords/2, first_coords/2);
        Vec3 d = new Vec3(first_coords/2, -first_coords/2, -first_coords/2);

        Vec3 e = new Vec3(-first_coords/2, first_coords/2, -first_coords/2);
        Vec3 f = new Vec3(-first_coords/2, first_coords/2, first_coords/2);
        Vec3 g = new Vec3(first_coords/2, first_coords/2, first_coords/2);
        Vec3 h = new Vec3(first_coords/2, first_coords/2, -first_coords/2);

    }

    private Vec3 divide_faces(Vec3 a, Vec3 b, Vec3 c, Vec3 d) {

    }
}
