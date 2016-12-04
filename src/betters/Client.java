package betters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Client {
	private Socket socket;
	BufferedReader in;
	PrintWriter out;
	DataBox dataBox;
	String name;
	private int currentP;
	Scanner keyboard = new Scanner(System.in);

	public Client() throws Exception {
		socket = new Socket("127.0.0.1", 827);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		dataBox = new DataBox();
		System.out.println("client created");
		currentP = 1000;
	}

	public void run() throws Exception {
		Login_User login = new Login_User(dataBox, in, out, currentP);
		login.setVisible(true);
		
		while(true){
			
		}
	}

	public static void main(String[] args) throws Exception {
		Client client = new Client();
		client.run();
	}

		
}
