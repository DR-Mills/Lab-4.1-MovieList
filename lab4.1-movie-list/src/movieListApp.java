import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class movieListApp {

	static int numberOfMovies = 100;
	static final String welcomeMsg = "Welcome to the Movie List Application!\n";
	static final String listVolumeMsg = "There are " + numberOfMovies + " movies in this list.\n"
			+ "What category are you interested in?";
	static final String menuPrompt = "(please enter the number of the genre as listed above): ";

	private static HashMap<Integer, String> genreMenu = new HashMap<>(
			Map.of(1, "animated", 2, "drama", 3, "comedy", 4, "horror", 5, "musical", 6, "scifi"));

	private static ArrayList<Movie> movieList = new ArrayList<>();
	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		boolean userContinues = true;

		populateMovieList();
		printMsg(welcomeMsg);
		printMsg(listVolumeMsg);
		
		do {
			printMenu();
			
			int userChoice = Validator.validatedInt(menuPrompt, scnr, 1, genreMenu.size());
			ArrayList<Movie> genreFilteredList = genreFilteredMovieList(userChoice);
			int genreFilteredListSize = genreFilteredList.size();
			System.out.println("\nThere are " + genreFilteredListSize + " " + genreMenu.get(userChoice)
					+ " movies in our database. They are:");
			printGenreFilteredList(genreFilteredList);
			System.out.println();
			userContinues = Validator.userContinueYorN("Continue? (y/n): ", "Thanks! Goodbye.", scnr);
		} while (userContinues);

	}

	private static void printGenreFilteredList(ArrayList<Movie> genreFilteredList) {
		for (Movie movie : genreFilteredList) {
			System.out.println(movie.getTitle());
		}
	}

	private static void populateMovieList() {
		for (int i = 1; i <= numberOfMovies; i++) {
			movieList.add(MovieIO.getMovie(i));
		}
	}

	private static void printMsg(String msg) {
		System.out.println(msg);
	}

	private static void printMenu() {
		for (int key : genreMenu.keySet()) {
			System.out.printf("%s%-2s%-10s%n", key, ".", genreMenu.get(key));
		}
	}

	private static ArrayList<Movie> genreFilteredMovieList(int genreFilter) {
		String genre = genreMenu.get(genreFilter).toLowerCase();
		ArrayList<Movie> filteredList = new ArrayList<>();
		for (Movie movie : movieList) {
			if (movie.getCategory() == genre) {
				filteredList.add(movie);
			}
		}
		return filteredList;
	}

}