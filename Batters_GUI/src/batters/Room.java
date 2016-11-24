package batters;

import java.io.BufferedReader;

public class Room extends Thread {
	private int id = 0;
	private boolean start = false;
	private DataBox dataBox;
	private Problem problem;
	private String type = "";
	private int userNum = 0;
	private int entranceFee = 0;
	private int currentP = 0; // current point in this room
	private int minimumRR = 0; // minimum raise rate
	private int maximumRR = 0; // maximum raise rate
	String msg;

	public Room(String topic, String type, int entranceFee, int minimumRR, DataBox dataBox) {
		try {
			this.problem = new ProblemDao(topic).get();
			this.type = type;
			this.entranceFee = entranceFee;
			this.minimumRR = minimumRR;
			this.dataBox = dataBox;

			dataBox.setRoom(minimumRR, start, problem, type, entranceFee, entranceFee, minimumRR, minimumRR);
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
