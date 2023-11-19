package pong.common;

import java.io.Serializable;

public class Vector2d implements Serializable {
    private final double x;
    private final double y;

    public Vector2d(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d add(final Vector2d vet) {
        return new Vector2d(x + vet.getX(), y + vet.getY());
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
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
