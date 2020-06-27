import java.util.Scanner;

/**
 * @since June 2020
 * @author Akansh
 *
 * This code is checking for the Balanced Parenthesis.
 * (){} - true
 * {()} - true
 * (){  - false
 * {})  - false
 */

class BalancedParenthesis {

	public static void main(String[] args) {
		Parser parser = new Parser();

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			System.out.println(parser.isBalanced(in.next()));
			parser.stack = null;
			parser.stackIndex = -1;
		}

		in.close();
	}
}

class Parser {
	char[] stack = null;
	int stackIndex = -1;
	int arrayLength = 0;

	boolean isBalanced(String test) {
		boolean result = false;
		char[] stringToArr = null;
		

		if (test.equals("") || test.isEmpty()) {
			result = true;
		} else {
			stringToArr = test.toCharArray();
			arrayLength = stringToArr.length;
			for (char ch : stringToArr) {
				if (ch == '(' || ch == '{') {
					if (stack == null) {
						stack = new char[arrayLength];
					}
					push(ch);
				} else if (ch == ')' || ch == '}') {
					// char popped = pop(ch);
					result = isMatching(pop(ch), ch);
					if (result == false) {
						return result;
					}
				}
				 if (isStackEmpty()) 
			         result = true; /*balanced*/
			       else
			         {   /*not balanced*/
			             result = false; 
			         }  
			}
		}

		return result;
	}

	void push(char p) {
		if (stackIndex == arrayLength) {
			//System.out.println("Stack Overflow.");
		} else {
			stack[++stackIndex] = p;
		}
	}

	char pop(char p) {

		if (stackIndex == -1) {
			//System.out.println("Stack Underflow.");
			return '\0';
		} else {
			char ele = stack[stackIndex];
			stackIndex--;
			return ele;
		}
	}

	boolean isMatching(char c1, char c2) {
		boolean match = false;
		if (c1 == '(' && c2 == ')') {
			match = true;
		} else if (c1 == '{' && c2 == '}') {
			match = true;
		} else {
			match = false;
		}
		return match;
	}
	
	boolean isStackEmpty() {
		return (stackIndex == -1) ? true : false;
	}
}