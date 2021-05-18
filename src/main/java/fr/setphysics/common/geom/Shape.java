package fr.setphysics.common.geom;

import java.awt.*;
import java.util.List;

/**
 * Forme en trois dimentions
 */
public class Shape {
    /** Liste de vecteurs trois dimentions composant la forme */
    private List<Vec3> vertices;
    /** Couleur de la forme */
    private Color color;

    /**
     * Construire une forme à partir des vecteurs et une couleur par défaut
     * @param vertices liste des vecteurs
     */
    public Shape(List<Vec3> vertices) {
        this.vertices = vertices;
        this.color = Color.GRAY;
    }

    /**
     * Construire une forme à partir des vecteurs et une couleur
     * @param vertices liste des vecteurs
     * @param color couleur de la forme
     */
    public Shape(List<Vec3> vertices, Color color) {
        this.vertices = vertices;
        this.color = color;
    }
}
