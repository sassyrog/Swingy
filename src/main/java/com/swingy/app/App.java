package com.swingy.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Hello world!
 *
 */

public class App {

	public static void main(String[] args) {
		final JFrame frame = new JFrame("Swingy GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(900, 600));
		frame.getContentPane().setBackground(Color.BLACK);

		frame.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				frame.dispose();
				System.out.println("key : " + e.getKeyCode());
			}

			public void keyReleased(KeyEvent e) {
			}
		});
		JButton btn = new JButton("Ok");
		// btn.setBackground(Color.GREEN);
		btn.setSize(new Dimension(50, 30));
		frame.add(btn);
		frame.pack();
		frame.setVisible(true);
	}

}
