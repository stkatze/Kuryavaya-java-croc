package task10;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(Paths.get(args[0]));
		} catch (IOException e) {
			System.out.printf("Не удалось открыть файл, ошибка: %s\n", e.getMessage());
		}

		ArrayList<Call> calls = new ArrayList<Call>();
		while (scanner.hasNextLine()) {
			String[] arr = scanner.nextLine().split(",");
			int begining = Integer.parseInt(arr[0]);
			int end = Integer.parseInt(arr[1]);
			Call parsedCall = new Call(begining, end);
			calls.add(parsedCall);
		}

		int max = 0;
		for (Call call : calls) {
			int count = call.callsBetween(calls) - 1;
			if (max < count) {
				max = count;
			}
		}

		System.out.printf("Пиковое количество звонков: %d", max);
	}

}
