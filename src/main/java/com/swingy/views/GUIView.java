package com.swingy.views;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * GUIView
 */
public class GUIView {
	private JFrame frame;
	private JPanel panel;

	GUIView() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(900, 600));
	}

	public JFrame getFrame() {
		return this.frame;
	}

	public void show() {
		this.frame.setVisible(true);
	}
}
