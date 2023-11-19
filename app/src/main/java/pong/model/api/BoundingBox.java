package pong.model.api;

import java.awt.geom.Point2D;

public interface BoundingBox {
    
    /**
     * Class that controlls wheather something is colliding or not
     * with the ball
     * @return true if something is colliding with this
     */
    boolean isCollidingWith(Point2D p, long radius);
}
