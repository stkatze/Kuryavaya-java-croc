package task19;

import java.io.*;

public class Main {
	public static void main(String[] args) {

		try (FileWriter writer = new FileWriter("Hello world.txt", false)) {
			String text = "Hello,Wold!";
			writer.write(text);
			writer.append('\n');
			writer.append('E');
			writer.flush();
		} catch (IOException ex) {
			System.out.printf("Ошибка!%s", ex.getMessage());
		}
	}

}