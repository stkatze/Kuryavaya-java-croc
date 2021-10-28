package task7;

public class ChessPosition {
	private int x;
	private int y;

	public static final int BoardSize = 8;

	private static final String BoardIndex = "abcdefgh";

	public ChessPosition(int x, int y) throws IllegalPositionException {
		setX(x);
		setY(y);
	}

	public ChessPosition(String index) throws IllegalPositionException {
		setPosition(index);
	}

	public void setPosition(String position) throws IllegalPositionException {
		if (position.length() != 2) {
			throw new IllegalPositionException("Конь так не ходит!");
		}

		char x = position.charAt(0);
		Integer index = BoardIndex.indexOf(x);
		if (index > -1) {
			this.x = index;
		} else {
			throw new IllegalPositionException(xIndexOutOfBoundsErrorMessage(x));
		}

		char y = position.charAt(1);

		index = Character.getNumericValue(y) - 1;
		if (Character.isDigit(y) && index < BoardSize) {
			this.y = index;
		} else {
			throw new IllegalPositionException(xIndexOutOfBoundsErrorMessage(y));
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) throws IllegalPositionException {
		if (ValidIndex(x))
			this.x = x;
		else {
			throw new IllegalPositionException(xIndexOutOfBoundsErrorMessage(x));
		}
	}

	public void setY(int y) throws IllegalPositionException {
		if (ValidIndex(y))
			this.y = y;
		else {
			throw new IllegalPositionException(xIndexOutOfBoundsErrorMessage(y));
		}
	}

	private boolean ValidIndex(int a) {
		return a >= 0 && a <= BoardSize - 1;
	}

	static ChessPosition parse(String position) throws IllegalPositionException {
		char a = position.charAt(0);
		Integer b = Integer.parseInt(String.valueOf(position.charAt(1)));
		return new ChessPosition(BoardIndex.indexOf(a), b - 1);
	}

	private String xIndexOutOfBoundsErrorMessage(int a) {
		return "Значение X = " + a + " неверное. Оно должно быть от 0 до " + (BoardSize - 1) + "!";
	}

	private String yIndexOutOfBoundsErrorMessage(int a) {
		return "Значение Y = " + a + " неверное. Оно должно быть от 0 до " + (BoardSize - 1) + "!";
	}

	@Override
	public String toString() {
		return Character.toString(BoardIndex.charAt(x)) + (y + 1);
	}
}