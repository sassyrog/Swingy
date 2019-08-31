package com.swingy.views;

/**
 * TypeWriter
 */
public class TypeWriter {

	public TypeWriter(String text) {
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

	public TypeWriter(String text, int fps) {
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
