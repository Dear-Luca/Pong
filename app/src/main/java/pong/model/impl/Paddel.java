package pong.model.impl;

import pong.common.Point2d;
import pong.common.Vector2d;
import pong.model.api.GameObject;

public class Paddel implements GameObject{

    private static double NS = 0.000_000_001;
    private Point2d position;
    private Vector2d speed;
    private final double leght;
    private final double width;


    public Paddel(Point2d position, Vector2d speed, double lenght, double width){
        this.position = position;
        this.speed = speed;
        this.leght = lenght;
        this.width =width;
    }

    @Override
    public Point2d getCurrentPosition() {
        return this.position;
    }

    public double getLenght(){
        return leght;
    }

    public double getWidth(){
        return width;
    }

    @Override
    public Vector2d getCurrentSpeed() {
       return this.speed;
    }

    @Override
    public void setPosition(Point2d position) {
       this.position = position; 
    }

    @Override
    public void setSpeed(Vector2d speed) {
        this.speed = speed;
    }

    @Override
    public void updatePosition(long delta) {
        this.position = this.position.add(speed.mul(NS*delta));
    }
    
}
