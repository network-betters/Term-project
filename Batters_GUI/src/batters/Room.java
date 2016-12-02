package batters;

import java.io.BufferedReader;

public class Room extends Thread {
	private int id = 0;
	private boolean start = false;
	private DataBox dataBox;
	private Problem problem;
	private String type = "";
	
	private int entranceFee = 0;
	private int currentP = 0; // current point in this room
	private int minRR = 0; // minimum raise rate
	private int maxRR = 0; // maximum raise rate
	String msg;

	public Room(String topic, String type, int entranceFee, int minRR, DataBox dataBox) {
		try {
			this.problem = new ProblemDao(topic).get();
			this.type = type;
			this.entranceFee = entranceFee;
			this.minRR = minRR;
			this.dataBox = dataBox;

			dataBox.setRoom(minRR, start, problem, type, entranceFee, minRR);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			while(true) {
				dataBox.sendToClient("message");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String get_msg() {
		return msg;
	}
}
