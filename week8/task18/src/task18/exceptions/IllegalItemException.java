package task18.exceptions;

public class IllegalItemException extends NullPointerException {
	@Override
	public String getMessage() {
		return "Нельзя создать уже существующий продукт!";
	}
}