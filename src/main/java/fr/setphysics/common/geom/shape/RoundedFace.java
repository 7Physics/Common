package fr.setphysics.common.geom.shape;

import fr.setphysics.common.geom.Shape;
import fr.setphysics.common.geom.Vec3;

/**
 * Forme avec des faces arrondies
 */
public abstract class RoundedFace extends Shape {

    /**
     * Positionnement d'un point sur la surface du cercle a partir d'un point sur
     * la surface du carre.
     *
     * @param pointOnSquare : point present sur la surface du carre
     * @return point sur la surface du cercle
     */
    protected Vec3 pointOnCircle(Vec3 pointOnSquare, double radius) {
        // Rapport entre le rayon du cercle et la distance entre le centre du carre et
        // le point donne en parametre
        double ratio = radius / Math.sqrt(
                Math.pow(pointOnSquare.getX(), 2) + Math.pow(pointOnSquare.getZ(), 2));

        return new Vec3(pointOnSquare.getX() * ratio, pointOnSquare.getY(), pointOnSquare.getZ() * ratio);
    }

    /**
     * Calcul des coordonnées au milieu d'un segment
     *
     * @param a    : extremite d'un segment
     * @param b    : extremite d'un segment
     * @return milieu du segment
     */
    protected Vec3 findMiddle(Vec3 a, Vec3 b) {
        return new Vec3((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2, (a.getZ() + b.getZ()) / 2);
    }
}
