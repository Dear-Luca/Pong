package pong.input.impl;

import pong.common.Vector2d;
import pong.input.api.Command;
import pong.model.impl.Paddel;
import pong.model.impl.World;

public class MoveUp implements Command {

    @Override
    public void execute(World world, Paddel paddel) {
        double speed = paddel.getCurrentSpeed().module();
        paddel.setSpeed(new Vector2d(0, -1).mul(speed));
    }
}
