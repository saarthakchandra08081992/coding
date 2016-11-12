
public class BSTFromSorted {

	static int sortedArray[] = { 1, 2, 3 };

	private static Node generateBST() {
		Node root = null;
		if (sortedArray.length == 0)
			return root;
		else if (sortedArray.length == 1)
			return new Node(sortedArray[0]);

		int arrayLength = sortedArray.length;

		root = new Node(sortedArray[arrayLength / 2]);
		root.setLeft(new Node(sortedArray[arrayLength / 2 - 1]));
		root.setRight(new Node(sortedArray[arrayLength / 2 + 1]));

		return root;
	}

	private static void inorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.getLeft());
		System.out.print(root.getKey());
		inorderTraversal(root.getRight());
	}

	private static void preOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.getKey());
		preOrderTraversal(root.getLeft());
		preOrderTraversal(root.getRight());
	}

	private static void postOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		postOrderTraversal(root.getLeft());
		postOrderTraversal(root.getRight());
		System.out.print(root.getKey());
	}

	private static int returnIndex(char[] array, char c) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == c)
				return i;
		}
		return -1;
	}

	private static double parseInt(String test) throws Exception {
		boolean hasDecimal = false;
		int effectiveLegnth = 0;
		int validNegative = test.length() - test.replaceAll("-", "").length();
		System.out.println("Length is : " + validNegative + "  " + (test.indexOf('.') + 1));
		if (validNegative > 1)
			throw new Exception("Incorrect Format");

		double sum = 0;
		char array[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '.' };
		boolean isNegative = false;
		test = test.trim();

		int length = test.length();
		for (char c : test.toCharArray()) {
			int index = returnIndex(array, c);
			if (index == -1) {
				System.out.println("Error");
				throw new Exception("Error");
			} else if (index == 10) {
				isNegative = true;
				length--;
			} else if (index == 11) {
				hasDecimal = true;
				System.out.println("HERE");
				length--;
			} else {
				if (hasDecimal)
					effectiveLegnth++;
				sum += Math.pow(10, (length--) - 1) * index;
				System.out.println("SUM - " + sum);
			}
		}
		sum = (double) (hasDecimal == true ? sum / Math.pow(10, effectiveLegnth) : sum);
		return isNegative == false ? sum : sum * -1;
	}

	public static void main(String[] args) throws Exception {
		Node root = generateBST();
		preOrderTraversal(root);
		System.out.println("\n");
		postOrderTraversal(root);
		System.out.println("\n");
		inorderTraversal(root);
		System.out.println("\n");

		System.out.println(parseInt("455 "));
		System.out.println(parseInt("-333"));
		System.out.println(parseInt("0.0333"));
		System.out.println(parseInt("-  -333"));
	}

}
