package com.crivera.TakenGame.model;

public enum Move {

	UP(1),
	DOWN(4),
	LEFT(2),
	RIGHT(3);
	
	private final int value;

	private Move(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	
	
	
}
