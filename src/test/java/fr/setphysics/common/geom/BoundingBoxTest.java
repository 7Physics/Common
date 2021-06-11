package fr.setphysics.common.geom;

import fr.setphysics.common.geom.shape.Cuboid;
import fr.setphysics.common.geom.shape.Sphere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoundingBoxTest {
    @Test
    public void cuboidBounds() {
        Cuboid cuboid = new Cuboid(4, 6, 8);
        BoundingBox boundingBox = cuboid.getBoundingBox();
        assertEquals(-2d, boundingBox.getMinX());
        assertEquals(2d, boundingBox.getMaxX());

        assertEquals(-4d, boundingBox.getMinY());
        assertEquals(4d, boundingBox.getMaxY());

        assertEquals(-3d, boundingBox.getMinZ());
        assertEquals(3d, boundingBox.getMaxZ());

        assertEquals(4d, boundingBox.getWidth());
        assertEquals(6d, boundingBox.getLength());
        assertEquals(8d, boundingBox.getHeight());
    }

    @Test
    public void sphereBounds() {
        Sphere sphere = new Sphere(4d, 3);
        BoundingBox boundingBox = sphere.getBoundingBox();

        assertEquals(-4d, boundingBox.getMinX());
        assertEquals(4d, boundingBox.getMaxX());

        assertEquals(-4d, boundingBox.getMinX());
        assertEquals(4d, boundingBox.getMaxX());

        assertEquals(-4d, boundingBox.getMinX());
        assertEquals(4d, boundingBox.getMaxX());

        assertEquals(-4d, boundingBox.getMinX());
        assertEquals(4d, boundingBox.getMaxX());

        assertEquals(8d, boundingBox.getWidth());
        assertEquals(8d, boundingBox.getLength());
        assertEquals(8d, boundingBox.getHeight());
    }
}
