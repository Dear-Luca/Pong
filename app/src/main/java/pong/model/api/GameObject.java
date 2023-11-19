package pong.model.api;

import pong.common.Point2d;
import pong.common.Vector2d;

public interface GameObject {
    /**
     * Set the position of the object in the Frame
     * @param position
     */
    public void setPosition(Point2d position);

    /**
     * Set the speed of the object
     * @param speed
     */
    public void setSpeed(Vector2d speed);

    /**
     * Change the position of the object
     * @param delta
     */
    public void updatePosition(long delta);

    /**
     * Return the current speed of the object
     * @return
     */
    public Vector2d getCurrentSpeed();

    /**
     * Return the current position of the object
     * @return
     */
    public Point2d getCurrentPosition();

}
