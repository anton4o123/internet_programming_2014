import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CapitalizeHomework {
	public static void main(String[] args) throws IOException {
		System.out.println(capitalizeSymbols(getLine()));
	}
	
	private static String getLine() throws IOException {
		final InputStream input = System.in;
		final InputStreamReader inputStreamReader = new InputStreamReader(input);
		final BufferedReader reader = new BufferedReader(inputStreamReader);
		
		return reader.readLine();
	}
	
	private static String capitalizeSymbols(String line) {
		return line.toUpperCase();
	}
}