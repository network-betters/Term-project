package betters;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



public class Call extends JFrame {
	private JPanel contentPane;
	private Quiz quiz;
	private Client client;
	private PrintWriter out;
	private int point;
	
	public Call(Quiz q, PrintWriter pw, Client c, int p) {
		client = c;
		out = pw;
		quiz = q;
		point = p;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 190);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDo = new JLabel("Do or Die");
		lblDo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDo.setBounds(123, 12, 99, 18);
		contentPane.add(lblDo);

		JLabel differ = new JLabel("you have to raise: " + point);
		differ.setBounds(133, 42, 200, 18);
		contentPane.add(differ);

		JButton btnDo = new JButton("Do");
		btnDo.setBounds(58, 87, 105, 27);
		contentPane.add(btnDo);
		btnDo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				client.calPoint(point);
				out.println("CALL");
				dispose();
			}
		});

		JButton btnDie = new JButton("Die");
		btnDie.setBounds(186, 87, 105, 27);
		contentPane.add(btnDie);
		btnDie.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				quiz.ChattingUser.setEditable(false);
				out.println("CALL");
				dispose();
			}
		});
	}
}