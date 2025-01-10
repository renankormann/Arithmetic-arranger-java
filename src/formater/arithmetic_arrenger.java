package formater;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class arithmetic_arrenger {
	
	private Set<String> operations = new LinkedHashSet<>();
	private boolean printResults;
	
	/*constructor method for the arrenger must contain a set with the list of
	operations to be made and a boolean value to check if we print the solutions
	or not*/
	public arithmetic_arrenger(Set<String> allProblems, boolean printResults) {
		this.operations = allProblems;
		this.printResults = printResults;
		
		//print results by calling reorganizeProblems function
		LinkedHashSet<String> orderedP = reorganizeProblems(operations);
		for(String element : orderedP) {
			System.out.println(element);
		}
	}
	
	/*this method will separate the operations by lines, so the first number of each
	 * operation will be a string in the reorganizedP set, the second number and the sign of
	 * each will be the second string in the set, and the third string in the set will
	 * contain the correct amount of (-) */
	public LinkedHashSet<String> reorganizeProblems(Set<String> allProblems) {
		/* this portion of the program generate 4 String variables to organize each line
		 * of the vertical operations positioned side by side that will be stored to
		 * linked hash set that will be returned by this method (reorganizedP).
		 */
		LinkedHashSet<String> reorganizedP = new LinkedHashSet<>();
		String newLine1 = "";
		String newLine2 = "";
		String newLine3 = "";
		String resultsLine = "";
		
		/* This loop is where most of the String manipulation happens. I will explain
		 * each step separately so it makes more sense.
		 */
		for(String element : allProblems) {
			/* There are 5 String variables. 'editedNum1 and 2' holds the first and  
			 * second numbers of the operations, 'sign' holds the sign, and 'minusSigns'
			 * holds the bottom bar that separates the operations from the result. 
			 * 'resultHolds holds the String version of the int variable 'result' that
			 * contains the operation result.
			 */
			String editedNum1;
			String editedNum2;
			String minusSigns = "";
			String resultHold;
			int result;
			String sign;
			
			/* This is the portion used to split the numbers and store them into their
			 * designed variables and calculate the result from the String split method.
			 */
			if(element.contains("+")) {
				sign = "+";
				result = Integer.parseInt(element.split(Pattern.quote(sign))[0]) + 
						Integer.parseInt(element.split(Pattern.quote(sign))[1]);
			}else {
				sign = "-";
				result = Integer.parseInt(element.split(Pattern.quote(sign))[0]) - 
						Integer.parseInt(element.split(Pattern.quote(sign))[1]);
			}
			resultHold = Integer.toString(result);
			editedNum1 = element.split(Pattern.quote(sign))[0];
			editedNum2 = element.split(Pattern.quote(sign))[1];
			
			/* This portion of the code is entirely designed to produce the right-align
			 * when printing the vertical operations side by side. It basically consists
			 * of adding spaces before or after each number until it gets to the desired
			 * format.
			 */
			while(editedNum1.length() < (element.split(Pattern.quote(sign))[1]).length() + 2) {
				editedNum1 = " " + editedNum1;
			}
			while(editedNum2.length() < editedNum1.length() - 1) {
				editedNum2 = " " + editedNum2;
			}
			while(minusSigns.length() < editedNum1.length()) {
				minusSigns = minusSigns + "-";
			}
			while(resultHold.length() < editedNum1.length()) {
				resultHold = " " + resultHold;
			}
			
			/* Here I have used string concatenation to put together each line of the 
			 * printing section.
			 */
			editedNum2 = sign + editedNum2;
			newLine1 = newLine1 + editedNum1 + "  |    ";
			newLine2 = newLine2 + editedNum2 + "  |    ";
			newLine3 = newLine3 + minusSigns + "  |    ";
			resultsLine = resultsLine + resultHold + "  |    ";
		}
		
		/* Here we just add each line to the Linked hash set that will be returned by
		 * the method and add the option to add the solutions to the set as well, if the
		 * printResults variable holds true.
		 */
		reorganizedP.add(newLine1.substring(0, newLine1.length() - 5));
		reorganizedP.add(newLine2.substring(0, newLine2.length() - 5));
		reorganizedP.add(newLine3.substring(0, newLine3.length() - 5));
		if(printResults) {
			reorganizedP.add(resultsLine.substring(0, resultsLine.length() - 5));
		}
		return reorganizedP;
	}

}
