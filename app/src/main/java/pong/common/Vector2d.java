package pong.common;

import java.io.Serializable;

public class Vector2d implements Serializable {
    private final double x;
    private final double y;

    public Vector2d(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d(Point2d to, Point2d from){
        this.x=to.getX()-from.getX();
        this.y=to.getY()-from.getY();
    }

    public Vector2d add(final Vector2d vet) {
        return new Vector2d(x + vet.getX(), y + vet.getY());
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public Vector2d mul(double fact) {
        return new Vector2d(x * fact, y * fact);
    }
   
    public double module(){
        return (double)Math.sqrt(x*x+y*y);
    }

    @Override
    public String toString() {
        return "P2d(" + x + "," + y + ")";
    }
}
