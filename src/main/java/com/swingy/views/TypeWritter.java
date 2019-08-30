package com.swingy.views;

/**
 * TypeWritter
 */
public class TypeWritter {

	public TypeWritter(String text) {
		try {
			for (int i = 0; i < text.length(); i++) {
				System.out.printf("%c", text.charAt(i));
				if (text.charAt(i) == '.')
					Thread.sleep(500);
				else
					Thread.sleep(80);
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	public TypeWritter(String text, int fps) {
		try {
			for (int i = 0; i < text.length(); i++) {
				System.out.printf("%c", text.charAt(i));
				if (text.charAt(i) == '.')
					Thread.sleep(500);
				else
					Thread.sleep(fps);
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
