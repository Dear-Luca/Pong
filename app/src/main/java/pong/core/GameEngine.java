package pong.core;

import java.util.logging.*;

public class GameEngine {
    private long period = 6_944_444; /* 7 ms =~ 144 frame al secondo al piu` */

    private Logger logger = Logger.getLogger("GameEngine");

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
    }
}
