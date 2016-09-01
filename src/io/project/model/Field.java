package io.project.model;

import java.awt.Point;

public class Field {
	public static final int FIELD_SIZE = 3;
	
	private final Figure[][] figures = new Figure[FIELD_SIZE][FIELD_SIZE];
	
	public int getSize(){
		return FIELD_SIZE;
	}
	
	public Figure getFigure(final Point point){
		return figures[point.x][point.y];
	}
	
	public boolean setFigure(final Point point, final Figure figure){
		figures[point.x][point.y] = figure;
		return true;
	}
}
