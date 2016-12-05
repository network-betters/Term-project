package betters;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;

public class Server {
	private final static int PORT = 827;
	private static HashSet<String> names = new HashSet<String>();
	private static ArrayList<DataBox> dataBoxes = new ArrayList<DataBox>();
	private static ArrayList<Room> rooms = new ArrayList<Room>();
	private static ArrayList<PrintWriter> writers = new ArrayList<PrintWriter>();
	private final static int room_num = 9;

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < room_num; i++) {
			dataBoxes.add(new DataBox());
			rooms.add(new Room("movies", "type", 100, 50, dataBoxes.get(i)));
			rooms.get(i).start();
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
		String name;

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
				int room = 0;

				do {
					name = in.readLine();
					out.println("SUBMIT");
				} while (names.contains(name));

				out.println("LOGIN " + name);
				names.add(name);
				writers.add(out);

				while (true) {
					String msg = in.readLine();
					System.out.println(msg);
					if (msg.startsWith("ENTER")) {
						// client access to the room
						room = Integer.parseInt(msg.substring(6, 7));
						if (dataBoxes.get(room).getEntranceFee() > Integer.parseInt(msg.substring(8))
								&& !dataBoxes.get(room).getStatus()) {
							out.println("FAILED");
						} else {
							out.println("ENTERED");

							// charge entrance fee
							out.println(dataBoxes.get(room).getEntranceFee());

							// enter the room
							msg = dataBoxes.get(room).enter(out, Integer.parseInt(in.readLine()));

							for (PrintWriter temp : dataBoxes.get(room).out) {
								temp.println(msg);
							}
						}
					} else if (msg.startsWith("EXIT")) {
						for (DataBox temp : dataBoxes) {
							temp.leave(out);
						}
					} else if (msg.startsWith("MESSAGE")) {
						for (PrintWriter temp : dataBoxes.get(room).out) {
							temp.println("MESSAGE " + name + ": " + msg.substring(7));
						}
					} else if (msg.startsWith("READY")) {
						if (dataBoxes.get(room).getReady()) {
							for (PrintWriter temp : dataBoxes.get(room).out) {
								temp.println("START");
								temp.println(dataBoxes.get(room).getQuiz());
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
