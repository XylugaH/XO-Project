package io.project.controller;

import io.project.model.Field;
import io.project.model.Figure;
import io.project.model.Point;
import io.project.model.exceptions.InvalidPointException;

public class WinnerController {
	
	public Figure getWinner(final Field field){
		try {
			for (int i = 0; i < field.getSizeX(); i++) {
				if (check(field, new Point(i, 0), p -> new Point(p.getX(), p.getY()+1)))
					return field.getFigure(new Point(i, 0)); 
			}
			
			for (int i = 0; i < field.getSizeY(); i++) {
				if (check(field, new Point(0, i), p -> new Point(p.getX()+1, p.getY())))
					return field.getFigure(new Point(0, i)); 
			}
			
			for (int i = 0; i < field.getSizeY(); i++) {
				if (check(field, new Point(0, 0), p -> new Point(p.getX()+1, p.getY()+1)))
					return field.getFigure(new Point(0, 0));
			}
		
			for (int i = 0; i < field.getSizeY(); i++) {
				if (check(field, new Point(0, field.getSizeY()-1), p -> new Point(p.getX()+1, p.getY()-1)))
					return field.getFigure(new Point(0, field.getSizeY()-1));
			}
			
		} catch (InvalidPointException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	private boolean check (final Field field, final Point currentPoint, final IPointGenerator pointGenerator){
		final Figure currentFigure;
		final Figure nextFigure;
		final Point nextPoint = pointGenerator.nextPoint(currentPoint);
		try {
			currentFigure = field.getFigure(currentPoint);
			nextFigure = field.getFigure(nextPoint);
		} catch (final InvalidPointException e) {
			return true;
		}
		
		if (currentFigure == null) return false;
		
		if (currentFigure != nextFigure) return false;
		
		return check(field, nextPoint, pointGenerator);
	}
	
	private interface IPointGenerator{
		public Point nextPoint(final Point point);
	}
	
}
