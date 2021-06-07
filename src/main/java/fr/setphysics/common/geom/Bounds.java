package fr.setphysics.common.geom;

public class Bounds implements Cloneable {
    private double minX, maxX;
    private double minY, maxY;
    private double minZ, maxZ;

    public Bounds(double minX, double maxX, double minY, double maxY, double minZ, double maxZ) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.minZ = minZ;
        this.maxZ = maxZ;
    }

    public Bounds() {
    }

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

    public double getWidth() {
        return maxX - minX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxY() {
        return maxY;
    }

    public double getHeight() {
        return maxY - minY;
    }

    public double getMinZ() {
        return minZ;
    }

    public double getMaxZ() {
        return maxZ;
    }

    public double getLength() {
        return maxZ - minZ;
    }

    public boolean intersect(Bounds other) {
        return (this.minX <= other.maxX && this.maxX >= other.minX) &&
                (this.minY <= other.maxY && this.maxY >= other.minY) &&
                (this.minZ <= other.maxZ && this.maxZ >= other.minZ);
    }

    public boolean containsPoint(Vec3 point) {
        return (point.getX() >= this.minX && point.getX() <= this.maxX) &&
                (point.getY() >= this.minY && point.getY() <= this.maxY) &&
                (point.getZ() >= this.minZ && point.getZ() <= this.maxZ);
    }

    public Bounds translate(Vec3 translation) {
        Bounds rep = this.clone();
        rep.minX += translation.getX();
        rep.maxX += translation.getX();

        rep.minY += translation.getY();
        rep.maxY += translation.getY();

        rep.minZ += translation.getZ();
        rep.maxZ += translation.getZ();
        return rep;
    }

    @Override
    public Bounds clone() {
        return new Bounds(minX, maxX, minY, maxY, minZ, maxZ);
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
