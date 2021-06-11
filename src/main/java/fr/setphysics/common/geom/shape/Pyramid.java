package fr.setphysics.common.geom.shape;

import fr.setphysics.common.geom.Shape;
import fr.setphysics.common.geom.Vec3;

import java.util.List;

public class Pyramid extends Shape {
    /**
     * Crée une pyramide régulière à base rectangulaire
     * @param width Largeur de la base
     * @param length Longueur de la base
     * @param height Hauteur
     */
    public Pyramid(double width, double length, double height) {

        // Points à la base
        Vec3 a = new Vec3(-width/2, -height/2, -length/2);
        Vec3 b = new Vec3(-width/2, -height/2, length/2);
        Vec3 c = new Vec3(width/2, -height/2, length/2);
        Vec3 d = new Vec3(width/2, -height/2, -length/2);

        // Sommet
        Vec3 s = new Vec3(0, height/2,0);

        // Face inferieur
        addSquare(a,b,c,d);

        // Face droite
        addVertex(d);
        addVertex(s);
        addVertex(c);

        // Face devant
        addVertex(c);
        addVertex(s);
        addVertex(b);

        // Face gauche
        addVertex(b);
        addVertex(s);
        addVertex(a);

        // Face derriere
        addVertex(a);
        addVertex(s);
        addVertex(d);

    }
    /**
     * Crée une pyramide régulière à base triangulaire
     * @param side cote du triangle
     * @param height Hauteur
     */
    public Pyramid(double side, double height) {
        // Points à la base
        Vec3 a = new Vec3(-side/2, -height/2, Math.sqrt(3)/6 * side);
        Vec3 b = new Vec3(side/2, -height/2, Math.sqrt(3)/6 * side);
        Vec3 c = new Vec3(0, -height/2, -(Math.sqrt(3)/3 * side));

        // Sommet
        Vec3 s = new Vec3(0, height/2,0);

        // Face inferieur
        addVertex(a);
        addVertex(b);
        addVertex(c);

        // Face derriere gauche
        addVertex(c);
        addVertex(s);
        addVertex(a);

        // Face devant
        addVertex(a);
        addVertex(s);
        addVertex(b);

        // Face derriere droite
        addVertex(b);
        addVertex(s);
        addVertex(c);

    }
    /**
     * Crée une pyramide régulière à base quelconque
     * @param sides taille de chaque cote
     * @param height Hauteur
     */
    public Pyramid(List<Double> sides, double height) {

    }

}
