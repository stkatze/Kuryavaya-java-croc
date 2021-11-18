package task14;

import java.io.IOException;
import java.util.*;

public class Main {

	public static FilesDefinition filesDefinition;

	static {
		try {
			filesDefinition = new FilesDefinition("src/task14/movies.txt", "src/task14/views.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Set<Integer> match(Set<Integer> userMovies) {
		Set<Integer> match = new HashSet<>();
		for (Set<Integer> views : FilesDefinition.viewsList) {
			Set<Integer> result = new HashSet<>();
			result.addAll(userMovies);
			result.retainAll(views);
			if (result.size() >= userMovies.size() / 2) {
				Set<Integer> removes = new HashSet<>();
				removes.addAll(views);
				removes.removeAll(userMovies);
				match.addAll(removes);
			}
		}
		return match;
	}

	public static Integer newRecommendation(Set<Integer> allRecommendation) {
		int maxIndex = 0;
		Integer maxContain = null;
		for (Integer recommendation : allRecommendation) {
			int temp = 0;
			for (Set<Integer> views : FilesDefinition.viewsList) {
				if (views.contains(recommendation)) {
					temp++;
				}
			}
			if (temp > maxIndex) {
				maxIndex = temp;
				maxContain = recommendation;
			}
		}
		return maxContain;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] movies = line.split(",");
		Set<Integer> userMovies = new HashSet<>();
		for (String movie : movies) {
			userMovies.add(Integer.parseInt(movie));
		}
		Set<Integer> allRecommendation = match(userMovies);
		Integer recommendation = newRecommendation(allRecommendation);
		if (recommendation != null) {
			System.out.println(FilesDefinition.movies.get(recommendation));
		} else {
			System.out.println("Рекомендации не найдены.");
		}
	}
}