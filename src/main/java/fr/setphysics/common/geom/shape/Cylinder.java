package fr.setphysics.common.geom.shape;

import fr.setphysics.common.geom.Shape;
import fr.setphysics.common.geom.Vec3;

import java.util.ArrayList;
import java.util.List;

public class Cylinder extends Shape {
    private Vec3 centerDown;
    private Vec3 centerUp;
    private double radius;

    public Cylinder(double radius, double height) {
        this.centerDown = new Vec3(0, -height/2, 0);
        this.centerUp = new Vec3(0, height/2, 0);
        this.radius = radius;

        List<Vec3> pointsList = new ArrayList<Vec3>();

        Vec3 a = new Vec3(0, -height/2, radius);
        Vec3 b = new Vec3(radius, -height/2, 0);
        Vec3 c = new Vec3(0, -height/2, -radius);
        Vec3 d = new Vec3(-radius, -height/2, 0);

        Vec3 e = new Vec3(0, height/2, radius);
        Vec3 f = new Vec3(radius, height/2, 0);
        Vec3 g = new Vec3(0, height/2, -radius);
        Vec3 h = new Vec3(-radius, height/2, 0);

        pointsList.addAll(findMiddle(a,b,e,f, 3));
        pointsList.addAll(findMiddle(b,c,f,g, 3));
        pointsList.addAll(findMiddle(c,d,g,h, 3));
        pointsList.addAll(findMiddle(d,a,h,e, 3));

        pointsList.forEach(p -> addVertex(p));

    }

    /**
     * Positionnement d'un point sur la surface de la sphere a partir d'un point sur
     * la surface du cube.
     *
     * @param pointOnSquare : point present sur la surface du cube
     * @return point sur la surface de la sphere
     */
    private Vec3 pointOnCircle(Vec3 pointOnSquare) {
        // Rapport entre le rayon de la sphere et la distance entre le centre du cube et
        // le point donne en parametre
        double ratio = this.radius / Math.sqrt(
                Math.pow(pointOnSquare.getX(), 2) + Math.pow(pointOnSquare.getY(), 2) + Math.pow(pointOnSquare.getZ(), 2));

        return new Vec3(pointOnSquare.getX() * ratio, pointOnSquare.getY(), pointOnSquare.getZ() * ratio);
    }

    /**
     * Calcul des coordonnées au milieu d'un segment
     *
     * @param a    : extremite d'un segment
     * @param b    : extremite d'un segment
     * @return liste des milieux
     */
    private List<Vec3> findMiddle(Vec3 a, Vec3 b, Vec3 e, Vec3 f, int nbIt) {
        List<Vec3> res = new ArrayList<Vec3>();
        if (nbIt > 1) {
            Vec3 mAB = new Vec3((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2, (a.getZ() + b.getZ()) / 2);
            Vec3 mEF = new Vec3((e.getX() + f.getX()) / 2, (e.getY() + f.getY()) / 2, (e.getZ() + f.getZ()) / 2);
            res.addAll(findMiddle(a,pointOnCircle(mAB),e,pointOnCircle(mEF),nbIt -1));
            res.addAll(findMiddle(pointOnCircle(mAB),b,pointOnCircle(mEF),f,nbIt -1));
            return res;
        } else {

            //   *
            // /   \
            // e---f
            // |  /|
            // | / |
            // |/  |
            // a   b
            // \   /
            //   *

            res.add(a);
            res.add(b);
            res.add(f);

            res.add(f);
            res.add(centerUp);
            res.add(e);

            res.add(f);
            res.add(e);
            res.add(a);

            res.add(a);
            res.add(centerDown);
            res.add(b);

            return res;
        }

    }
}