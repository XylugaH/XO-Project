package io.project.controller;

import io.project.model.Field;
import io.project.model.Figure;
import io.project.model.Point;
import io.project.model.exceptions.InvalidPointException;

public class CurrentMoveController {
	
	public Figure currentMove(final Field field){
		int countFigure = 0;
		
		for (int i = 0; i < field.getSizeX(); i++) {
			for (int j = 0; j < field.getSizeY(); j++) {
				try {
					Figure figure = field.getFigure(new Point(i, j));
					if (figure != null) countFigure++;
				} catch (InvalidPointException e) {
					e.printStackTrace();
				}
			}
		}
		
		if (countFigure == field.getSizeX()*field.getSizeY())
			return null;
		
		if (countFigure % 2 == 0)
				return Figure.X;

		return Figure.O;

	}

}
