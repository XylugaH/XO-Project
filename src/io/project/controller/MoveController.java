package io.project.controller;

import io.project.model.Field;
import io.project.model.Figure;
import io.project.model.Point;
import io.project.model.exceptions.AlreadyOccupiedException;
import io.project.model.exceptions.InvalidPointException;

public class MoveController {
	
	public void applyFigure(final Point point, final Field field, final Figure figure) throws AlreadyOccupiedException, InvalidPointException{
			if (field.getFigure(point) !=null){
				new AlreadyOccupiedException();
			}
			
			field.setFigure(point, figure);
		
		return;
	}
}
