package betters;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DataBox {
	StringTokenizer token;
	private ArrayList<String>names = new ArrayList<String>();
	public ArrayList<PrintWriter> out = new ArrayList<PrintWriter>();
	private boolean start = false;
	public Problem problem = new Problem();
	private int userNum = 0;
	private int readyNum = 0;
	private int betNum = 0;
	private int entranceFee = 0;
	public int cumulativeP = 0; // current point in this room
	public int minRR = 0; // minimum raise rate
	public int maxP = 0; // maximum point for betting
	public int maxRR = 0;
	String msg;

	public DataBox setRoom(Problem problem, int entranceFee, int minRR) {
		this.problem = problem;
		this.entranceFee = entranceFee;
		this.minRR = minRR;

		return this;
	}

	public boolean getStatus() {
		return start;
	}

	public String enter(PrintWriter pt, String str) {
		token = new StringTokenizer(str, ":");
		String name = token.nextToken();
		int point = Integer.parseInt(token.nextToken());
		
		if (!out.contains(pt)) {
			userNum++;

			names.add(name);
			out.add(pt);

			// update cumulative point
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
		if (out.contains(pt))
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

	public String getQuiz() {
		return problem.getProblem() + ":" + problem.getSub_topic();
	}

	public void setQuiz(String str) {
		token = new StringTokenizer(str, ":");
		problem.setProblem(token.nextToken());
		problem.setSub_topic(token.nextToken());
	}
	
	public String raise(int index, String str) {
		int point;
		
		token = new StringTokenizer(str, ":");
		token.nextToken();
		point = Integer.parseInt(token.nextToken());
		
		if(index == 0) {
			maxRR = point;
		}
		
		if(point > maxRR) {
			maxRR = point;
		}
		
		cumulativeP += point;
		
		return "RAISE " + str;
	}
	
	public boolean call() {
		betNum++;
		if(betNum == userNum)
			return true;
		else 
			return false;
	}
}
