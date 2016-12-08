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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class Call extends JFrame {
	private JPanel contentPane;
	private Quiz quiz;
	private Client client;
	private PrintWriter out;
	private int point;
	ImageIcon icon;
	
	public Call(Quiz q, PrintWriter pw, Client c, int p) {
		client = c;
		out = pw;
		quiz = q;
		point = p;
		icon = new ImageIcon("./src/image/callbg.png");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 240);
		contentPane = new JPanel(){
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

		JLabel lblDo = new JLabel("");
		lblDo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDo.setBounds(123, 12, 99, 18);
		contentPane.add(lblDo);

		JLabel differ = new JLabel("you have to raise: " + point);
		differ.setBounds(110, 63, 200, 18);
		differ.setFont(new Font("Bauhaus 93", Font.PLAIN, 18));
		differ.setForeground(Color.WHITE);
		contentPane.add(differ);

		JButton btnDo = new JButton("");
		btnDo.setBounds(58, 110, 105, 27);
		btnDo.setContentAreaFilled(false);
		btnDo.setBorderPainted(false);
		btnDo.setIcon(new ImageIcon("./src/image/do.png"));
		btnDo.setRolloverIcon(new ImageIcon("./src/image/dop.png"));
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
		btnDie.setBounds(186, 110, 105, 27);
		btnDie.setContentAreaFilled(false);
		btnDie.setBorderPainted(false);
		btnDie.setIcon(new ImageIcon("./src/image/die.png"));
		btnDie.setRolloverIcon(new ImageIcon("./src/image/diep.png"));
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