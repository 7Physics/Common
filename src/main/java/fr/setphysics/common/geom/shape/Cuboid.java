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
        /*
        Parallélépipède rectangle A B C D E F G H
        https://ibb.co/mTgNb5q
         */

        Vec3 a = new Vec3(-width/2, -height/2, -length/2);
        Vec3 b = new Vec3(-width/2, -height/2, length/2);
        Vec3 c = new Vec3(width/2, -height/2, length/2);
        Vec3 d = new Vec3(width/2, -height/2, -length/2);

        Vec3 e = new Vec3(-width/2, height/2, -length/2);
        Vec3 f = new Vec3(-width/2, height/2, length/2);
        Vec3 g = new Vec3(width/2, height/2, length/2);
        Vec3 h = new Vec3(width/2, height/2, -length/2);

        // Face inférieure
        addSquare(a,b,c,d);

        // Face devant
        addSquare(d,a,e,h);

        // Face gauche
        addSquare(h,d,c,g);

        // Face supérieure
        addSquare(g,h,e,f);

        // Face derriere
        addSquare(f,g,c,b);

        // Face droite
        addSquare(b,f,e,a);
    }
}
