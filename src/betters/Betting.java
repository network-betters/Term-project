package betters;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

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

	public void setMaxP(int point) {
		maxP = point;
	}

	public void setSubtopic(String sub) {
		lblSubTopic.setText("Sub Topic : " + sub);
	}
	/**
	 * Create the frame.
	 */
	public Betting(String name, PrintWriter pw, int max, int min) {
		userName = name;
		out = pw;
		maxP = max;
		minRR = min;

		setTitle("Betting");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 427, 213);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Raise = new JTextField();
		Raise.setBounds(109, 91, 185, 24);
		contentPane.add(Raise);
		Raise.setColumns(10);

		JLabel minR = new JLabel(minRR + " <");
		minR.setFont(new Font("Kristen ITC", Font.BOLD, 15));
		minR.setBounds(39, 90, 62, 24);
		contentPane.add(minR);

		JLabel maxR = new JLabel("< " + maxP);
		maxR.setFont(new Font("Kristen ITC", Font.BOLD, 15));
		maxR.setBounds(308, 90, 62, 24);
		contentPane.add(maxR);

		JLabel lblDoOrDie = new JLabel("Do or Die");
		lblDoOrDie.setFont(new Font("Kristen ITC", Font.BOLD, 17));
		lblDoOrDie.setBounds(156, 29, 106, 18);
		contentPane.add(lblDoOrDie);

		JButton btnDo = new JButton("Do");
		btnDo.setBounds(90, 127, 105, 27);
		contentPane.add(btnDo);
		btnDo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				out.println("BETTING " + userName + ":" + Raise.getText());
			}
		});

		JButton btnDie = new JButton("Die");
		btnDie.setBounds(210, 127, 105, 27);
		contentPane.add(btnDie);

		lblSubTopic = new JLabel("Sub Topic : ");
		lblSubTopic.setFont(new Font("Bauhaus 93", Font.PLAIN, 15));
		lblSubTopic.setBounds(100, 61, 200, 18);
		contentPane.add(lblSubTopic);
	}
}
