package com.swingy.models;

/**
 * Position
 */
public class Position {
	private int _x;
	private int _y;
	private int _size;

	public Position(int level) {
		this._size = (level - 1) * 5 + 10 - (level % 2);
		this._x = this._size / 2;
		this._y = this._size / 2;
	}

	public void setX(int x) {
		this._x = x;
	}

	public void setY(int y) {
		this._y = y;
	}

	public int getX() {
		return this._x;
	}

	public int getY() {
		return this._y;
	}

	public int getSize() {
		return this._size;
	}
}
