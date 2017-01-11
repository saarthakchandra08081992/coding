
public class StringPractice {
	public static void main(String[] args) {
		String trial = "See this    ";

		StringBuilder str = new StringBuilder("Saarthak Chandra ; k  ja 34 3 1231 23 123" + trial);
		System.out.println(trial.split(" .")[0].toString());

	}
}
