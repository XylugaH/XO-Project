import io.project.controller.WinnerController;
import io.project.model.Field;
import io.project.model.Figure;
import io.project.model.Game;
import io.project.model.Player;
import io.project.model.Point;
import io.project.model.exceptions.InvalidPointException;
import io.project.view.ConsoleView;

public class Main {

	public static void main(String[] args) throws InvalidPointException {
		final String name1 = "������";
		final String name2 = "����";
		final String nameGame = "��������-������";
		final Player[] players = new Player[] {new Player(name1, Figure.X), new Player(name2, Figure.O)};
		final Field field = new Field(3, 3);
		final Game game = new Game(field, players, nameGame);
		final ConsoleView consoleView = new ConsoleView();
		while(consoleView.move(game)){
			consoleView.show(game);
			{}
		}
		
	}

}
