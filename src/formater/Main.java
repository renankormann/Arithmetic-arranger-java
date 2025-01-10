package formater;

import java.util.LinkedHashSet;

/* Program to print out solutions for arithmetic operations (+ and -) vertically*/

public class Main {

	public static void main(String[] args) {
		
		LinkedHashSet<String> listNumbers = new LinkedHashSet<>();
		String alpha = "22+200";
		listNumbers.add(alpha);
		alpha = "20-200";
		listNumbers.add(alpha);
		alpha = "200-20";
		listNumbers.add(alpha);
		alpha = "2000-20";
		listNumbers.add(alpha);
		alpha = "1-2000";
		listNumbers.add(alpha);
		alpha = "20000-2";
		listNumbers.add(alpha);
		arithmetic_arrenger testing = new arithmetic_arrenger(listNumbers, true);
	}

}

/* to improve: 
 * - add a method to print the operations separated from the constructor of the 
 * class.
 * - limit the amount of operations that can be side by side and create a way of
 * printing the lasting operations below and separated by "********...*********".
 * - create error methods.
 * - add multiplication similarly.
 * - add division with a different format.
 */
