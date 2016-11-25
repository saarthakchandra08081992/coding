import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MLDS {

	// input is prob of getting 1
	public static int getDigit(double a, double b) {
		if (Math.random() < (double) a / b)
			return 1;
		else
			return 0;
	}

	public static void rejectionSampling() {
		int[] arrayX1 = new int[100];
		int[] arrayX4 = new int[100];
		int[] arrayX2 = new int[100];
		int[] arrayX3 = new int[100];

		int[] finalarrayX1 = new int[100];
		int[] finalarrayX4 = new int[100];
		int[] finalarrayX2 = new int[100];
		int[] finalarrayX3 = new int[100];
		int ctr = 0;

		for (int i = 0; i < 100; i++) {
			arrayX1[i] = getDigit(1.0, 10.0);
			arrayX4[i] = getDigit(4.0, 10.0);
			if (arrayX1[i] == 0 && arrayX4[i] == 0) {
				arrayX2[i] = getDigit(1, 10);
				arrayX3[i] = getDigit(8, 10);
			}

			else if (arrayX1[i] == 0 && arrayX4[i] == 1) {
				arrayX2[i] = getDigit(2, 10);
				arrayX3[i] = getDigit(9, 10);
			}

			else if (arrayX1[i] == 1 && arrayX4[i] == 0) {
				arrayX2[i] = getDigit(2, 10);
				arrayX3[i] = getDigit(9, 10);
			}

			else if (arrayX1[i] == 1 && arrayX4[i] == 1) {
				arrayX2[i] = getDigit(1, 10);
				arrayX3[i] = getDigit(2, 10);
			}

			// We know we got 1, so we include it
			if (arrayX2[i] == 1) {
				finalarrayX1[ctr] = arrayX1[i];
				finalarrayX2[ctr] = arrayX2[i];
				finalarrayX3[ctr] = arrayX3[i];
				finalarrayX4[ctr] = arrayX4[i];
				ctr++;
			}
		}

		writeToCsv("/Users/sureshchandra/Desktop/rejection.csv", finalarrayX1, finalarrayX2, finalarrayX3, finalarrayX4,
				ctr);
	}

	public static void writeToCsv(String csvFile, int[] x1, int[] x2, int[] x3, int[] x4, int size) {
		// String csvFile = "/Users/schandra2/Desktop/rejection.csv";
		try {
			FileWriter writer = new FileWriter(new File(csvFile));
			for (int i = 0; i < size; i++)
				CSVUtils.writeLine(writer, Arrays.asList(x1[i] + "", x2[i] + "", x3[i] + "", x4[i] + ""));
			// TODO writing

			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		rejectionSampling();
		// Now we have our 100 samples

	}
}
