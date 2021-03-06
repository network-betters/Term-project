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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Login_User extends JFrame {
	private PrintWriter out;
	private JPanel LoginPane;
	private JTextField EnterName;
	private JButton btnSubmit;
	private JLabel back;
	ImageIcon bg;
	public String Enter_UserName = "";
	
	public Login_User(PrintWriter pt){
		this.out = pt;
		bg = new ImageIcon("./src/image/LOGIN.png");
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 180);
		LoginPane = new JPanel(){
		      public void paintComponent(Graphics g){
		             g.drawImage(bg.getImage(), 0, 0, null);
		             setOpaque(false);
		             super.paintComponent(g);
		       }
		       };;
		LoginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(LoginPane);
		LoginPane.setLayout(null);

		JLabel lblEnterYourNickname = new JLabel("Enter Your Nickname");
		lblEnterYourNickname.setFont(new Font("Bodoni MT", Font.BOLD, 19));
		LoginPane.add(lblEnterYourNickname);

		EnterName = new JTextField();
		EnterName.setBackground(Color.WHITE);
		EnterName.setColumns(10);
		EnterName.setBounds(49, 54, 178, 24);
		LoginPane.add(EnterName);
 
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(EnterName.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Name is empty. Write please.");
				else
					out.println(EnterName.getText());
			}
		});
		btnSubmit.setBounds(83, 90, 120, 27);
		btnSubmit.setIcon(new ImageIcon("./src/image/submit.png"));
		btnSubmit.setRolloverIcon(new ImageIcon("./src/image/submitp.png"));
		LoginPane.add(btnSubmit);
	}
}
