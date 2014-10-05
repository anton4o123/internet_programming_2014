import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateServer {
	private static final int SERVER_PORT = 9877;
	private boolean running = true;
	
	private class ClientHandler extends Thread {
		private final Socket clientSocket;
		
		public ClientHandler(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}
		
		public void run() {
			try {
				handleClient(clientSocket);
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void handleClient(final Socket clientSocket) throws IOException, ParseException {
			final InputStream inputStream = clientSocket.getInputStream();
			final OutputStream outputStream = clientSocket.getOutputStream();
			
			final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			final BufferedReader in = new BufferedReader(inputStreamReader);
			
			final PrintWriter out = new PrintWriter(outputStream);
			
			final String readLine = in.readLine();
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dateStr = formatter.parse(readLine);
			
			Date currentDate = new Date();
			
			out.println((dateStr.getTime()-currentDate.getTime())/(24*60*60*1000));
			out.flush();
			
			clientSocket.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new DateServer().run();
	}
	
	public void run() throws IOException {
		final ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
		
		while(running) {
			final Socket clientSocket = serverSocket.accept();
			new ClientHandler(clientSocket).start();
		}
		
		serverSocket.close();
	}
}