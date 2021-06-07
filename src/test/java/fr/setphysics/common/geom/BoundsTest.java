package fr.setphysics.common.geom;

import fr.setphysics.common.geom.shape.Cuboid;
import fr.setphysics.common.geom.shape.Sphere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoundsTest {
    @Test
    public void cuboidBounds() {
        Cuboid cuboid = new Cuboid(4, 6, 8);
        Bounds bounds = cuboid.getBounds();
        assertEquals(-2d, bounds.getMinX());
        assertEquals(2d, bounds.getMaxX());

        assertEquals(-4d, bounds.getMinY());
        assertEquals(4d, bounds.getMaxY());

        assertEquals(-3d, bounds.getMinZ());
        assertEquals(3d, bounds.getMaxZ());

        assertEquals(4d, bounds.getWidth());
        assertEquals(6d, bounds.getLength());
        assertEquals(8d, bounds.getHeight());
    }

    @Test
    public void sphereBounds() {
        Sphere sphere = new Sphere(4d, 3);
        Bounds bounds = sphere.getBounds();

        assertEquals(-4d, bounds.getMinX());
        assertEquals(4d, bounds.getMaxX());

        assertEquals(-4d, bounds.getMinX());
        assertEquals(4d, bounds.getMaxX());

        assertEquals(-4d, bounds.getMinX());
        assertEquals(4d, bounds.getMaxX());

        assertEquals(-4d, bounds.getMinX());
        assertEquals(4d, bounds.getMaxX());

        assertEquals(8d, bounds.getWidth());
        assertEquals(8d, bounds.getLength());
        assertEquals(8d, bounds.getHeight());
    }
}
