package fr.setphysics.common.geom;

/**
 * Position du centre de la forme
 * @param <T> type générique
 */
public class Position<T> {
    /** abscissaAngle angle sur l'axe des abscisses */
    private double abscissaAngle;
    /** ordinateAngle angle sur l'axe des ordonnées */
    private double ordinateAngle;
    /** coords coordonnées */
    private Vec3<T> coords;

    /**
     * Renvoi l'angle sur l'abscisse
     * @return abscissaAngle
     */
    public double getAbscissaAngle() {
        return abscissaAngle;
    }

    /**
     * Renvoi l'angle sur l'ordonnée
     * @return ordinateAngle
     */
    public double getOrdinateAngle() {
        return ordinateAngle;
    }

    /**
     * Changer la valeur des angles
     * @param abscissaAngle double
     * @param ordinateAngle double
     */
    public void setAngles(double abscissaAngle, double ordinateAngle) {
        this.abscissaAngle = abscissaAngle;
        this.ordinateAngle = ordinateAngle;
    }

    /**
     * Renvoi les coordonnées
     * @return coords
     */
    public Vec3<T> getCoords() {
        return coords;
    }

    /**
     * Changer des coordonnées
     * @param coords Vect3<T>
     */
    public void setCoords(Vec3<T> coords) {
        this.coords = coords;
    }
}
