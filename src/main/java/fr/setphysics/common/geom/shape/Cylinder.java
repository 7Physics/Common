package fr.setphysics.common.geom.shape;

import fr.setphysics.common.geom.Shape;
import fr.setphysics.common.geom.Vec3;

import java.util.ArrayList;
import java.util.List;

public class Cylinder extends RoundedFace {
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

        pointsList.addAll(findPoints(a,b,e,f, 3));
        pointsList.addAll(findPoints(b,c,f,g, 3));
        pointsList.addAll(findPoints(c,d,g,h, 3));
        pointsList.addAll(findPoints(d,a,h,e, 3));

        pointsList.forEach(p -> addVertex(p));

    }

    /**
 	 * Calcul des points necessaires a la separation d'une face.
    *
     * @param a    : point de la face inferieure
     * @param b    : point de la face inferieure
     * @param e    : point de la face superieure
     * @param f    : point de la face superieure
     * @return liste des points desormais presents
     */
    private List<Vec3> findPoints(Vec3 a, Vec3 b, Vec3 e, Vec3 f, int nbIt) {
        List<Vec3> res = new ArrayList<Vec3>();
        if (nbIt > 1) {

            Vec3 mAB = findMiddle(a, b);
            Vec3 mEF = findMiddle(e, f);
            res.addAll(findPoints(a,pointOnCircle(mAB, this.radius),e,pointOnCircle(mEF, this.radius),nbIt -1));
            res.addAll(findPoints(pointOnCircle(mAB, this.radius),b,pointOnCircle(mEF, this.radius),f,nbIt -1));
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