package fr.setphysics.common.geom;

import java.util.Objects;

/**
 * Vecteur à trois dimensions
 */
public class Vec3 implements Cloneable{
    public static Vec3 ZERO() {
        return new Vec3(0, 0, 0);
    }

    /** x abscisse */
    private double x;
    /** y ordonnée */
    private double y;
    /** z profondeur*/
    private double z;

    /**
     * Construire un vecteur à trois dimentions avec des coordonnées
     * @param x abscisse
     * @param y ordonnée
     * @param z profondeur
     */
    public Vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Obtenir l'abscisse de ce vecteur.
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     * Obtenir l'ordonnée de ce vecteur.
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     * Obtenir la profondeur de ce vecteur.
     * @return
     */
    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Retourne le produit vectoriel de ce vecteur par un autre
     *
     * @param other
     * @return
     */
    public Vec3 multiply(Vec3 other) {
        return new Vec3(
                this.y * other.z - this.z * other.y,
                this.z * other.x - this.x * other.z,
                this.x * other.y - this.y * other.x
        );
    }

    /**
     * Soustraie les coordonnées d'un autre vecteur à ce vecteur.
     * @param vec3 Vecteur à soustraire.
     */
    public Vec3 minus(Vec3 vec3) {
        this.x -= vec3.x;
        this.y -= vec3.y;
        this.z -= vec3.z;
        return this;
    }

    /**
     * Ajoute les coordonnées d'un autre vecteur à ce vecteur.
     * @param vec3 Vecteur à ajouter.
     */
    public Vec3 add(Vec3 vec3) {
        this.x += vec3.x;
        this.y += vec3.y;
        this.z += vec3.z;
        return this;
    }

    public Vec3 addX(double x) {
        this.x += x;
        return this;
    }

    public Vec3 addY(double y) {
        this.y += y;
        return this;
    }

    public Vec3 addZ(double z) {
        this.z += z;
        return this;
    }

    /**
     * Multiplie les coordonnées de ce vecteur par un facteur.
     * @param factor Facteur de multiplication.
     */
    public Vec3 scale(double factor) {
        this.x *= factor;
        this.y *= factor;
        this.z *= factor;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vec3 vec3 = (Vec3) o;
        return Double.compare(vec3.x, x) == 0 && Double.compare(vec3.y, y) == 0 && Double.compare(vec3.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    /**
     * Retourne une copie de ce vecteur.
     */
    @Override
    public Vec3 clone() {
        return new Vec3(this.x, this.y, this.z);
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
