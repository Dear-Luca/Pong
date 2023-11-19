package pong.graphics.impl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.awt.Color;

import javax.swing.JPanel;

import pong.common.Point2d;
import pong.model.api.GameObject;
import pong.model.impl.Ball;
import pong.model.impl.Paddel;
import pong.model.impl.World;

public class PongGamePanel extends JPanel {

    private World scene;

    public PongGamePanel(World scene, int w, int h) {
        this.scene = scene;
        setSize(w, h);
        this.addKeyListener(new PaddleMover());
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        requestFocusInWindow();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2.clearRect(0, 0, this.getWidth(), this.getHeight());

        for(GameObject entity: scene.getSceneEntities()){
            Point2d pos = entity.getCurrentPosition();
            if(entity instanceof Ball){
                g2.setColor(Color.BLACK);
                g2.fillOval((int)pos.getX()-20, (int)pos.getY()-20, 40, 40);
            }else if(entity instanceof Paddel){
                g2.setColor(Color.DARK_GRAY);
                g2.fillRect((int)pos.getX()-20, (int)pos.getY()-20, 40, 40);
            }
        }
    }

    private class PaddleMover implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
        }

    }
}
