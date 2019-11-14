
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
		System.out.println(produceAnswer(userResponse));
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
		return operand2;

		// TODO: Implement this function to produce the solution to the input

	}

}

// TODO: Fill in the space below with any helper methods that you think you will
// need
