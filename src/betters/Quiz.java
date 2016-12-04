package betters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Quiz extends JFrame {
	public boolean client_ready = false;
	private JPanel QuizPane;
	private JTextField ChattingUser;
	private PrintWriter out;
	private BufferedReader in;
	private int currentP = 0;

	public Quiz(BufferedReader br, PrintWriter pw, int point) {
		this.in = br;
		this.out = pw;
		this.currentP = point;
		
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Quiz.class.getResource("/com/sun/javafx/scene/web/skin/Bold_16x16_JFX.png")));
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
				if (client_ready == false) {
					client_ready = true;
					out.println("READY");
				} else
					client_ready = false;
			}
		});
		btnReady.setBounds(477, 287, 138, 47);
		btnReady.setBackground(new Color(23, 85, 110));
		btnReady.setIcon(new ImageIcon("../image/ready.png"));

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(476, 346, 116, 42);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out.println("EXIT");
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
		UserList.setBounds(477, 71, 116, 236);
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

		JLabel lblPoint = new JLabel("Point : " + currentP);
		lblPoint.setFont(new Font("Kristen ITC", Font.BOLD, 15));
		lblPoint.setForeground(Color.WHITE);
		lblPoint.setBounds(477, 41, 115, 18);
		QuizPane.add(lblPoint);
	}
}
