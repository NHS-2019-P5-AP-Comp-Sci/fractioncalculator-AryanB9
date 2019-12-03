/**
 * @author Mr. Rasmussen
 */
package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		System.out.println("Welcome to fraction calculator! ");
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter a fraction problem: ");
		String fractions = userInput.nextLine();
		while (!(fractions.toUpperCase()).equals("QUIT")) {
			System.out.println(produceAnswer(fractions));
			fractions = userInput.nextLine();
		}
		userInput.close();

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"

	// TODO: Implement this function to produce the solution to the input

	public static String produceAnswer(String input) {
		String operator;
		int numsBefore;
		int a = input.indexOf(" + ");
		int b = input.indexOf(" - ");
		int c = input.indexOf(" * ");
		int d = input.indexOf(" / ");
		if (a != -1) {
			numsBefore = a;
			operator = "+";
		} else if (b != -1) {
			numsBefore = b;
			operator = "-";
		} else if (c != -1) {
			numsBefore = c;
			operator = "*";
		} else {
			numsBefore = d;
			operator = "/";
		}
		String initialFraction = "";
		String secondaryFraction = "";
		for (int i = 0; i < numsBefore; i++) {
			initialFraction = initialFraction + input.charAt(i);
		}
		for (int i = 0; i < input.length() - 3 - numsBefore; i++) {
			secondaryFraction = secondaryFraction + input.charAt(3 + numsBefore + i);
		}

		int firstWhole = Integer.parseInt(whole(initialFraction));
		int secondWhole = Integer.parseInt(whole(secondaryFraction));
		int firstNumerator = Integer.parseInt(numerator(initialFraction));
		int secondNumerator = Integer.parseInt(numerator(secondaryFraction));
		int firstDenominator = Integer.parseInt(denominator(initialFraction));
		int secondDenominator = Integer.parseInt(denominator(secondaryFraction));

		// sets up fractions for the calculation
		if (initialFraction.indexOf("-") != -1 && initialFraction.indexOf("_") != -1) {
			firstNumerator = (firstWhole * firstDenominator - firstNumerator);
			if (operator.equals("+") || operator.equals("-")) {
				firstNumerator *= secondDenominator;
			}
		} else if (operator.equals("+") || operator.equals("-")) {
			firstNumerator = (firstNumerator + firstWhole * firstDenominator) * secondDenominator;
		} else {
			firstNumerator = (firstNumerator + firstWhole * firstDenominator);
		}

		if (secondaryFraction.indexOf("-") != -1 && secondaryFraction.indexOf("_") != -1) {
			secondNumerator = (secondWhole * secondDenominator - secondNumerator);
			if (operator.equals("+") || operator.equals("-")) {
				secondNumerator *= firstDenominator;
			}
		} else if (operator.equals("+") || operator.equals("-")) {
			secondNumerator = (secondNumerator + secondWhole * secondDenominator) * firstDenominator;
		} else {
			secondNumerator = (secondNumerator + secondWhole * secondDenominator);
		}
		if (operator.equals("+") || operator.equals("-")) {
			firstDenominator *= secondDenominator;
			secondDenominator = firstDenominator;
		}

		// performs operations and gives out unsimplified improper fraction
		int answerNumerator = 0;
		int answerDenominator = 0;
		if (operator.equals("+")) {
			answerNumerator = firstNumerator + secondNumerator;
			answerDenominator = firstDenominator;
		} else if (operator.equals("-")) {
			answerNumerator = firstNumerator - secondNumerator;
			answerDenominator = firstDenominator;
		} else if (operator.equals("*")) {
			answerNumerator = firstNumerator * secondNumerator;
			answerDenominator = firstDenominator * secondDenominator;
		} else if (operator.equals("/")) {
			int tempNumerator = secondNumerator;
			secondNumerator = secondDenominator;
			secondDenominator = tempNumerator;
			answerNumerator = firstNumerator * secondNumerator;
			answerDenominator = firstDenominator * secondDenominator;
		}

		return answerNumerator + "/" + answerDenominator;
	}

	public static String whole(String fraction) {
		String whole = "";
		if (fraction.indexOf("/") == -1) {
			whole = fraction;
		} else if (fraction.indexOf("_") != -1) {
			int numsBeforeUnderscores = fraction.indexOf("_");
			for (int i = 0; i < numsBeforeUnderscores; i++) {
				whole = whole + fraction.charAt(i);
			}
		} else if (fraction.indexOf("_") == -1) {
			whole = "0";
		}
		return whole;
	}

	public static String numerator(String fraction) {
		String numerator = "";
		if (fraction.indexOf("/") == -1) {
			numerator = "0";
		} else if (fraction.indexOf("_") != -1) {
			int numsBeforeSlashes = fraction.indexOf("/");
			int numsBeforeUnderscores = fraction.indexOf("_");
			for (int i = 0; i < numsBeforeSlashes - numsBeforeUnderscores - 1; i++) {
				numerator = numerator + fraction.charAt(numsBeforeUnderscores + 1 + i);
			}
		} else if (fraction.indexOf("_") == -1) {
			int numsBeforeSlashes = fraction.indexOf("/");
			for (int i = 0; i < numsBeforeSlashes; i++) {
				numerator = numerator + fraction.charAt(i);
			}
		}
		return numerator;
	}

	public static String denominator(String fraction) {
		String denominator = "";
		if (fraction.indexOf("/") == -1) {
			denominator = "1";
		} else if (fraction.indexOf("_") != -1) {
			int numsBeforeSlashes = fraction.indexOf("/");
			for (int i = 0; i < fraction.length() - numsBeforeSlashes - 1; i++) {
				denominator = denominator + fraction.charAt(numsBeforeSlashes + 1 + i);
			}
		} else if (fraction.indexOf("_") == -1) {
			int numsBeforeSlashes = fraction.indexOf("/");
			for (int i = 0; i < fraction.length() - numsBeforeSlashes - 1; i++) {
				denominator = denominator + fraction.charAt(numsBeforeSlashes + 1 + i);
			}
		}
		return denominator;
	}

}

// TODO: Fill in the space below with any helper methods that you think you will
// need
