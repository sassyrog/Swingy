package com.swingy.app;

/**
 * Hello world!
 *
 */

 import java.awt.*;

 import javax.swing.JFrame;
 import javax.swing.JLabel;

public class App
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame("Roger");



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("I'm here");
        label.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(label, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        // jFrame.setBackground(new Color(255));

        System.out.println( "Hello World!" );
    }
}
