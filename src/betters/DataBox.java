package betters;

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
	private boolean start = false;
	private Problem problem;
	private int userNum = 0;
	private int readyNum = 0;
	private int entranceFee = 0;
	private int cumulativeP = 0; // current point in this room
	private int minRR = 0; // minimum raise rate
	private int maxP = 0; // maximum point for betting
	String msg;

	public void enter(BufferedReader reader, PrintWriter writer) {
		int point;
		if (!readers.contains(reader)) {
			readers.add(reader);
			writers.add(writer);

			//charge entrance fee
			writer.println(entranceFee);
			userNum++;
			
			try {
				point = Integer.parseInt(reader.readLine());
				
				//set maximum point
				if (userNum == 1) {
					maxP = point;
				} else if (point < maxP) { 
					maxP = point;
				}
			}catch(Exception e) {
				e.printStackTrace(); 
			}
			
			//send dataBox information
			writer.println(cumulativeP + ":" + minRR + ":" + maxP);
		}
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


	public int getEntranceFee() {
		cumulativeP += entranceFee;
		return entranceFee;
	}
	
	public void decrypt(String str) {
		token = new StringTokenizer(str, ":");
		cumulativeP = Integer.parseInt(token.nextToken());
		minRR = Integer.parseInt(token.nextToken());
		maxP = Integer.parseInt(token.nextToken());
		System.out.println(cumulativeP + " " + minRR + " " + maxP);
	}

	public DataBox setRoom(int entranceFee, int minRR) {
		this.entranceFee = entranceFee;
		this.minRR = minRR;
		
		return this;
	}
}
