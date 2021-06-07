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

    public Position(Vec3 coords, double horizontalAngle, double verticalAngle) {
        this.coords = coords;
        this.horizontalAngle = horizontalAngle;
        this.verticalAngle = verticalAngle;
    }

    public Position(Vec3 coords) {
        this(coords, 0, 0);
    }

    public Position(double x, double y, double z) {
        this(x, y, z, 0, 0);
    }

    public Position(double x, double y, double z, double horizontalAngle, double verticalAngle) {
        this(new Vec3(x, y, z), 0, 0);
    }

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
     * Renvoi une copie du vecteur coordonnées
     * @return coords
     */
    public Vec3 getCoords() {
        return coords.clone();
    }

    public double getX() {
        return coords.getX();
    }

    public double getY() {
        return coords.getY();
    }

    public double getZ() {
        return coords.getZ();
    }

    public void setX(double x) {
        coords.setX(x);
    }

    public void setY(double y) {
        coords.setY(y);
    }

    public void setZ(double z) {
        coords.setZ(z);
    }

    /**
     * Changer des coordonnées
     * @param coords Vec3
     */
    public void setCoords(Vec3 coords) {
        this.coords = coords;
    }

    /**
     * Translate cette position
     * @param translation translation
     */
    public void translate(Vec3 translation) {
        this.coords.add(translation);
    }

    /**
     * Translate cette position sur l'axe X
     * @param offset
     */
    public void translateX(double offset) {
        this.coords.addX(offset);
    }

    /**
     * Translate cette position sur l'axe Y
     * @param offset
     */
    public void translateY(double offset) {
        this.coords.addY(offset);
    }

    /**
     * Translate cette position sur l'axe X
     * @param offset
     */
    public void translateZ(double offset) {
        this.coords.addZ(offset);
    }

    /**
     * Tourne l'objet verticalement.
     * @param angle Angle en degrés.
     */
    public void rotateVertical(double angle) {
        this.verticalAngle += angle;
    }

    /**
     * Tourne l'objet horizontalement.
     * @param angle Angle en degrés.
     */
    public void rotateHorizontal(double angle) {
        this.horizontalAngle += angle;
    }

    /**
     * Tourne l'objet.
     * @param hAngle Angle horizontal en degrés.
     * @param vAngle Angle vertical en degrés.
     */
    public void rotate(double hAngle, double vAngle) {
        this.horizontalAngle += hAngle;
        this.verticalAngle += vAngle;
    }
}
