package fr.setphysics.common.geom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Forme en trois dimensions
 */
public class Shape {
    /** Liste de vecteurs trois dimentions composant la forme */
    private List<Vec3> vertices;

    private final Bounds bounds = new Bounds();

    /**
     * Construire une forme à partir des vecteurs et une couleur par défaut
     */
    public Shape() {
        this.vertices = new ArrayList<>();
    }

    /**
     * Construire une forme à partir des vecteurs et une couleur par défaut
     * @param vertices liste des vecteurs
     */
    public Shape(List<Vec3> vertices) {
        this.vertices = vertices;
        for (Vec3 vertex : vertices) {
            bounds.addPoint(vertex);
        }
    }

    /**
     * Ajoute un sommet à la forme.
     * @param vertex Sommet à ajouter.
     */
    protected void addVertex(Vec3 vertex) {
        this.vertices.add(vertex);
        this.bounds.addPoint(vertex);
    }

    /**
     * Obtenir une vue sur les sommets de cette forme.
     * @return Liste non modifiable de sommets.
     */
    public List<Vec3> getVertices() {
        return Collections.unmodifiableList(this.vertices);
    }

    /**
     * Obtenir la boîte englobant la forme.
     * @return
     */
    public Bounds getBounds() {
        return bounds;
    }
}
