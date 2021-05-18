package fr.setphysics.common.geom;

/**
 * Vecteur à trois dimentions
 * @param <T> type générique
 */
public class Vec3<T> {
    /** x abscisse de type T */
    private T x;
    /** y ordonnée de type T */
    private T y;
    /** z altitude de type T */
    private T z;

    /**
     * Construire un vecteur à trois dimentions avec des coordonnées
     * @param x abscisse
     * @param y ordonnée
     * @param z altitude
     */
    public Vec3(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
