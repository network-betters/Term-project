package betters;

public class Room extends Thread {
	private Problem problem;
	private String type = "";
	private DataBox dataBox;

	public Room(String topic, String type, int entranceFee, int minRR, DataBox dataBox) {
		try {
			this.problem = new ProblemDao(topic).get();
			this.type = type;

			this.dataBox = dataBox.setRoom(problem, entranceFee, minRR);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		
	}
}
