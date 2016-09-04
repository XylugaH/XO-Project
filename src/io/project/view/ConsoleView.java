package io.project.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import io.project.controller.CurrentMoveController;
import io.project.controller.MoveController;
import io.project.controller.WinnerController;
import io.project.model.Field;
import io.project.model.Figure;
import io.project.model.Game;
import io.project.model.Point;
import io.project.model.exceptions.AlreadyOccupiedException;
import io.project.model.exceptions.InvalidPointException;

public class ConsoleView {
	private final CurrentMoveController currentMoveController = new CurrentMoveController();
	private final WinnerController winnerController = new WinnerController();
	private final MoveController moveController = new MoveController();
	
	public void show(final Game game){
		final Field field = game.getField();
		System.out.format("Game name: %s\n", game.getName());
		for (int y = 0; y < field.getSizeY(); y++) {
			printLine(field, y);
		}
		printSeparator(game.getField());
	}
	

	public boolean move(final Game game){
		final Field field = game.getField(); 
		final Figure figure = currentMoveController.currentMove(field);
		final Figure winnerFigure = winnerController.getWinner(field);
		if (winnerFigure != null){
			System.out.format("Игра окончена. Победил %s", winnerFigure.getName());
			return false;			
		}
		if (figure == null){
			System.out.println("Игра окончена: Ничья!!!");
			return false;
		}
		System.out.format("Ход игрока %s\n", figure.getName());
		final Point point;
		try{
			 point = getPoint();
		}catch (InputMismatchException e){
			return true;
		}
		try {
			moveController.applyFigure(point, field, figure);
		} catch (AlreadyOccupiedException | InvalidPointException e) {
			System.out.println("Введена неверная координата!!!");
		}
		
		return true;
	}
	
	private Point getPoint(){
		return new Point(getCoordinate("X")-1, getCoordinate("Y")-1);
	}
	
	private int getCoordinate(final String coordinate){
		System.out.format("Пожалуйста введите координату: %s", coordinate);
		final Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	private void printLine(final Field field, final int y) {
		printSeparator(field);
		System.out.print('|');
		for (int x = 0; x < field.getSizeX(); x++) {
			final Figure figure;
			try {
				figure = field.getFigure(new Point(x, y));
			} catch (InvalidPointException e) {
				throw new RuntimeException(e);
			}
			System.out.print(figure != null ? figure.getName() : " ");
			System.out.print('|');
		}
		System.out.println();
	}
	
	private void printSeparator(final Field field){
		final int countSeparators = field.getSizeX()*2+1;
		for (int i = 0; i < countSeparators; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
