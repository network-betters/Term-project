package batters;

import java.io.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client extends JFrame{
	
	private Socket socket;
	BufferedReader in;
    PrintWriter out;
    
    public Client() throws Exception {
		socket = new Socket("127.0.0.1", 827);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
	}
    
    private void run() throws IOException{
    	Login_User login = new Login_User();
    	login.setVisible(true);
    	
    	
		while(true){
			String msg = in.readLine();
			System.out.println(msg);
		}
    }
	
	public static void main(String args[]) throws Exception {
		Client new_User = new Client();
		new_User.run();
	}
	
	class Login_User extends JFrame{

		private JPanel LoginPane;
		private JTextField EnterName;
		private JButton btnSubmit;
		public String Enter_UserName = "";
		
		public Login_User(){
			setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/sun/javafx/scene/web/skin/Bold_16x16_JFX.png")));
			setTitle("Login");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 294, 180);
			LoginPane = new JPanel();
			LoginPane.setBackground(Color.WHITE);
			LoginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(LoginPane);
			
			JLabel lblEnterYourNickname = new JLabel("Enter Your Nickname");
			lblEnterYourNickname.setFont(new Font("Bodoni MT", Font.BOLD, 19));
			
			EnterName = new JTextField();
			EnterName.setBackground(Color.LIGHT_GRAY);
			EnterName.setColumns(10);
			
			btnSubmit = new JButton("Submit");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Enter_UserName = EnterName.getText();
					MainManu mainmanu = new MainManu(Enter_UserName);
					mainmanu.setVisible(true);
					dispose();
				}
			});
			GroupLayout gl_LoginPane = new GroupLayout(LoginPane);
			gl_LoginPane.setHorizontalGroup(
				gl_LoginPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_LoginPane.createSequentialGroup()
						.addGap(49)
						.addGroup(gl_LoginPane.createParallelGroup(Alignment.LEADING)
							.addComponent(EnterName)
							.addComponent(lblEnterYourNickname, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(48, Short.MAX_VALUE))
					.addGroup(gl_LoginPane.createSequentialGroup()
						.addGap(92)
						.addComponent(btnSubmit)
						.addContainerGap(97, Short.MAX_VALUE))
			);
			gl_LoginPane.setVerticalGroup(
				gl_LoginPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_LoginPane.createSequentialGroup()
						.addGap(27)
						.addComponent(lblEnterYourNickname)
						.addGap(2)
						.addComponent(EnterName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnSubmit)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			LoginPane.setLayout(gl_LoginPane);
		}
	}

	class MainManu extends JFrame{
		private JPanel MainManuPane;
		private JTextField textUserName;
		
		public MainManu(String Username){
			setForeground(Color.WHITE);
			setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/com/sun/javafx/scene/web/skin/Bold_16x16_JFX.png")));
			setTitle("Main Manu");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 827, 317);
			MainManuPane = new JPanel();
			MainManuPane.setBackground(Color.WHITE);
			MainManuPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(MainManuPane);
			MainManuPane.setLayout(null);
			
			JLabel lblChoice = new JLabel("Choice Quiz");
			lblChoice.setBounds(39, 33, 174, 28);
			lblChoice.setFont(new Font("Elephant", Font.BOLD, 22));
			MainManuPane.add(lblChoice);
			
			JButton btnchoMoive = new JButton("Moive");
			btnchoMoive.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Quiz choMovie;
					choMovie = new Quiz();
					choMovie.setVisible(true);
					out.println("ENTER\n");
				}
			});
			btnchoMoive.setBounds(49, 68, 127, 36);
			MainManuPane.add(btnchoMoive);
			
			JButton btnchoProgramming = new JButton("Programming");
			btnchoProgramming.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Quiz choProgramming;
					choProgramming = new Quiz();
					choProgramming.setVisible(true);
					
				}
			});
			btnchoProgramming.setBounds(48, 116, 128, 36);
			MainManuPane.add(btnchoProgramming);
			
			JButton btnchoSocial = new JButton("Social");
			btnchoSocial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Quiz choSocial;
					choSocial = new Quiz();
					choSocial.setVisible(true);
				}
			});
			btnchoSocial.setBounds(49, 164, 127, 36);
			MainManuPane.add(btnchoSocial);
			
			JLabel lblSubjective = new JLabel("Subjective Quiz");
			lblSubjective.setFont(new Font("MV Boli", Font.BOLD, 22));
			lblSubjective.setBounds(227, 33, 174, 28);
			MainManuPane.add(lblSubjective);
			
			JButton btnSubMovie = new JButton("Movie");
			btnSubMovie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Quiz SubMovie;
					SubMovie = new Quiz();
					SubMovie.setVisible(true);
				}
			});
			btnSubMovie.setBounds(253, 68, 127, 36);
			MainManuPane.add(btnSubMovie);
			
			JButton btnSubProgramming = new JButton("Programming");
			btnSubProgramming.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Quiz SubProgramming;
					SubProgramming = new Quiz();
					SubProgramming.setVisible(true);
				}
			});
			btnSubProgramming.setBounds(253, 116, 127, 36);
			MainManuPane.add(btnSubProgramming);
			
			JButton btnSubSocial = new JButton("Social");
			btnSubSocial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Quiz SubSocial;
					SubSocial = new Quiz();
					SubSocial.setVisible(true);
				}
			});
			btnSubSocial.setBounds(253, 164, 127, 36);
			MainManuPane.add(btnSubSocial);
			
			JLabel lblSpeed = new JLabel("Speed Quiz");
			lblSpeed.setFont(new Font("Harlow Solid Italic", Font.BOLD, 22));
			lblSpeed.setBounds(444, 35, 116, 28);
			MainManuPane.add(lblSpeed);
			
			JButton btnSpMovie = new JButton("Moive");
			btnSpMovie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Quiz SpMovie;
					SpMovie = new Quiz();
					SpMovie.setVisible(true);
				}
			});
			btnSpMovie.setBounds(444, 68, 127, 36);
			MainManuPane.add(btnSpMovie);
			
			JButton btnSpProgramming = new JButton("Programming");
			btnSpProgramming.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Quiz SpProgramming;
					SpProgramming = new Quiz();
					SpProgramming.setVisible(true);
				}
			});
			btnSpProgramming.setBounds(444, 116, 127, 36);
			MainManuPane.add(btnSpProgramming);
			
			JButton btnSpSocial = new JButton("Social");
			btnSpSocial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Quiz SpSocial;
					SpSocial = new Quiz();
					SpSocial.setVisible(true);
				}
			});
			btnSpSocial.setBounds(444, 164, 127, 36);
			MainManuPane.add(btnSpSocial);
			
			JLabel lblchoEnter = new JLabel("Enter fee : 100 points");
			lblchoEnter.setBounds(46, 214, 147, 18);
			MainManuPane.add(lblchoEnter);
			
			JLabel lblchoRaise = new JLabel("Raise fee : 50 points");
			lblchoRaise.setBounds(46, 239, 149, 18);
			MainManuPane.add(lblchoRaise);
			
			JLabel lblSubEnter = new JLabel("Enter fee : 200 points");
			lblSubEnter.setBounds(250, 212, 157, 18);
			MainManuPane.add(lblSubEnter);
			
			JLabel lblSubRaise = new JLabel("Raise fee : 120 points");
			lblSubRaise.setBounds(250, 239, 151, 18);
			MainManuPane.add(lblSubRaise);
			
			JLabel lblSpEnter = new JLabel("Enter fee : 300 points");
			lblSpEnter.setBounds(444, 212, 157, 18);
			MainManuPane.add(lblSpEnter);
			
			JLabel lblSpRaise = new JLabel("Raise fee : 200 points");
			lblSpRaise.setBounds(444, 239, 157, 18);
			MainManuPane.add(lblSpRaise);
			
			JButton btnPractice = new JButton("Just Join!");
			btnPractice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Quiz Practice;
					Practice = new Quiz();
					Practice.setVisible(true);
				}
			});
			btnPractice.setBounds(627, 68, 150, 132);
			MainManuPane.add(btnPractice);
			
			JLabel lblPractice = new JLabel("Pactice Quiz");
			lblPractice.setFont(new Font("Hobo BT", Font.BOLD, 22));
			lblPractice.setBounds(627, 43, 150, 18);
			MainManuPane.add(lblPractice);
			
			JLabel lblNoEnterFee = new JLabel("No any fee!");
			lblNoEnterFee.setBounds(652, 214, 110, 18);
			MainManuPane.add(lblNoEnterFee);
			
			JLabel lblGetPoints = new JLabel("Get 2 points!");
			lblGetPoints.setBounds(652, 239, 101, 18);
			MainManuPane.add(lblGetPoints);
			
			JLabel lblWelcome = new JLabel("Welcome! " + Username);
			lblWelcome.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
			lblWelcome.setBounds(39, 12, 250, 18);
			MainManuPane.add(lblWelcome);
			
			JLabel lblYourExtraPoint = new JLabel("Your extra point :");
			lblYourExtraPoint.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
			lblYourExtraPoint.setBounds(294, 12, 207, 18);
			MainManuPane.add(lblYourExtraPoint);
		}
	}

	class Quiz extends JFrame{
		public boolean client_ready = false;
		private JPanel QuizPane;
		private JTextField ChattingUser;
		
		public Quiz(){
			setIconImage(Toolkit.getDefaultToolkit().getImage(Quiz.class.getResource("/com/sun/javafx/scene/web/skin/Bold_16x16_JFX.png")));
			setTitle("Quiz");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 629, 447);
			QuizPane = new JPanel();
			QuizPane.setBackground(new Color(12, 42, 53));
			QuizPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(QuizPane);
			
			ChattingUser = new JTextField();
			ChattingUser.setBounds(14, 364, 449, 24);
			ChattingUser.setColumns(10);
			
			JButton btnReady = new JButton("Ready");
			btnReady.setSelectedIcon(null);
			btnReady.setContentAreaFilled(false);
			btnReady.setBorderPainted(false);
			btnReady.setFocusPainted(false);
			btnReady.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(client_ready == false)
						client_ready = true;
					else
						client_ready = false;
				}
			});
			btnReady.setBounds(477, 287, 138, 47);
			btnReady.setBackground(new Color(23, 85, 110));
			btnReady.setIcon(new ImageIcon("C:\\Users\\\uC720\uBBFC\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uB808\uB514\uC544\uC774\uCF582.png"));
			
			JButton btnExit = new JButton("Exit");
			btnExit.setBounds(476, 346, 116, 42);
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnExit.setBackground(new Color(255, 235, 205));
			
			JTextArea ProblemArea = new JTextArea();
			ProblemArea.setEditable(false);
			ProblemArea.setForeground(new Color(255, 255, 240));
			ProblemArea.setBackground(new Color(23, 85, 110));
			ProblemArea.setBounds(14, 39, 449, 145);
			
			JTextArea ChattingArea = new JTextArea();
			ChattingArea.setBounds(14, 196, 449, 156);
			QuizPane.setLayout(null);
			QuizPane.add(ChattingUser);
			QuizPane.add(ChattingArea);
			QuizPane.add(ProblemArea);
			QuizPane.add(btnReady);
			QuizPane.add(btnExit);
			
			JTextArea UserList = new JTextArea();
			UserList.setEditable(false);
			UserList.setForeground(new Color(255, 255, 240));
			UserList.setBackground(new Color(23, 85, 110));
			UserList.setBounds(477, 71, 116, 204);
			QuizPane.add(UserList);
			
			JLabel lblMaximumRaise = new JLabel("Maximum Raise Rate : ");
			lblMaximumRaise.setFont(new Font("Kristen ITC", Font.BOLD, 15));
			lblMaximumRaise.setForeground(new Color(255, 255, 240));
			lblMaximumRaise.setBounds(14, 12, 265, 18);
			QuizPane.add(lblMaximumRaise);
			
			JLabel lblCumulative = new JLabel("Cumulative Point : ");
			lblCumulative.setFont(new Font("Kristen ITC", Font.BOLD, 15));
			lblCumulative.setForeground(new Color(255, 255, 240));
			lblCumulative.setBounds(318, 12, 275, 18);
			QuizPane.add(lblCumulative);
			
			JLabel lblPoint = new JLabel("Point : ");
			lblPoint.setFont(new Font("Kristen ITC", Font.BOLD, 15));
			lblPoint.setForeground(Color.WHITE);
			lblPoint.setBounds(477, 41, 115, 18);
			QuizPane.add(lblPoint);
		}
	}
}