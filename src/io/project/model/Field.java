package io.project.model;

import io.project.model.exceptions.InvalidPointException;

public class Field {
	private final int sizeX;
	private final int sizeY;

	private final Figure[][] figures;
	
		
	public Field(final int sizeX, final int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.figures = new Figure[sizeX][sizeY];
	}


	public int getSizeX() {
		return sizeX;
	}


	public int getSizeY() {
		return sizeY;
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
		return chekCoordinateX(point.getX()) && chekCoordinateY(point.getY());
	}
	
	private boolean chekCoordinateX(final int coordinate){
		return coordinate > 0 && coordinate <= sizeX;
	}
	
	private boolean chekCoordinateY(final int coordinate){
		return coordinate > 0 && coordinate <= sizeY;
	}	
}
