package io.project.view;

import io.project.model.Field;
import io.project.model.Figure;
import io.project.model.Game;
import io.project.model.Point;
import io.project.model.exceptions.InvalidPointException;

public class ConsoleView {
	
	public void show(final Game game){
		Field field = game.getField();
		for (int y = 0; y < field.getSizeY(); y++) {
			printLine(field, y);
		}
	}
	

	public void move(final Game game){
		
	}
	
	private void printLine(final Field field, final int y) {
		System.out.println('|');
		for (int x = 0; x < field.getSizeX(); x++) {
			final Figure figure;
			try {
				figure = field.getFigure(new Point(x, y));
			} catch (InvalidPointException e) {
				throw new RuntimeException(e);
			}
			System.out.println(figure != null ? figure.getName() : " ");
			System.out.println('|');
		}
	}
	
	private void printSeparator(final Field field){
		
	}
}
