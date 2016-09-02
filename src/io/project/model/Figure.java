package io.project.model;

public enum	Figure {
	X("X"), O("Y");
	
	private final String name;

	private Figure(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
}
