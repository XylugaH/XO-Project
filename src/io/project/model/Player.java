package io.project.model;

public class Player {
	private String name;
	private Figure figure;
	
	public Player(final String name, final Figure figure) {
		this.name = name;
		this.figure = figure;
	}

	public String getName() {
		return name;
	}

	public Figure getFigure() {
		return figure;
	}
	
	
	
}
