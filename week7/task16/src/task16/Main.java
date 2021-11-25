package task16;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayDeque<Group> groups = new ArrayDeque<>(args.length);
		for (int i = 0; i < args.length; i++) {
			int age = Integer.parseInt(args[i]);
			if (i == 0)
				groups.addLast(new Group(0, age));
			else if (i == args.length - 1)
				groups.addLast(new Group(age + 1, Integer.MAX_VALUE));
			else
				groups.addLast(new Group(groups.getLast().getMax() + 1, age));
		}
		System.out.printf("Возрастные группы: %d\n", groups.size());

		System.out.println("Введите данные респондентов:");
		ArrayList<Respondent> respondents = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		while (!input.equals("END")) {
			respondents.add(new Respondent(input));
			input = scanner.nextLine();
		}
		System.out.printf("Количество респондентов: %d\n", respondents.size());

		for (Respondent respondent : respondents) {
			for (Group group : groups) {
				if (group.getMin() <= respondent.getAge() && respondent.getAge() <= group.getMax()) {
					group.respondents.add(respondent);
					break;
				}
			}
		}

		groups.removeIf((Group group) -> group.respondents.size() == 0);
		groups.iterator()
				.forEachRemaining((Group group) -> group.respondents.sort((Respondent left, Respondent right) -> {
					int result = Integer.compare(left.getAge(), right.getAge()) * -1;
					return result != 0 ? result : left.getName().compareTo(right.getName());
				}));

		for (int i = groups.size() - 1; i >= 0; i--)
			System.out.printf("%s\n", groups.pollLast());
	}
}