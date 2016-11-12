
public class ParsingIntFloat {

	public static void main(String[] args) {
		String str = "100,2.0,-100,19.99,0";
	    String[] ns = str.split(",");
	    for(String s: ns){
	        if(s.contains("."))
	            System.out.println("Float: "+ Float.parseFloat(s));
	        else
	            System.out.println("Int: "+ Integer.parseInt(s));
	    }
	}
}
