
/**
 * @author Mr. Rasmussen
 */
package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		System.out.println("Welcome to Fraction Calculator");
		Scanner intro = new Scanner(System.in);
		System.out.print("Enter a fraction problem: ");
		String userResponse = intro.nextLine();
		while (!userResponse.equalsIgnoreCase("quit")) {
			System.out.println(produceAnswer(userResponse));
			userResponse = intro.nextLine();
		}
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
	public static String produceAnswer(String input) {
		String operand1 = "";
		String operator = "";
		String operand2 = "";

		String layout = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				if (operand1.equals("")) {
					operand1 = layout;
					layout = "";

				} else {
					operator = layout;
					layout = "";
				}
			} else if (i == input.length() - 1) {
				layout += input.charAt(i);
				operand2 = layout;
			} else {
				layout += input.charAt(i);

			}
		}

		layout = input;
		operand1 = layout.substring(0, layout.indexOf(' '));
		layout = layout.substring(layout.indexOf(' ') + 1);
		operator = layout.substring(0, layout.indexOf(' '));
		layout = layout.substring(layout.indexOf(' ') + 1);
		operand2 = layout;
		String op2Whole = findWhole(operand2);
		String op2Num = findNum(operand2);
		String op2Denom = findDenom(operand2);

		String chk2Answer = ("Whole: " + op2Whole + " Numerator: " + op2Num + " Denominator: " + op2Denom);

		return chk2Answer;

	}

	public static String findWhole(String str) {
		if (str.contains("_")) {
			return str.substring(0, str.indexOf('_'));
		} else if (str.contains("/")) {
			return "0";
		} else
			return str;

	}

	public static String findNum(String str) {
		if (str.contains("_")) {
			return str.substring(str.indexOf('_') + 1, str.indexOf('/'));
		} else if (str.contains("/")) {
			return str.substring(0, str.indexOf('/'));
		} else {
			return "0";
		}
	}

	public static String findDenom(String str) {
		if (str.contains("/")) {
			return str.substring(str.indexOf("/") + 1);
		}
		return "1";
		// TODO: Implement this function to produce the solution to the input

	}

}

// TODO: Fill in the space below with any helper methods that you think you will
// need
