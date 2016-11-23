
public class EntropyAI {
public static void main(String[] args) {
	
	double positive = 3,negative = 4;
	double a = (double)1/2;
	double b=  (double)1/2;
	
	double sum = positive+negative;
	
	double entropyP = -(positive/(sum))*log((positive/(sum)),2);
	double entropyN = -(negative/(sum))*log((negative/(sum)),2);
	System.out.println("Answer is : "+(entropyN+entropyP));
	
//	entropy(a,b);
}

static double log(double x, int base)
{
    return (double) (Math.log(x) / Math.log(base));
}

static void entropy(double a,double b){
	double entropyP = -(a)*log(a,2);
	double entropyN = -(b)*log(b,2);
	System.out.println("Answer is : "+(entropyN+entropyP));
}

}
