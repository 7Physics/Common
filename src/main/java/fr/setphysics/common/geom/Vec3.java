package main.java.fr.setphysics.common.geom;

/**
 * Vecteur à trois dimentions
 */
public class Vec3 {
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
}
