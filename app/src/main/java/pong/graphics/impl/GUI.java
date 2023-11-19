package pong.graphics.impl;

import javax.swing.*;


public class GUI {
    private JFrame frame;
    
    public GUI(int width, int height){
        frame = new JFrame("PONG!!");
        frame.setSize(width, height);
        frame.setVisible(true);
    }

}
