package betters;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class NotBetting extends JFrame {

	private JPanel contentPane;
	private ImageIcon back;

	public NotBetting() {
		back = new ImageIcon("./src/image/wait.png");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 245);
		contentPane = new JPanel(){
		      public void paintComponent(Graphics g){
		            g.drawImage(back.getImage(), 0, 0, null);
		            setOpaque(false);
		            super.paintComponent(g);
		      }
		};
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
}
