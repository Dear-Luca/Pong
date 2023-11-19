package pong.model.impl;

import java.util.List;

import pong.model.api.GameObject;

import java.util.ArrayList;

public class World {
    private List<Paddel> padList;
    private Ball ball;

    public World() {
        padList = new ArrayList<Paddel>();
    }

    public void updateState(long dt) {
        for (Paddel pad : padList) {
            pad.updatePosition(dt);
        }

        ball.updatePosition(dt);
    }

    public List<GameObject> getSceneEntities() {
        List<GameObject> entities = new ArrayList<>();
        entities.addAll(padList);
        entities.add(ball);
        return entities;
    }

    public Paddel getLeftPaddel() {
        return padList.get(0);
    }

    public Paddel getRightPaddel() {
        return padList.get(1);
    }

    public void setLeftPaddel(Paddel LeftPaddel) {
        this.padList.set(0, LeftPaddel);
    }

    public void setRightPaddel(Paddel RightPaddel) {
        this.padList.set(1, RightPaddel);
    }
}
