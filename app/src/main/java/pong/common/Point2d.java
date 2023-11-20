package pong.common;

import java.io.Serializable;

public class Point2d implements Serializable {
    private final double x;
    private final double y;

    public Point2d(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public Point2d add(final Vector2d vet){
        return new Point2d(x+vet.getX(), y+vet.getY());
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    @Override
    public String toString(){
        return "P2d(" + x + "," + y + ")";
    }
}
