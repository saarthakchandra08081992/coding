import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class MLDS {

	static final String basePath = "/Users/sureshchandra/Desktop";
	static final int arraySize = 1000000;
	static Random rand = new Random();

	// input is prob of getting 1
	/**
	 * 
	 * @param a
	 * @param b
	 *            a/b gives us the probability of getting a 1
	 * @return returns a 1/0 based on probability of 1/0
	 */
	public static int getDigit(double prob) {
		double probOne = (double) prob;
		if (rand.nextDouble() < probOne)
			return 1;
		else
			return 0;
	}

	/**
	 * write the values into a CSV
	 */
	public static void importanceSampling() {
		int[] arrayX1 = new int[arraySize];
		int[] arrayX4 = new int[arraySize];
		int[] arrayX2 = new int[arraySize];
		int[] arrayX3 = new int[arraySize];

		int[] finalarrayX1 = new int[arraySize];
		int[] finalarrayX4 = new int[arraySize];
		int[] finalarrayX2 = new int[arraySize];
		int[] finalarrayX3 = new int[arraySize];
		double weight[] = new double[arraySize];
		int ctr = 0;
		double sumWeight = 0.0;
		double sumX3asOne = 0.0;
		double sumX3asZero = 0.0;

		for (int i = 0; i < 100; i++) {
			arrayX1[i] = getDigit(0.1);
			arrayX4[i] = getDigit(0.4);
			if (arrayX1[i] == 0 && arrayX4[i] == 0) {
				arrayX2[i] = 1;
				weight[i] = (double) 0.1;
				sumWeight += weight[i];
				arrayX3[i] = getDigit(0.8);
			}

			else if (arrayX1[i] == 0 && arrayX4[i] == 1) {
				arrayX2[i] = 1;
				weight[i] = (double) 0.2;
				sumWeight += weight[i];
				arrayX3[i] = getDigit(0.9);
			}

			else if (arrayX1[i] == 1 && arrayX4[i] == 0) {
				arrayX2[i] = 1;
				weight[i] = (double) 0.2;
				sumWeight += weight[i];
				arrayX3[i] = getDigit(0.9);
			}

			else if (arrayX1[i] == 1 && arrayX4[i] == 1) {
				arrayX2[i] = 1;
				weight[i] = (double) 0.1;
				sumWeight += weight[i];
				arrayX3[i] = getDigit(0.2);
			}

			// We know we got 1, so we include it
			if (arrayX2[i] == 1) {
				finalarrayX1[ctr] = arrayX1[i];
				finalarrayX2[ctr] = arrayX2[i];
				finalarrayX3[ctr] = arrayX3[i];
				finalarrayX4[ctr] = arrayX4[i];
				ctr++;
			}

			// If we found x3 as 1, we find x3's weight of being 1
			if (arrayX3[i] == 1) {
				sumX3asOne += weight[i];
			} else
				sumX3asZero += weight[i];
		} // end for loop

		System.out.println("Q3:");
		System.out.println("P(X3=1 | X2=1) = " + (sumX3asOne / sumWeight));
		System.out.println("P(X3=0 | X2=1) = " + (sumX3asZero / sumWeight));

		writeToCsv(basePath + "/importance.csv", finalarrayX1, finalarrayX2, finalarrayX3, finalarrayX4, ctr);
	}

	public static void rejectionSampling() {
		int[] arrayX1 = new int[arraySize];
		int[] arrayX4 = new int[arraySize];
		int[] arrayX2 = new int[arraySize];
		int[] arrayX3 = new int[arraySize];

		int[] finalarrayX1 = new int[arraySize];
		int[] finalarrayX4 = new int[arraySize];
		int[] finalarrayX2 = new int[arraySize];
		int[] finalarrayX3 = new int[arraySize];

		int ctr = 0;
		int x3One = 0;
		int x3Zero = 0;

		for (int i = 0; i < 100; i++) {
			arrayX1[i] = getDigit(0.1);
			arrayX4[i] = getDigit(0.4);

			if (arrayX1[i] == 0 && arrayX4[i] == 0) {
				arrayX2[i] = getDigit(0.1);
				arrayX3[i] = getDigit(0.8);
			}

			else if (arrayX1[i] == 0 && arrayX4[i] == 1) {
				arrayX2[i] = getDigit(0.2);
				arrayX3[i] = getDigit(0.9);
			}

			else if (arrayX1[i] == 1 && arrayX4[i] == 0) {
				arrayX2[i] = getDigit(0.2);
				arrayX3[i] = getDigit(0.9);
			}

			else if (arrayX1[i] == 1 && arrayX4[i] == 1) {
				arrayX2[i] = getDigit(0.1);
				arrayX3[i] = getDigit(0.2);
			}

			// We know we got 1 as X2, so we include it,else we do not add that
			if (arrayX2[i] == 1) {
				finalarrayX1[ctr] = arrayX1[i];
				finalarrayX2[ctr] = arrayX2[i];
				finalarrayX3[ctr] = arrayX3[i];
				finalarrayX4[ctr] = arrayX4[i];

				if (arrayX3[i] == 1)
					x3One++;
				else
					x3Zero++;

				ctr++;
			}

		}
		System.out.println("Q2:");
		System.out.println("P(X3=1 | X2=1) = " + (double) x3One / ctr);
		System.out.println("P(X3=0 | X2=1) = " + (double) x3Zero / ctr);
		writeToCsv(basePath + "/rejection.csv", finalarrayX1, finalarrayX2, finalarrayX3, finalarrayX4, ctr);
	}

	public static void writeToCsv(String csvFile, int[] x1, int[] x2, int[] x3, int[] x4, int size) {
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
		importanceSampling();

		// Now we have our 100 samples

	}
}
