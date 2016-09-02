package io.project.model;

public class Game {
	private final Field field;
	
	private final Player[] players;
	
	private final String name;

	public Game(final Field field, final Player[] players, final String name) {
		this.field = field;
		this.players = players;
		this.name = name;
	}

	public Field getField() {
		return field;
	}

	public Player[] getPlayers() {
		return players;
	}

	public String getName() {
		return name;
	}
	
	
	
	
}
