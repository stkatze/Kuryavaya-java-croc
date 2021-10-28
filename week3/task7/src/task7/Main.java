package task7;

public class Main {
	public static void main(String[] args) throws IllegalPositionException {
		try {
			ChessPosition pos1 = new ChessPosition(4, 2);
			System.out.println(pos1);
			System.out.println("Объект строкового представления фигуры: " + pos1);
			ChessPosition.parse(pos1.toString());

			ChessPosition pos2 = new ChessPosition("g8");

			ChessPosition pos3 = new ChessPosition("e7");

			ChessPosition pos4 = new ChessPosition("e6");

			ChessPosition pos5 = new ChessPosition("c8");

			ChessPosition[] knight1 = { pos2, pos3, pos4 };
			Knight.isKnightMoveIsPossible(knight1);

			ChessPosition[] knight2 = { pos2, pos3, pos5 };
			Knight.isKnightMoveIsPossible(knight2);

			ChessPosition pos6 = new ChessPosition(-2, 9);
			System.out.println(pos6);
		} catch (IllegalPositionException e) {
			System.out.println(e.toString());
		}
	}

}
