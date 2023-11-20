package pong.input.impl;

import pong.common.Vector2d;
import pong.input.api.Command;
import pong.model.impl.Paddel;
import pong.model.impl.World;

public class Stop implements Command {

    private Paddel paddel;

    public Stop(Paddel paddel){
        this.paddel = paddel;
    }

    @Override
    public void execute(World world) {
        paddel.setSpeed(new Vector2d(0, 0));
    }   
}
