import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ArrayListTrial {
	public static void main(String[] args) {
		String str = "";
		Scanner scan = new Scanner(System.in);
		str = scan.nextLine();
		stackReverse(str);
		System.out.println("\nNow using stringReverse");
		reverseString(str);
	}

	private static void stackReverse(String str) {
		Stack<Character> stack = new Stack<>();
		char[] stringArray = str.toCharArray();
		for (char ch : stringArray) {
			if (ch != ' ')
				stack.push(ch);
			else {
				emptyStack(stack);
				System.out.print(ch);
			}
		}
		emptyStack(stack);
	}

	private static void emptyStack(Stack<Character> stack) {
		char ch;
		while (!stack.isEmpty()) {
			ch = stack.pop();
			System.out.print(ch);
			
			String s="22556";
			;
			char[] aray = s.toCharArray();
			System.out.println(s.contains(".jpg") + " Do we ?? ");
		}
	}

	private static void reverseString(String str) {
		long num = 960069;
		System.out.println(new StringBuilder((num + "").trim()).reverse() + "------");
		System.out.println((num + "").trim());
		System.out.println(new StringBuilder((num + "").trim()).reverse().toString().equalsIgnoreCase((num + "").trim()) + " - for number - "
				+ (num + "").trim());
		System.out.println();
		String[] strings = str.split("[ ]+");
		System.out.println("Length is  - " + strings.length);
		for (String st : strings) {
			System.out.print(new StringBuilder(st).reverse());
		}
	}
}
