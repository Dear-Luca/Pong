/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package pong;

import pong.core.GameEngine;

public class Pong {
    public static void main(String[] args) {
		GameEngine engine = new GameEngine();
		engine.setup();
		engine.mainLoop();
	}
}
