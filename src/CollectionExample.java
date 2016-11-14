import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionExample {

	
	public static void main(String[] args) {
		String buf = new String("  Saarthak,  Chandra is   good");
		List<String> list = Arrays.asList(buf.trim().split(","));
		printStrings(list);
		
		Pattern pat = Pattern.compile("([a-z|A-Z]+)");
		Matcher mat = pat.matcher(buf);
		
		System.out.println();
		while(mat.find()){
			System.out.println("Matched is  - "+mat.group(0));
		}
	}
	
	public static void printStrings(List<String> list){
		for(String str : list){
			System.out.print(str);
		}
	}
}
