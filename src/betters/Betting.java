package betters;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Betting extends JFrame {

	private JPanel contentPane;
	private JTextField Raise;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Betting frame = new Betting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Betting() {
		setTitle("Betting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel minR = new JLabel("<");
		minR.setFont(new Font("Kristen ITC", Font.BOLD, 15));
		minR.setBounds(36, 59, 62, 24);
		contentPane.add(minR);
		
		JLabel maxR = new JLabel("<");
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
		
		JButton btnDie = new JButton("Die");
		btnDie.setBounds(209, 95, 105, 27);
		contentPane.add(btnDie);
	}
}
