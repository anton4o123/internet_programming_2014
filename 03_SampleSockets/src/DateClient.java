import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class DateClient {
	private static final int SERVER_PORT = 9877;
	private static final String SERVER = "localhost";
	private Socket clientSocket;
	
	DateClient() throws UnknownHostException, IOException {
		this.clientSocket = new Socket(SERVER, SERVER_PORT);
	}

	public static void main(String[] args) throws IOException {
		DateClient d = new DateClient();
		d.send();
		System.out.println(d.receive());
	}
	
	private static String getDate() throws IOException {
		final InputStream input = System.in;
		final InputStreamReader inputStreamReader = new InputStreamReader(input);
		final BufferedReader reader = new BufferedReader(inputStreamReader);
		System.out.print("Please enter date: ");
		return reader.readLine();
	}
	
	private void send() throws IOException {
		final OutputStream outputStream = clientSocket.getOutputStream();
		final PrintWriter out = new PrintWriter(outputStream);
		
		out.println(getDate());
		out.flush();
	}
	
	private String receive() throws IOException {
		final InputStream inputStream = clientSocket.getInputStream();
		
		final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		final BufferedReader in = new BufferedReader(inputStreamReader);
		
		return in.readLine();
	}
}