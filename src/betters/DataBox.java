package betters;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class DataBox {
	StringTokenizer token;
	public HashSet<PrintWriter> out = new HashSet<PrintWriter>(); 
	private boolean start = false;
	private Problem problem;
	private int userNum = 0;
	private int readyNum = 0;
	private int entranceFee = 0;
	public int cumulativeP = 0; // current point in this room
	public int minRR = 0; // minimum raise rate
	public int maxP = 0; // maximum point for betting
	String msg;

	public DataBox setRoom(int entranceFee, int minRR) {
		this.entranceFee = entranceFee;
		this.minRR = minRR;

		return this;
	}

	public boolean getStatus() {
		return start;
	}

	public String enter(PrintWriter pt, int point) {
		if(!out.contains(pt)){
			userNum++;
			
			out.add(pt);
			
			//update cumulative point
			cumulativeP += entranceFee;
			
			// set maximum point
			if (userNum == 1) {
				maxP = point;
			} else if (point < maxP) {
				maxP = point;
			}
		}
		return "UPDATE " + cumulativeP + ":" + minRR + ":" + maxP;
	}

	public void leave(PrintWriter pt) {
		out.remove(pt);
		
		userNum--;
	}

	public int getEntranceFee() {
		return entranceFee;
	}

	public void decrypt(String str) {
		token = new StringTokenizer(str, ":");
		cumulativeP = Integer.parseInt(token.nextToken());
		minRR = Integer.parseInt(token.nextToken());
		maxP = Integer.parseInt(token.nextToken());
	}

	public boolean getReady() {
		readyNum++;

		return (readyNum == userNum) ? true : false;
	}

}
