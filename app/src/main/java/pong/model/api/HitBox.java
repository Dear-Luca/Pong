package pong.model.api;

import java.util.Set;

import pong.common.Point2d;

public interface HitBox {
    
    /**
     * Method that controls if a certain point is on the hitbox
     * @param point
     * @return true if the point is effectively in the hitbox
     */
    boolean isInMyHitBox(Point2d point);

    /**
     * Method that controlls wheather something is colliding or not
     * with the ball
     * @return true if something is colliding with this
     */
    boolean isCollidingWith(HitBox collidingObj);

    /**
     * 
     * @return list of the more important points of the hitbox
     */
    Set<Point2d> simplePointBox();
}
