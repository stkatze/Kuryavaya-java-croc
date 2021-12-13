package task18.exceptions;

import java.sql.SQLException;

public class NotFound extends SQLException {
	@Override
	public String getMessage() {
		return "Товар не найден в базе данных!";
	}
}