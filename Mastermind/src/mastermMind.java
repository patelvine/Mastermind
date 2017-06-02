import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class mastermMind {
	private static Random r = new Random();
	private static String input = null;
	private static char code[];
	private static char guess[];
	private static int attempts = 0;

	public static void main(String args[]) {
		System.out.println("--- MasterMind ---\n");
		System.out.println("Attempt to crack the code with the given hints");
		codeCreator();
		guess();
	}

	private static void guess() {
		guess = new char[4];

		while (!Arrays.equals(guess, code)) {
			System.out.println("\nGuess the code!:");

			String guessStr = input();
			while (guessStr.length() != 4) {
				System.out.println("Guess must contain 4 values:");
				guessStr = input();
			}
			guess = guessStr.toCharArray();

			attempts++;
			if (Arrays.equals(code, guess)) {
				String selection = null;
				System.out.println("You have won with "+attempts+" attempts!!!\nWould you like to play again Y/N?");
				while (selection != "Y" || selection != "N") {
					selection = input();
					if (selection == "Y") {
						main(null);
					} else if (selection == "N") {

					} else {
						System.out.println("Please enter Y for yes or N for no");
					}
				}
			}

			int correctPosition = 0;
			int correctValue = 0;

			for (int i = 0; i < 4; i++) {
				char curchar = code[i];
				for (int u = 0; u < 4; u++) {
					if (curchar == guess[u]) {
						if (i == u) {
							correctPosition++;
						}else {
							correctValue++;
						}
					}
				}
			}

			System.out.println("You have " + correctPosition
					+ " values in the correct place");
			System.out.println("You also have " + correctValue
					+ " other correct values but in the wrong place");
			
		}
	}

	private static void codeCreator() {
		code = new char[4];

		System.out
				.println("Would you like to play with numbers, letters or both?");
		System.out.println("1-Letters, 2-Numbers, 3-Both(hard)");

		int selection = Integer.parseInt(input());
		if (selection == 1) {
			String letters = "abcdefghi";
			for (int i = 0; i < 4; i++) {
				code[i] = letters.charAt(r.nextInt(letters.length()));
			}
			System.out
					.println("Code will consist of 4 values of a,b,c,d,e,f,g,h,i");
		} else if (selection == 2) {
			String numbers = "123456789";
			for (int i = 0; i < 4; i++) {
				code[i] = numbers.charAt(r.nextInt(numbers.length()));
			}
			System.out
					.println("Code will consist of 4 values of 1,2,3,4,5,6,7,8,9");
		} else if (selection == 3) {
			String both = "123456789abcdefghi";
			for (int i = 0; i < 4; i++) {
				code[i] = both.charAt(r.nextInt(both.length()));
			}
			System.out
					.println("Code will consist of 4 values of 1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i");
		}
	}

	public static String input() {
		Scanner scanIn = new Scanner(System.in);
		String inputString = scanIn.nextLine();
		return inputString;
	}
}

// 0800588188/70129216/farmers