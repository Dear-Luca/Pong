package pong.common;

import java.io.Serializable;

public class Vector2d implements Serializable {
    private final long x;
    private final long y;

    public Vector2d(final long x, final long y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d(final double x, final double y) {
        this.x = (long) x;
        this.y = (long) y;
    }

    public Vector2d add(final Vector2d vet) {
        return new Vector2d(x + vet.getX(), y + vet.getY());
    }

    public long getX() {
        return this.x;
    }

    public long getY() {
        return this.x;
    }

    public Vector2d mul(double fact) {
        return new Vector2d(x * fact, y * fact);
    }

    @Override
    public String toString() {
        return "P2d(" + x + "," + y + ")";
    }
}
