package fr.setphysics.common.geom.shape;

import fr.setphysics.common.geom.Shape;
import fr.setphysics.common.geom.Vec3;

public class Cuboid extends Shape {
	private double height;

    /**
     * Crée une forme de type parallélépipède rectangle.
     * @param width Largeur
     * @param length Longueur
     * @param height Hauteur
     */
    public Cuboid(double width, double length, double height) {
        this.height = height;

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
//		addVertex(a);
//		addVertex(b);
//		addVertex(c);
//		addVertex(d);
        addSquare(a,b,c,d);

        // Face devant
//        addVertex(d);
//        addVertex(a);
//        addVertex(e);
//        addVertex(h);
        addSquare(d,a,e,h);

        // Face gauche
//        addVertex(h);
//        addVertex(d);
//        addVertex(c);
//        addVertex(g);
        addSquare(h,d,c,g);

        // Face supérieure
//        addVertex(g);
//        addVertex(h);
//        addVertex(e);
//        addVertex(f);
        addSquare(g,h,e,f);

        // Face derriere
//        addVertex(f);
//        addVertex(g);
//        addVertex(c);
//        addVertex(b);
        addSquare(f,g,c,b);

        // Face droite
//        addVertex(b);
//        addVertex(f);
//        addVertex(e);
//        addVertex(a);
        addSquare(b,f,e,a);
    }
    
    @Override
    public double getMinY() {
    	return this.height/2.0;
    }
    
    private void addSquare(Vec3 a, Vec3 b, Vec3 c, Vec3 d) {
    	// Premier triangle
    	addVertex(a);
    	addVertex(b);
    	addVertex(c);
    	
    	// Deuxième triangle
    	addVertex(a);
    	addVertex(c);
    	addVertex(d);
    }
}
