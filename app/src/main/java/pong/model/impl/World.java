package pong.model.impl;

import java.util.List;

import pong.common.Point2d;
import pong.model.api.GameObject;

public class World { 
    private Paddel leftPaddel;
    private Paddel rightPaddel;
    private Ball ball;
    

    public World() {
    }

    public void updateState(long dt) {
        leftPaddel.updatePosition(dt);
        rightPaddel.updatePosition(dt);
        ball.updatePosition(dt);

        checkBorders();
    }

    public List<GameObject> getSceneEntities() {
        return List.of(leftPaddel, rightPaddel, ball);
    }

    private void checkBorders(){
        Point2d ballPosition = ball.getCurrentPosition();
        
    }

    public Paddel getLeftPaddel() {
        return leftPaddel;
    }

    public Paddel getRightPaddel() {
        return rightPaddel;
    }

    public void setLeftPaddel(Paddel leftPaddel) {
        this.leftPaddel = leftPaddel;
    }

    public void setRightPaddel(Paddel rightPaddel) {
        this.rightPaddel = rightPaddel;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    private void checkBoundaries(){
        Point2d posBall = ball.getCenter();
        Point2d posPaddleR = rightPaddel.getCurrentPosition();
    }
}
