package pong.common;

import java.io.Serializable;

public class Point2d implements Serializable {
    private final long x;
    private final long y;

    public Point2d(final long x, final long y) {
        this.x = x;
        this.y = y;
    }

    public Point2d add(final Vector2d vet){
        return new Point2d(x+vet.getX(), y+vet.getY());
    }

    public long getX(){
        return this.x;
    }

    public long getY(){
        return this.x;
    }

    @Override
    public String toString(){
        return "P2d(" + x + "," + y + ")";
    }
}
