import java.util.*;

public class StringCompression {

	private static String input() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		return input;
	}

	private static void calculate(String input) {
		String ans = "";
		int ctr = 1;

		if (input.length() <= 1)
			System.out.println(input.trim());
		else {

			for (int i = 0; i < input.length(); i++) {

				ctr = 1;
				while ((i + 1) < input.length() && input.charAt(i) == input.charAt(i + 1)) {
					ctr++;
					i++;
				}
				ans += input.charAt(i);
				if (ctr > 1) {
					ans += ctr;
					ctr = 1;
				}
			}

			System.out.println(ans);
		}
	}

	private static void calculateInPlace(String input) {
		int ctr = 1;
		if (input.length() <= 1)
			System.out.println(input.trim());
		else {
			for (int i = 0; i < input.length(); i++) {

				ctr = 1;
				while ((i + ctr) < input.length() && input.charAt(i) == input.charAt(i + ctr)) {
					ctr++;
				}

				if (ctr > 1) {
					input = input.substring(0, i) + input.charAt(i) + ctr + input.substring(ctr + i, input.length());
					ctr = 1;
					i = i + 1;
				}
			}

			System.out.println(input);
		}
	}

	public static void main(String[] args) {

		String input = input().trim();
		calculate(input);
		calculateInPlace(input);

	}

}
