package pong.graphics.impl;

import javax.swing.*;

import pong.model.impl.GameState;
import pong.model.impl.World;
import pong.input.api.Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GUI {
    private JFrame frame;
    private PongGamePanel panel;
    private World scene;
    private Controller controller;

    public GUI(World scene, int width, int height) {
        frame = new JFrame("PONG!!");
        frame.setSize(width, height);
        frame.setResizable(false);
        this.scene = scene;
        panel = new PongGamePanel(scene, controller, width, height);
        frame.getContentPane().add(panel);
        // frame.serUndecorated(true);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent ev) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }


    /**
     * Build a new render frame each time is called
     */
    public void render(){
        try {
			frame.repaint();
		} catch (Exception ex){
			ex.printStackTrace();
		}
    }

    public void setInputController(Controller c) {
        panel.setInputController(c);
    }
}
