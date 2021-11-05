package task9;

public class NewLog {
	public final long time;
	public final String message;

	NewLog(String str) {
		if (str == null) {
			throw new IllegalArgumentException("Пустая строка!");
		}
		String[] line = str.trim().split(" ", 2);
		time = Long.parseLong(line[0]);
		message = line[1];
	}

	@Override
	public String toString() {
		return time + " " + message;
	}
}

