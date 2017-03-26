
public class rotatedBinary {

	public static void main(String[] args) {

		// int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		// int array[] = { 8, 9, 10, 1, 2, 3, 4, 5, 6, 7 };
		int array[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int L = 0;
		int R = array.length - 1;

		int key = 10;

		while (L <= R) {
			// Avoid overflow, same as M=(L+R)/2
			int M = L + ((R - L) / 2);
			if (array[M] == key)
				System.out.println(M);

			// the bottom half is sorted
			if (array[L] <= array[M]) {
				if (array[L] <= key && key < array[M])
					R = M - 1;
				else
					L = M + 1;
			}
			// the upper half is sorted
			else {
				if (array[M] < key && key <= array[R])
					L = M + 1;
				else
					R = M - 1;
			}
		}
		System.out.println(-1);

	}
}
