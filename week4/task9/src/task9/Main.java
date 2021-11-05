package task9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		String dir = args[0]; // ищем в папке tmp
		String ext = ".log"; // ищем файлы с расширением .log
		HashMap<Long, ArrayList<String>> m1 = findLoges(dir, ext); // метод поиска файлов с расширением .log в папке
																	// task9
		System.out.println(m1);

		String ext1 = ".trace"; // ищем файлы с расширением .trace
		HashMap<Long, ArrayList<String>> m2 = findLoges(dir, ext1); // метод поиска файлов с расширением .trace в папке
																	// task9
		System.out.println(m2);

		Set<Long> set1 = m1.keySet();
		for (Long key : m2.keySet()) {
			if (set1.contains(key)) {
				ArrayList<String> val1 = m1.get(key);
				ArrayList<String> val2 = m2.get(key);
				val1.addAll(val2);
			} else {
				m1.put(key, m2.get(key));
			}
		}
		System.out.println(m1);

		Object[] keys = m1.keySet().toArray();
		Arrays.sort(keys);

		for (Object key : keys) {
			System.out.print(key);
			for (String line : m1.get(key)) {
				System.out.print(" " + line);
			}
			System.out.println();
		}
	}

	public static HashMap<Long, ArrayList<String>> findLoges(String dir, String ext) throws IOException {
		HashMap<Long, ArrayList<String>> m = new HashMap<>();
		File f = new File(dir);
		if (!f.exists())
			System.out.println(dir + " такая папка не существует");
		File[] listFiles = f.listFiles(new NameFilter(ext));
		if (listFiles.length == 0) {
			System.out.println(dir + " не содержит файлов с расширением " + ext);
		} else {
			for (int i = 0; i < listFiles.length; i++) {
				BufferedReader reader = new BufferedReader(new FileReader(listFiles[i]));
				String line = reader.readLine();
				while (line != null) {
					NewLog log = new NewLog(line);
					ArrayList<String> newList = m.get(log.time);

					// если List не существует, создаем его
					if (newList == null) {
						newList = new ArrayList<String>();
						newList.add(log.message);
						m.put(log.time, newList);
					} else {
						// добавляем, если элемента еще нет в List
						if (!newList.contains(log.message))
							newList.add(log.message);
					}
					line = reader.readLine();
				}
			}
		}
		return m;
	}
}
