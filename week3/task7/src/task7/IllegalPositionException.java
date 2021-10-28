package task7;

public class IllegalPositionException extends Exception {

	public IllegalPositionException(String message) {
        super(message);
	}

@Override
    public String toString() {
        return "Конь так не ходит!";
}
}