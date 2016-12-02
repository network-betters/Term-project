package batters;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class DataBox {
	public static HashSet<BufferedReader> readers = new HashSet<BufferedReader>();
	public static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
	StringTokenizer token;
	private InputStream out;
	private int id = 0;
	private boolean start = false;
	private Problem problem;
	private String type = "";
	private int userNum = 0;
	private int readyNum = 0;
	private int entranceFee = 0;
	private int currentP = 0; // current point in this room
	private int minRR = 0; // minimum raise rate
	private int maxP = 0; // maximum point for betting
	String msg;

	public String enter(BufferedReader reader, PrintWriter writer) {
		if (!readers.contains(reader)) {
			readers.add(reader);
			writers.add(writer);

			userNum++;
		}
		
		return id + ":" + currentP + ":" + minRR + ":" + maxP + "\n";
	}
	

	public void leave(BufferedReader reader, PrintWriter writer) {
		if (!readers.contains(reader)) {
			readers.remove(reader);
			writers.remove(writer);

			userNum--;
		}
	}
	

	public void sendToClient(String msg) throws Exception {
		for (PrintWriter writer : writers) {
			writer.println(msg + "\n");
		}
	}

	public void setMaxP(int point) {
		if (userNum == 0) {
			maxP = point;
		} else if (point < maxP) {
			maxP = point;
		}
		
		currentP += point;
	}

	public int getEntranceFee() {
		return entranceFee;
	}

	public void decrypt(String str) {
		token = new StringTokenizer(str, ":");
		id = Integer.parseInt(token.nextToken());
		currentP = Integer.parseInt(token.nextToken());
		minRR = Integer.parseInt(token.nextToken());
		maxP = Integer.parseInt(token.nextToken());
	}

	public void setRoom(int id, boolean start, Problem problem, String type, int entranceFee, int minRR) {
		this.id = id;
		this.start = start;
		this.problem = problem;
		this.type = type;
		this.entranceFee = entranceFee;
		this.minRR = minRR;
	}
}
