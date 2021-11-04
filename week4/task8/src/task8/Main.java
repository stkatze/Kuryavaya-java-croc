package task8;

import java.io.File;
import java.io.FileInputStream;

public class Main {
	public static void main(String args[]) throws Exception {
		int count = 0;
		if (args.length < 1) {
			System.err.println("Ошибка!");
			return;
		}
		File file = new File(args[0]);
		FileInputStream fis = new FileInputStream(file);
		byte[] bytesArray = new byte[(int) file.length()];
		fis.read(bytesArray);
		String s = new String(bytesArray);
		String[] data = s.split("\\s+");
		for (int i = 0; i < data.length; i++) {
			count++;
		}
		System.out.println("Количество слов в файле: " + count);
	}
}