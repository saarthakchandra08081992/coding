import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Main {
	private void filter(List<String> list) {

		if (list != null) {
			for (Iterator itr = list.iterator(); itr.hasNext();) {
				if ("bad".equals(itr.next()))
					itr.remove();
				
			}
		}
		
		

		for (String s : list) {
			System.out.println(s + " ");
		}

	}

	public static void main(String[] args) {

	}

	public void someFunction(List<String> list) {
		List<String> test = new ArrayList<String>();
		test.add("Saa");
		test.add("Saad");
		test.add("bad");
		test.add("Saar");

		filter(test);

		// do some work on cleaned "list"

	}

}