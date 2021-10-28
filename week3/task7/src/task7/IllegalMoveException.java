package task7;

public class IllegalMoveException extends Exception {
	public final ChessPosition p1;
	public final ChessPosition p2;

	public IllegalMoveException(ChessPosition p1, ChessPosition p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public String toString() {
		return "Неверный ход конем: " + p1 + " -> " + p2;
	}
}