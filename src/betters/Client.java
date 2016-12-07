package betters;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Client {
	Login_User login;
	MainMenu mainmenu;
	Quiz quiz;
	Betting betting;
	private Socket socket;
	BufferedReader in;
	PrintWriter out;
	DataBox dataBox;
	private int currentP;
	String userName;
	private int raise = 0;

	public Client() throws Exception {
		socket = new Socket("127.0.0.1", 827);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		dataBox = new DataBox();
		currentP = 1000;
	}

	public void run() throws Exception {
		login = new Login_User(out);
		login.setVisible(true);

		while (true) {
			String msg = in.readLine();
			System.out.println(msg);
			if (msg.equals("SUBMIT")) {
				// 로그인 실패 했을 때
				JOptionPane.showMessageDialog(null, "This nick name is already existed. Write over again.");
			} else if (msg.startsWith("LOGIN")) {
				// sign in success!
				userName = msg.substring(6);
				login.dispose();
				mainmenu = new MainMenu(userName, out, currentP);
				mainmenu.setVisible(true);
			} else if (msg.startsWith("ENTERED")) {
				// charge entrance fee
				currentP -= Integer.parseInt(in.readLine());
				out.println(currentP);

				// 메인메뉴 포커스 사라지게
				mainmenu.setExtraPoint(currentP);
				quiz = new Quiz(out);
				quiz.setVisible(true);
			} else if (msg.startsWith("UPDATE")) {
				dataBox.decrypt(msg.substring(7));
				quiz.setLbl(dataBox);
			} else if (msg.startsWith("MESSAGE")) {
				quiz.chat(msg.substring(7));
			} else if (msg.startsWith("START")) {
				dataBox.setQuiz(msg.substring(6));
				
				betting = new Betting(userName, out, dataBox.maxP, dataBox.minRR);
				betting.setSubtopic(dataBox.problem.getSub_topic());
				betting.setVisible(true);
			} else if (msg.startsWith("RAISE")) {
				StringTokenizer token = new StringTokenizer(msg.substring(6), ":");
				String name = token.nextToken();
				int point = Integer.parseInt(token.nextToken());
				
				if (userName.equals(name)) {
					betting.setVisible(false);
					currentP -= point;
				}

				dataBox.cumulativeP += point;
				mainmenu.setExtraPoint(currentP);
				quiz.setLbl(dataBox);
			} else if (msg.startsWith("CALL")) {
				
			} else if (msg.startsWith("DONE")) {
				quiz.showProblem(dataBox.problem.getProblem());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Client client = new Client();
		client.run();
	}

}