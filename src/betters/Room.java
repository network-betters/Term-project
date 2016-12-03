package betters;

import java.io.BufferedReader;

public class Room extends Thread {
	private Problem problem;
	private String type = "";
	private DataBox dataBox;
	private int entranceFee = 0;
	private int minRR = 0; // minimum raise rate
	private int maxRR = 0; // maximum raise rate
	String msg;

	public Room(String topic, String type, int entranceFee, int minRR, DataBox dataBox) {
		try {
			this.problem = new ProblemDao(topic).get();
			this.type = type;
			this.entranceFee = entranceFee;
			this.minRR = minRR;

			this.dataBox = dataBox.setRoom(entranceFee, minRR);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {

	}

	public String get_msg() {
		return msg;
	}
}
