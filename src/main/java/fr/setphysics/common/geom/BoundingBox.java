package fr.setphysics.common.geom;

/**
 * Classe représent la boîte englobant un objet.
 */
public class BoundingBox implements Cloneable {
    private double minX, maxX;
    private double minY, maxY;
    private double minZ, maxZ;

    public BoundingBox(double minX, double maxX, double minY, double maxY, double minZ, double maxZ) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.minZ = minZ;
        this.maxZ = maxZ;
    }

    public BoundingBox() {
    }

    /**
     * Adapte le boîte de façon à contenir le point.
     * @param point Point
     */
    void addPoint(Vec3 point) {
        if(point.getX() < minX) {
            minX = point.getX();
        }else if(point.getX() > maxX){
            maxX = point.getX();
        }

        if(point.getY() < minY) {
            minY = point.getY();
        }else if(point.getY() > maxY){
            maxY = point.getY();
        }

        if(point.getZ() < minZ) {
            minZ = point.getZ();
        }else if(point.getZ() > maxZ){
            maxZ = point.getZ();
        }
    }

    public double getMinX() {
        return minX;
    }

    public double getMaxX() {
        return maxX;
    }

    /**
     * @return Largeur de la boîte (axe X)
     */
    public double getWidth() {
        return maxX - minX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxY() {
        return maxY;
    }

    /**
     * @return Hauteur de la boîte (axe Y)
     */
    public double getHeight() {
        return maxY - minY;
    }

    public double getMinZ() {
        return minZ;
    }

    public double getMaxZ() {
        return maxZ;
    }

    /**
     * @return Longueur de la boîte (axe Z)
     */
    public double getLength() {
        return maxZ - minZ;
    }

    /**
     * @param other Autre boîte avec laquelle tester l'intersection
     * @return true si cette boîte intersecte avec other.
     */
    public boolean intersect(BoundingBox other) {
        return (this.minX <= other.maxX && this.maxX >= other.minX) &&
                (this.minY <= other.maxY && this.maxY >= other.minY) &&
                (this.minZ <= other.maxZ && this.maxZ >= other.minZ);
    }

    /**
     * @param point Point dont il faut tester l'appartenance
     * @return true si cette boîte contient point.
     */
    public boolean containsPoint(Vec3 point) {
        return (point.getX() >= this.minX && point.getX() <= this.maxX) &&
                (point.getY() >= this.minY && point.getY() <= this.maxY) &&
                (point.getZ() >= this.minZ && point.getZ() <= this.maxZ);
    }

    /**
     * Renvoie une nouvelle boîte correspondant à cette boîte translatée
     * @param translation Translation
     * @return Nouvelle boîte translatée
     */
    public BoundingBox translate(Vec3 translation) {
        BoundingBox rep = this.clone();
        rep.minX += translation.getX();
        rep.maxX += translation.getX();

        rep.minY += translation.getY();
        rep.maxY += translation.getY();

        rep.minZ += translation.getZ();
        rep.maxZ += translation.getZ();
        return rep;
    }

    @Override
    public BoundingBox clone() {
        return new BoundingBox(minX, maxX, minY, maxY, minZ, maxZ);
    }

    @Override
    public String toString() {
        return "Bounds{" +
                "minX=" + minX +
                ", maxX=" + maxX +
                ", minY=" + minY +
                ", maxY=" + maxY +
                ", minZ=" + minZ +
                ", maxZ=" + maxZ +
                '}';
    }
}
