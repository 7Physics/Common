package fr.setphysics.common.geom;

/**
 * Position du centre de la forme
 */
public class Position {
    /** horizontalAngle angle sur l'axe des abscisses */
    private double horizontalAngle;
    /** verticalAngle angle sur l'axe des ordonnées */
    private double verticalAngle;
    /** coords coordonnées */
    private Vec3 coords;

    /**
     * Renvoi l'angle sur l'abscisse
     * @return horizontalAngle
     */
    public double getHorizontalAngle() {
        return horizontalAngle;
    }

    /**
     * Renvoi l'angle sur l'ordonnée
     * @return verticalAngle
     */
    public double getVerticalAngle() {
        return verticalAngle;
    }

    /**
     * Changer la valeur des angles
     * @param horizontalAngle double
     * @param verticalAngle double
     */
    public void setAngles(double horizontalAngle, double verticalAngle) {
        this.horizontalAngle = horizontalAngle;
        this.verticalAngle = verticalAngle;
    }

    /**
     * Renvoi les coordonnées
     * @return coords
     */
    public Vec3 getCoords() {
        return coords;
    }

    /**
     * Changer des coordonnées
     * @param coords Vect3
     */
    public void setCoords(Vec3 coords) {
        this.coords = coords;
    }
}
