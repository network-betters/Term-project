package batters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

	private JPanel MainManuPane;
	private JTextField textUserName;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public GUI(String Username) {
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
				GUI_basic_quiz choMovie;
				try {
					choMovie = new GUI_basic_quiz();
					choMovie.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnchoMoive.setBounds(49, 68, 127, 36);
		MainManuPane.add(btnchoMoive);
		
		JButton btnchoProgramming = new JButton("Programming");
		btnchoProgramming.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_basic_quiz choProgramming;
				try {
					choProgramming = new GUI_basic_quiz();
					choProgramming.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnchoProgramming.setBounds(48, 116, 128, 36);
		MainManuPane.add(btnchoProgramming);
		
		JButton btnchoSocial = new JButton("Social");
		btnchoSocial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_basic_quiz choSocial;
				try {
					choSocial = new GUI_basic_quiz();
					choSocial.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				GUI_basic_quiz SubMovie;
				try {
					SubMovie = new GUI_basic_quiz();
					SubMovie.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubMovie.setBounds(253, 68, 127, 36);
		MainManuPane.add(btnSubMovie);
		
		JButton btnSubProgramming = new JButton("Programming");
		btnSubProgramming.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_basic_quiz SubProgramming;
				try {
					SubProgramming = new GUI_basic_quiz();
					SubProgramming.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubProgramming.setBounds(253, 116, 127, 36);
		MainManuPane.add(btnSubProgramming);
		
		JButton btnSubSocial = new JButton("Social");
		btnSubSocial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_basic_quiz SubSocial;
				try {
					SubSocial = new GUI_basic_quiz();
					SubSocial.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				GUI_basic_quiz SpMovie;
				try {
					SpMovie = new GUI_basic_quiz();
					SpMovie.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSpMovie.setBounds(444, 68, 127, 36);
		MainManuPane.add(btnSpMovie);
		
		JButton btnSpProgramming = new JButton("Programming");
		btnSpProgramming.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_basic_quiz SpProgramming;
				try {
					SpProgramming = new GUI_basic_quiz();
					SpProgramming.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSpProgramming.setBounds(444, 116, 127, 36);
		MainManuPane.add(btnSpProgramming);
		
		JButton btnSpSocial = new JButton("Social");
		btnSpSocial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_basic_quiz SpSocial;
				try {
					SpSocial = new GUI_basic_quiz();
					SpSocial.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				GUI_basic_quiz Practice;
				try {
					Practice = new GUI_basic_quiz();
					Practice.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		MainManuPane.add(lblWelcome);
	}

	public GUI() {

	}
}
