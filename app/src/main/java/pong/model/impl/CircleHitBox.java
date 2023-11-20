package pong.model.impl;

import java.util.Set;
import java.util.TreeSet;

import pong.common.Point2d;
import pong.common.Vector2d;
import pong.model.api.HitBox;

public class CircleHitBox implements HitBox {

    private Point2d center;
    private double radius;
    private final static int NUM_OF_POINTS = 12;

    public CircleHitBox(Point2d center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean isCollidingWith(HitBox obj) {
        for (Point2d collidingPoint : obj.simplePointBox()) {
            if(isInMyHitBox(collidingPoint)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isInMyHitBox(Point2d point) {
        return new Vector2d(point, center).module() <= radius;
    }

    @Override
    public Set<Point2d> simplePointBox() {
        Set<Point2d> points = new TreeSet<>();
        double angleIncresement = 2 * Math.PI / NUM_OF_POINTS;
        for (int i = 0; i < NUM_OF_POINTS; i++) {
            double angle = i * angleIncresement;
            double x = center.getX() + radius * Math.cos(angle);
            double y = center.getY() + radius * Math.sin(angle);
            points.add(new Point2d(x, y));
        }
        return points;
    }

}