package pong.graphics.impl;

import javax.swing.*;

import pong.model.impl.World;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GUI {
    private JFrame frame;
    /*private ScenePanel panel;
    private GameState scene;
    private Controller controller;*/


    public GUI(/*World scene,*/ int width, int height){
        frame = new JFrame("PONG!!");
        frame.setSize(width, height);
        frame.setResizable(false);
        //this.scene=scene;
        //frame.serUndecorated(true);
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

}
