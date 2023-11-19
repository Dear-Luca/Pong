package pong.core;

import java.util.logging.*;

import pong.common.Point2d;
import pong.common.Vector2d;
import pong.graphics.impl.GUI;
import pong.model.impl.Ball;
import pong.model.impl.Paddel;
import pong.model.impl.World;

public class GameEngine {
    private long period = 6_944_444; /* 7 ms =~ 144hz (Standard)*/
    private GUI view;
    private Logger logger = Logger.getLogger("GameEngine");
    private World world;

    public void setup(){
        world = new World();
        world.setLeftPaddel(new Paddel(new Point2d(50, 50), new Vector2d(0, 0)));
        world.setRightPaddel(new Paddel(new Point2d(200, 200), new Vector2d(0, 0)));
        world.setBall(new Ball(new Point2d(250, 300), new Vector2d(3, 3)));
        view = new GUI(world,500, 600);
    }

    public void mainLoop() {
        long previousCycleStartTime = System.nanoTime();
        while (true) {
            long currentCycleStartTime = System.nanoTime();
            long elapsed = currentCycleStartTime - previousCycleStartTime;
            processInput();
            /* move on the game state of elapsed time */
            updateGame(elapsed);
            render();
            waitForNextFrame(currentCycleStartTime);
            previousCycleStartTime = currentCycleStartTime;
        }
    }

    /**
     * Take a little nap to synch with the frame rate
     * 
     * @param current
     */
    protected void waitForNextFrame(long cycleStartTime) {
        if (System.nanoTime() - cycleStartTime < period) {
            try {
                while (System.nanoTime() - cycleStartTime < period) {
                    Thread.onSpinWait();
                }
            } catch (Exception ex) {
            }
        }
    }

    /**
     * Processing the input of the game got in a cycle.
     */
    protected void processInput() {
        logger.log(Level.INFO, "..process input..");
    }

    /**
     * Update the state of the game, given the amount of time elapsed wrt previous
     * cycle.
     * 
     * @param elapsed
     */
    protected void updateGame(long elapsed) {
        logger.log(Level.INFO, "..update game: elapsed " + elapsed + "... Framerate: "
                + Math.round(1_000_000_000.0 / elapsed) + " / 144");
    }

    /**
     * Rendering of the game in a cycle.
     */
    protected void render() {
        logger.log(Level.INFO, "..render..");
        view.render();
    }
}
