import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class fileIO {
	public static void main(String[] args) throws IOException {

		readFile(args[0]);
	}

	private static void readFile(String fileName) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileName));
		String entries = "";
		while (scanner.hasNext()) {
			entries += String.valueOf(scanner.nextInt());
		}
		int inputLength = entries.toCharArray().length;
		double rootOfLength = Math.sqrt(inputLength);
		// Since we have non-square input
		if (rootOfLength - Math.floor(rootOfLength) > 0.0)
			System.err.println("Invalid Input");
	}
}
