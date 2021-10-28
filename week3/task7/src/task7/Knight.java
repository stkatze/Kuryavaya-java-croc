package task7;

import java.util.Arrays;

public class Knight {

	public static boolean CorrectMove(ChessPosition p1, ChessPosition p2) {
		return Math.abs(p2.getX() - p1.getX()) == 2 && Math.abs(p2.getY() - p1.getY()) == 1
				|| Math.abs(p2.getX() - p1.getX()) == 1 && Math.abs(p2.getY() - p1.getY()) == 2;
	}

	public static void doSomeMoves(ChessPosition[] positions) throws IllegalMoveException {
		for (int i = 0; i < positions.length - 1; i++) {
			ChessPosition position1 = positions[i];
			ChessPosition position2 = positions[i + 1];
			if (!CorrectMove(position1, position2))
				throw new IllegalMoveException(position1, position2);
		}
	}

	public static void isKnightMoveIsPossible(ChessPosition[] stringPositions) throws IllegalPositionException {
		System.out.println("[in]  " + Arrays.toString(stringPositions));

		System.out.print("[out]  ");
		try {
			Knight.doSomeMoves(stringPositions);
			System.out.println("OK");
		} catch (IllegalMoveException e) {
			System.out.println(e);
		}
	}
}