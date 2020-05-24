import java.util.Scanner;

public class Main {
	Scanner in = new Scanner(System.in);
	private HangmanGame game;
	private HangmanLexicon lexicon;
	
	public Main() {
		game = new HangmanGame();
		lexicon = new HangmanLexicon();
	}
	
	public void play() throws Exception {
		System.out.println("Welcome to Hangman!");
		game = new HangmanGame(lexicon.getWord((int)(Math.random() * lexicon.getWordCount())),
				HangmanGame.DEFAULT_ATTEMPTS);
		while (game.getAttempts() > 0 && !game.hasWon()) {
			System.out.println("The word now looks like this: " + game.getCurrentGuess());
			System.out.println("You have " + game.getAttempts() + " guesses left.");
			System.out.print("Your guess: ");
			char guess = in.next().trim().charAt(0);
			if (game.tryGuess(guess)) {
				System.out.println("That guess is correct.");
			} else {
				System.out.println("There are no " + guess + "'s in the word.");
			}
		}
		if (game.getAttempts() == 0) {
			System.out.println("You're completely hung.");
			System.out.println("The word was: " + game.getWord());
			System.out.println("You lose.");
		} else {//win
			System.out.println("You guessed the word: " + game.getWord());
			System.out.println("You win.");
		}
	}
	public static void main(String[] args) {
		Main main = new Main();
		try {
			main.play();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
