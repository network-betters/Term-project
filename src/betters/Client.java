package betters;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

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
				// �α��� ���� ���� ��
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

				// ���θ޴� ��Ŀ�� �������
				mainmenu.setExtraPoint(currentP);
				quiz = new Quiz(out);
				quiz.setVisible(true);
			} else if (msg.startsWith("UPDATE")) {
				dataBox.decrypt(msg.substring(7));
				quiz.setLbl(dataBox);
			} else if (msg.startsWith("MESSAGE")) {
				quiz.chat(msg.substring(7));
			} else if (msg.startsWith("START")) {
				betting = new Betting(userName, out, dataBox.maxP, dataBox.minRR);
				betting.setVisible(true);
			} else if (msg.startsWith("RAISE")) {
				StringTokenizer token = new StringTokenizer(msg.substring(6), ":");
				String name = token.nextToken();
				int point = Integer.parseInt(token.nextToken());

				System.out.println(userName);
				
				if (userName.equals(name)) {
					betting.setVisible(false);
					currentP -= point;
				}

				dataBox.cumulativeP += point;
				mainmenu.setExtraPoint(currentP);
				quiz.setLbl(dataBox);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Client client = new Client();
		client.run();
	}

}