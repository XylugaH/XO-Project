package io.project.model;

import io.project.model.exceptions.InvalidPointException;

public class Field {
	private final int size;

	private final Figure[][] figures;
	
		
	public Field(final int size) {
		this.size = size;
		this.figures = new Figure[size][size];
	}

	public int getSize(){
		return size;
	}
	
	public Figure getFigure(final Point point) throws InvalidPointException{
		if (!checkPoint(point)){
			throw new InvalidPointException();
		}
		return figures[point.getX()][point.getY()];
	}
	
	public boolean setFigure(final Point point, final Figure figure) throws InvalidPointException {
		if (!checkPoint(point)){
			throw new InvalidPointException();
		}

		figures[point.getX()][point.getY()] = figure;
		return true;
	}
	
	private boolean checkPoint(final Point point){
		return chekCoordinate(point.getX()) && chekCoordinate(point.getY());
	}
	
	private boolean chekCoordinate(final int coordinate){
		return coordinate > 0 && coordinate <= size;
	}
}
