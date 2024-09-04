package stack;

import java.util.Scanner;

public class Q2 {
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack<Character> st = new Stack<Character>();
		System.out.println("Enter a sequence of characters");
		in.useDelimiter("");
		char c = in.next().charAt(0);
		while (c != '\r') {
			st.push(c);
			c = in.next().charAt(0);
		}
		
		System.out.println("The reversed sequence");
		while (!st.isEmpty()) {
			System.out.print(st.pop());
		}

	}

}
