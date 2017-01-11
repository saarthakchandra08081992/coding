import java.util.Arrays;

public class Heaps {

	private int size = 0;
	private int capacity = 10;

	private int heapElements[] = new int[capacity];

	private int getParentIndex(int index) {
		if (index == 0)
			throw new IllegalArgumentException();
		return (int) (Math.ceil(index / 2.0) - 1);
	}

	/**
	 * 
	 * @param index
	 * @return -1 if there is no such element
	 */
	private int leftIndex(int index) {
		return index * 2 + 1 < capacity ? index * 2 + 1 : -1;
	}

	private int getValueAtLeftIndex(int index) {
		return leftIndex(index);
	}

	private int getValueAtRightIndex(int index) {
		return rightIndex(index);
	}

	/**
	 * 
	 * @param index
	 * @return -1 if there is no such element
	 */
	private int rightIndex(int index) {
		return index * 2 + 2 < capacity ? index * 2 + 2 : -1;
	}

	private void insert(int element) {
		if (!isFull()) {
			heapElements[size] = element;
			size++;
			// maintain heap property
			minHeapify();
		} else
			throw new IllegalStateException();
	}

	private void swap(int index1, int index2) {
		int temp = heapElements[index1];
		heapElements[index1] = heapElements[index2];
		heapElements[index2] = temp;
	}

	private void minHeapify() {
		int index1 = size - 1;
		printHeapContents();
		while (size > 1 && index1 > 0) {
			System.out.println(getParentIndex(index1) + " --- ");
			if (heapElements[index1] < heapElements[getParentIndex(index1)]) {
				swap(index1, getParentIndex(index1));
			}
			index1 = getParentIndex(index1);
		}
	}

	private boolean isFull() {
		if (capacity == size)
			return true;
		return false;
	}

	private void adjustSize() {
		heapElements = Arrays.copyOf(heapElements, capacity * 2);
		capacity *= 2;
	}

	private void printHeapContents() {
		for (int i = 0; i < size; i++) {
			System.out.println("Element : " + heapElements[i]);
		}
		System.out.println(" ---------------- ");
	}

	public static void main(String[] args) {

		Heaps heap = new Heaps();
		heap.insert(3);
		heap.insert(1);
		heap.insert(4);
		heap.insert(100);
		heap.insert(0);
		heap.printHeapContents();

	}
}
