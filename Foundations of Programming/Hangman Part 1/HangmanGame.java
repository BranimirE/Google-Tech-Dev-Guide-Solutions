import java.util.Arrays;

class HangmanGame {
	private String word;
	private int attempts, length;
	private char currentGuess[];
	public final static int DEFAULT_ATTEMPTS = 8;
	public HangmanGame() {
		word = "";
		attempts = 0;
	}
	public HangmanGame(String word, int attempts) {
		this.word = word;
		this.attempts = attempts;
		length = word.length();
		currentGuess = new char[length];
		Arrays.fill(currentGuess, '-');
	}
	public boolean tryGuess(char letter) throws Exception {
		if (attempts <= 0) {
			throw new Exception("tryGuess: Illegal attempt, no attempts left");
		}
		boolean success = false;
		letter = Character.toUpperCase(letter);
		for (int i = 0; i < length; i++) {
			if (letter == Character.toUpperCase(word.charAt(i))) {
				currentGuess[i] = word.charAt(i);
				success = true;
			}
		}
		if (!success) {
			attempts--;
		}
		return success;
	}
	public boolean hasWon() {
		boolean response = true;
		for (int i = 0; i < length && response; i++) {
			if (currentGuess[i] == '-') {
				response = false;
			}
		}
		return response;
	}
	public int getAttempts() {
		return attempts;
	}
	public String getCurrentGuess() {
		return new String(currentGuess);
	}
	public String getWord() {
		return word;
	}
}