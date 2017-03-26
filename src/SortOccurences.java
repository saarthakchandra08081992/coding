import java.util.*;

public class SortOccurences {

	private void sort(int[] array) {
		HashMap<Integer, Integer> map = new HashMap();

		// Create HashMap
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i]) + 1);
			} else
				map.put(array[i], 1);
		}

		Iterator itr = map.entrySet().iterator();

	}

}
