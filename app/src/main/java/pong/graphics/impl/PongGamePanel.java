package pong.graphics.impl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

import javax.swing.JPanel;

import pong.common.Point2d;
import pong.input.api.Controller;
import pong.input.impl.MoveDown;
import pong.input.impl.MoveUp;
import pong.input.impl.Stop;
import pong.model.api.GameObject;
import pong.model.impl.Ball;
import pong.model.impl.Paddel;
import pong.model.impl.World;

public class PongGamePanel extends JPanel {

    private World scene;
    private Controller controller;

    public PongGamePanel(World scene, Controller controller, int w, int h) {
        this.scene = scene;
        setSize(w, h);
        this.addKeyListener(new PaddleMover());
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        requestFocusInWindow();
        this.controller = controller;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.clearRect(0, 0, this.getWidth(), this.getHeight());

        for (GameObject entity : scene.getSceneEntities()) {
            Point2d pos = entity.getCurrentPosition();
            if (entity instanceof Ball) {
                Ball ball = (Ball) entity;
                g2d.setColor(Color.BLACK);
                g2d.fillOval((int) pos.getX() - 20, (int) pos.getY() - 20, (int) ball.getRadius() / 2,
                        (int) ball.getRadius() / 2);
            } else if (entity instanceof Paddel) {
                Paddel paddel = (Paddel) entity;
                g2d.setColor(Color.DARK_GRAY);
                g2d.fillRect((int) pos.getX() - 20, (int) pos.getY() - 20, (int)paddel.getWidth(), (int)paddel.getLenght());
            }
        }
    }

    public void setInputController(Controller c) {
        controller = c;
    }

    private class PaddleMover implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                controller.notifyCommand(new MoveUp(scene.getLeftPaddel()));
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                controller.notifyCommand(new MoveUp(scene.getRightPaddel()));
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                controller.notifyCommand(new MoveDown(scene.getLeftPaddel()));
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                controller.notifyCommand(new MoveDown(scene.getRightPaddel()));
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                controller.notifyCommand(new Stop(scene.getLeftPaddel()));
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                controller.notifyCommand(new Stop(scene.getRightPaddel()));
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                controller.notifyCommand(new Stop(scene.getLeftPaddel()));
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                controller.notifyCommand(new Stop(scene.getRightPaddel()));
            }
        }

    }
}
