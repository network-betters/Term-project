package betters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Betting extends JFrame {
	private String userName;
	private int maxP = 0;
	private int minRR = 0;
	private PrintWriter out;
	private JPanel contentPane;
	private JTextField Raise;
	JLabel lblSubTopic;
	Quiz quiz;
	ImageIcon icon;
	
	public void setting(int min, int max) {
		maxP = max;
		minRR = min;
	}
	
	public void setting(int max) {
		maxP = max;
	}

	public void setSubtopic(String sub) {
		lblSubTopic.setText("Sub Topic : " + sub);
	}
	/**
	 * Create the frame.
	 */
	public Betting(Quiz q, String name, PrintWriter pw, int max, int min) {
		userName = name;
		out = pw;
		maxP = max;
		minRR = min;
		quiz = q;
		icon = new ImageIcon("./src/image/bettingbg.png");

		setTitle("Betting");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 265);
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Raise = new JTextField();
		Raise.setBounds(120, 125, 185, 24);
		contentPane.add(Raise);
		Raise.setColumns(10);

		JLabel minR = new JLabel(minRR + " <");
		minR.setFont(new Font("Bauhaus 93", Font.PLAIN, 17));
		minR.setForeground(Color.WHITE);
		minR.setBounds(65, 125, 62, 24);
		contentPane.add(minR);

		JLabel maxR = new JLabel("< " + maxP);
		maxR.setFont(new Font("Bauhaus 93", Font.PLAIN, 17));
		maxR.setForeground(Color.WHITE);
		maxR.setBounds(320, 125, 62, 24);
		contentPane.add(maxR);

		JButton btnDo = new JButton("");
		btnDo.setBounds(105, 160, 105, 27);
		btnDo.setContentAreaFilled(false);
		btnDo.setBorderPainted(false);
		btnDo.setIcon(new ImageIcon("./src/image/do.png"));
		btnDo.setRolloverIcon(new ImageIcon("./src/image/dop.png"));
		contentPane.add(btnDo);
		btnDo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				out.println("BETTING " + userName + ":" + Raise.getText());
			}
		});

		JButton btnDie = new JButton("");
		btnDie.setBounds(228, 160, 105, 27);
		btnDie.setContentAreaFilled(false);
		btnDie.setBorderPainted(false);
		btnDie.setIcon(new ImageIcon("./src/image/die.png"));
		btnDie.setRolloverIcon(new ImageIcon("./src/image/diep.png"));
		btnDie.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				quiz.ChattingUser.setEditable(false);
				out.println("CALL");
				dispose();
			}
		});
		contentPane.add(btnDie);

		lblSubTopic = new JLabel("Sub Topic : ");
		lblSubTopic.setFont(new Font("Bauhaus 93", Font.PLAIN, 18));
		lblSubTopic.setForeground(Color.WHITE);
		lblSubTopic.setBounds(167, 85, 200, 18);
		contentPane.add(lblSubTopic);
	}
}
