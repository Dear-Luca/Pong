package pong.input.api;

import pong.model.impl.World;

public interface Command {
    /**
     * execute the command (move up or move down to the given paddel)
     * @param world
     * @param paddel
     */
    void execute(World world);
} 
