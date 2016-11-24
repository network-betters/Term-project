package batters;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;

public class DataBox {
	public static HashSet<BufferedReader> readers = new HashSet<BufferedReader>();
	public static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
	private InputStream out;	
	private int id = 0;
	private boolean start = false;
	private Problem problem;
	private String type = "";
	private int entranceFee = 0;
	private int currentP = 0; //current point in this room
	private int minimumRR = 0; //minimum raise rate
	private int maximumRR = 0; //maximum raise rate
	String msg;
	
	public void enter(BufferedReader reader, PrintWriter writer) {
		if(!readers.contains(reader)) {
			readers.add(reader);
			writers.add(writer);
		}
	}
	
	public void leave(BufferedReader reader, PrintWriter writer) {
		if(!readers.contains(reader)) {
			readers.remove(reader);
			writers.remove(writer);
		}
	}
		
	public void sendToClient(String msg) throws Exception{ 
		for(PrintWriter writer : writers) {
			writer.println(msg + "\n");
		}
	}
	
	public void setRoom(int id, boolean start, Problem problem, String type, int entranceFee, int currentP, int minimumRR, int maximumRR) {
		this.id = id;
		this.start = start;
		this.problem = problem;
		this.type = type;
		this.entranceFee = entranceFee;
		this.currentP = currentP;
		this.minimumRR = minimumRR;
		this.maximumRR = maximumRR;
	}

}
