package task16;

import java.io.*;
import java.util.*;

public class Main {
	static List<String> input = new ArrayList<>();

	static List<Set<Respondent>> groups = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		int[] ageBounds = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
		inputRespondents(); // из файла считываем респондентов
		makeAgeGroups(ageBounds);// создаем возрастные группы
		sortingByAgeGroups(input, ageBounds); // производим сортировку респондентов по возрасту
		outputAgeGroups(groups, ageBounds);// выводим группы респондентов в файл
	}

	public static void sortingByAgeGroups(List<String> input, int[] ageBounds) {
		for (String str : input) {
			String[] AllOnString = str.split(",");
			Respondent respondent = new Respondent(AllOnString[0], Integer.parseInt(AllOnString[1]));
			for (int i = 0; i < ageBounds.length; i++) {
				if (respondent.getAge() >= ageBounds[ageBounds.length - 1]) {
					groups.get(ageBounds.length).add(respondent);
					break;
				}
				if (respondent.getAge() <= ageBounds[i]) {
					groups.get(i).add(respondent);
					break;
				}
			}
		}
	}

	public static void inputRespondents() throws IOException {
		FileReader file = new FileReader("/Users/stkatze/Workspace/Kuryavaya-java-croc/week7/task16/src/task16/input");
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();
		while (!(line.toLowerCase().equals("END"))) {
			input.add(line);
			line = reader.readLine();
		}
		file.close();
	}

	public static void makeAgeGroups(int[] ageBounds) {
		for (int i = 0; i <= ageBounds.length; i++) {
			groups.add(new TreeSet<>(new RespondentsComparator()));
		}
	}

	public static void outputAgeGroups(List<Set<Respondent>> input, int[] ageBounds) throws IOException {
		FileWriter fileWriter = new FileWriter(
				"/Users/stkatze/Workspace/Kuryavaya-java-croc/week7/task16/src/task16/output");
		for (int i = input.size() - 1; i >= 0; i--) {
			if (groups.get(i).isEmpty())
				continue;
			StringBuilder text = new StringBuilder();
			if (i == 0) {
				text.append("0-");
				text.append(ageBounds[i]);
				text.append(": ");
				text.append(groups.get(i));
			} else if (i == input.size() - 1) {
				text.append(ageBounds[i - 1]);
				text.append("+: ");
				text.append(groups.get(i));
			} else {
				text.append(ageBounds[i - 1]);
				text.append("-");
				text.append(ageBounds[i]);
				text.append(": ");
				text.append(groups.get(i));
			}
			text.append("\n");
			fileWriter.write(text.toString());
			fileWriter.flush();
		}
		fileWriter.close();
	}
}