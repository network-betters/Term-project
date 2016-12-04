package betters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JFrame {
	final JLabel lblYourExtraPoint;
	private JPanel MainManuPane;
	private PrintWriter out;
	private int currentP = 0;

	public void setExtraPoint(int point) {
		currentP = point;
		lblYourExtraPoint.setText("Your Extra Point : " + currentP);
	}
	
	public MainMenu(String Username, PrintWriter pw, int point) {
		this.out = pw;
		this.currentP = point;

		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GUI.class.getResource("/com/sun/javafx/scene/web/skin/Bold_16x16_JFX.png")));
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

		lblYourExtraPoint = new JLabel("Your Extra Point : " + currentP);
		lblYourExtraPoint.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
		lblYourExtraPoint.setBounds(294, 12, 207, 18);
		MainManuPane.add(lblYourExtraPoint);

		JButton btnchoMoive = new JButton("Moive");
		btnchoMoive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out.println("ENTER 0 " + currentP);
			}
		});
		btnchoMoive.setBounds(49, 68, 127, 36);
		MainManuPane.add(btnchoMoive);

		JButton btnchoProgram = new JButton("Programming");
		btnchoProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out.println("ENTER 1 " + currentP);
			}
		});
		btnchoProgram.setBounds(48, 116, 128, 36);
		MainManuPane.add(btnchoProgram);

		JButton btnchoSocial = new JButton("Social");
		btnchoSocial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out.println("ENTER 2 " + currentP);
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
				out.println("ENTER 3 " + currentP);
			}
		});
		btnSubMovie.setBounds(253, 68, 127, 36);
		MainManuPane.add(btnSubMovie);

		JButton btnSubProgramming = new JButton("Programming");
		btnSubProgramming.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out.println("ENTER 4 " + currentP);
			}
		});
		btnSubProgramming.setBounds(253, 116, 127, 36);
		MainManuPane.add(btnSubProgramming);

		JButton btnSubSocial = new JButton("Social");
		btnSubSocial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out.println("ENTER 5 " + currentP);
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
				out.println("ENTER 6 " + currentP);
			}
		});
		btnSpMovie.setBounds(444, 68, 127, 36);
		MainManuPane.add(btnSpMovie);

		JButton btnSpProgramming = new JButton("Programming");
		btnSpProgramming.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out.println("ENTER 7 " + currentP);
			}
		});
		btnSpProgramming.setBounds(444, 116, 127, 36);
		MainManuPane.add(btnSpProgramming);

		JButton btnSpSocial = new JButton("Social");
		btnSpSocial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out.println("ENTER 8 " + currentP);
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
				out.println("PRACTICE");
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
		lblWelcome.setBounds(39, 12, 250, 18);
		lblWelcome.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
		MainManuPane.add(lblWelcome);
	}
}
