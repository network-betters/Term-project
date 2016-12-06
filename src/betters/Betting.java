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
		setBounds(100, 100, 427, 190);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Raise = new JTextField();
		Raise.setBounds(103, 59, 185, 24);
		contentPane.add(Raise);
		Raise.setColumns(10);
		
		JLabel minR = new JLabel(minRR + " <");
		minR.setFont(new Font("Kristen ITC", Font.BOLD, 15));
		minR.setBounds(36, 59, 62, 24);
		contentPane.add(minR);
		
		JLabel maxR = new JLabel("< " + maxP);
		maxR.setFont(new Font("Kristen ITC", Font.BOLD, 15));
		maxR.setBounds(295, 59, 62, 24);
		contentPane.add(maxR);
		
		JLabel lblDoOrDie = new JLabel("Do or Die");
		lblDoOrDie.setFont(new Font("Kristen ITC", Font.BOLD, 17));
		lblDoOrDie.setBounds(145, 29, 106, 18);
		contentPane.add(lblDoOrDie);
		
		JButton btnDo = new JButton("Do");
		btnDo.setBounds(90, 95, 105, 27);
		contentPane.add(btnDo);
		btnDo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				out.println("BETTING " + userName + ":" + Raise.getText());
			}
		});
		
		JButton btnDie = new JButton("Die");
		btnDie.setBounds(209, 95, 105, 27);
		contentPane.add(btnDie);
	}
}
