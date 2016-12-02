package betters;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private final static int PORT = 827;
	private static ArrayList<DataBox> dataBoxes = new ArrayList<DataBox>();
	private static ArrayList<Room> rooms = new ArrayList<Room>();
	private final static int room_num = 9;
	
	public static void main(String[] args) throws Exception {
		for(int i = 0; i < room_num; i++) {
			dataBoxes.add(new DataBox());
			rooms.add(new Room("topic", "type", 100, 50, dataBoxes.get(i)));
		}

		System.out.println("The chat server is running.");
		ServerSocket listener = new ServerSocket(PORT);
		try {
			while (true) {
				new Handler(listener.accept()).start();
			}
		} finally {
			listener.close();
		}
	}

	private static class Handler extends Thread {
		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;

		/**
		 * Constructs a handler thread, squirreling away the socket. All the
		 * interesting work is done in the run method.
		 */
		public Handler(Socket socket) {
			this.socket = socket;
		}

		/**
		 * Services this thread's client by repeatedly requesting a screen name
		 * until a unique one has been submitted, then acknowledges the name and
		 * registers the output stream for the client in a global set, then
		 * repeatedly gets inputs and broadcasts them.
		 */
		public void run() {
			try {
				// Create character streams for the socket.
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);

				while (true) {
					String msg = in.readLine();
					if (msg.startsWith("ENTER")) {
						//client access to the room 
						int room = Integer.parseInt(msg.substring(6));
						if(room >= room_num) {
							out.println("FAILED");
						} else {
							out.println("ENTERED");
							dataBoxes.get(room).enter(in, out);
						}	
					} else if(msg.startsWith("EXIT")) {
						for(DataBox temp : dataBoxes) {
							temp.leave(in, out);
						}
					} else if(msg.startsWith("")) {
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
