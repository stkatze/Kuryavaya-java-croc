package task14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FilesDefinition {
	public static Map<Integer, String> movies;
	public static List<Set<Integer>> viewsList;

	private Path pathMovies;
	private Path pathViews;

	public FilesDefinition(String pathMovies, String pathViews) throws IOException {
		movies = new HashMap<>();
		viewsList = new ArrayList<>();
		this.pathMovies = Paths.get(pathMovies);
		this.pathViews = Paths.get(pathViews);
		moviesDefinition();
		viewsDefinition();
	}

	private void moviesDefinition() throws IOException {
		List<String> allMovies = Files.readAllLines(pathMovies);
		for (String movie : allMovies) {
			Integer number = Integer.parseInt(movie.substring(0, movie.indexOf(',')));
			String movieName = movie.substring(movie.indexOf(',') + 1);
			movies.put(number, movieName);
		}
	}

	private void viewsDefinition() throws IOException {
		List<String> allViews = Files.readAllLines(pathViews);
		for (String view : allViews) {
			Set<Integer> views = new HashSet<>();
			String[] numbers = view.split(",");
			for (String number : numbers) {
				views.add(Integer.parseInt(number));
			}
			viewsList.add(views);
		}
	}

}