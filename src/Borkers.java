import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Borkers {
	public static void main(String[] args) throws MalformedURLException, IOException {
		int a = 1;

		int b = a++;

		int c = ++b;

		System.out.println(a + " " + b + " " + c);

		a = 1 << 2;
		System.out.println(a);

		System.out.println(max(3, 4));

		HttpURLConnection connection = (HttpURLConnection) new URL("http://www.google.com/nohelp").openConnection();
		if (connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
			System.out.println("Page not found");
		}

		final char SEPARATOR = 0x20;
		final int MESSAGE_TYPE = 1;

		System.out.println(SEPARATOR + MESSAGE_TYPE + "=A");

	}

	static int max(int a, int b) {

		return (a > b) ? a : b;

	}
}
