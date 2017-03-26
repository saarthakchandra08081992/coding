
import java.io.*;

public class FileReading {

	public static void main(String args[]) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream("/Users/sureshchandra/Documents/workspace/Coding/src/input.txt");
			out = new FileOutputStream(new File("/Users/sureshchandra/Documents/workspace/Coding/src/output.txt"));

			int c;
			while ((c = in.read()) != -1) {
				System.out.println((char)c);
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
