

public class Fibo {

	private static void fib() {
		int a = 0, b = 1;
		int ctr = 0;
		int sum;
		System.out.println(a + " ");
		System.out.println(b + " ");
		while (ctr++ < 100) {
			sum = a + b;
			System.out.println(sum + " ");
			a=b;
			b=sum;
		}
	}

	public static void main(String[] args) {
		fib();
	}
}
