package fr.setphysics.common.geom.shape;

import fr.setphysics.common.geom.Shape;
import fr.setphysics.common.geom.Vec3;

public class Cuboid extends Shape {

    /**
     * Crée une forme de type parallélépipède rectangle.
     * @param width Largeur
     * @param length Longueur
     * @param height Hauteur
     */
    public Cuboid(double width, double length, double height) {
        /**
         * Appelle le super dans param et crée les 8 vertices
         */
        addVertex(new Vec3(-width/2, -height/2, -length/2));
        addVertex(new Vec3(-width/2, -height/2, length/2));
        addVertex(new Vec3(width/2, -height/2, length/2));
        addVertex(new Vec3(width/2, -height/2, -length/2));

        addVertex(new Vec3(width/2, height/2, -length/2));
        addVertex(new Vec3(width/2, height/2, length/2));
        addVertex(new Vec3(-width/2, height/2, length/2));
        addVertex(new Vec3(-width/2, height/2, -length/2));
    }
}
