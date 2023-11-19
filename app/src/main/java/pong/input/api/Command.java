package pong.input.api;

import pong.model.impl.Paddel;
import pong.model.impl.World;

public interface Command {
    void execute(World world, Paddel paddel);
} 
