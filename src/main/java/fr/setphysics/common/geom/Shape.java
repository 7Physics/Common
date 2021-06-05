package fr.setphysics.common.geom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Forme en trois dimensions
 */
public class Shape {
    /** Liste de vecteurs trois dimentions composant la forme */
    protected List<Vec3> vertices;

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
    }

    /**
     * Ajoute un sommet à la forme.
     * @param vertex Sommet à ajouter.
     */
    protected void addVertex(Vec3 vertex) {
        this.vertices.add(vertex);
    }

    /**
     * Obtenir une vue sur les sommets de cette forme.
     * @return Liste non modifiable de sommets.
     */
    public List<Vec3> getVertices() {
        return Collections.unmodifiableList(this.vertices);
    }
    
    /**
     * Obtenir la coordonnée Y minimale de la forme
     * afin de pouvoir détecter le sol.
     * @return la coordonnée Y minimale
     */
    public double getMinY() {
    	double min = this.vertices.get(0).getY();
    	for(int i = 1; i<this.vertices.size(); i++) {
    		double currentY = this.vertices.get(i).getY();
    		if(currentY < min) {
    			min = currentY;
    		}
    	}
    	return min;
    }
    
    /**
     * Créer deux triangles à partir d'un carré.
     * @param a premier sommet du carré
     * @param b deuxieme sommet du carré
     * @param c troisieme sommet du carré
     * @param d quatrième sommet du carré
     */
    protected void addSquare(Vec3 a, Vec3 b, Vec3 c, Vec3 d) {
    	// Premier triangle
    	addVertex(a);
    	addVertex(b);
    	addVertex(c);
    	
    	// Deuxième triangle
    	addVertex(a);
    	addVertex(c);
    	addVertex(d);
    }
}
