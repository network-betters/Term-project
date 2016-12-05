package betters;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;


public class Login_User extends JFrame {
	private PrintWriter out;
	private JPanel LoginPane;
	private JTextField EnterName;
	private JButton btnSubmit;
	ImageIcon bg;
	public String Enter_UserName = "";
	
	public Login_User(PrintWriter pt) throws IOException{
		this.out = pt;
		bg = new ImageIcon("/betters/src/image/LOGIN.png");

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Login.class.getResource("/com/sun/javafx/scene/web/skin/Bold_16x16_JFX.png")));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 294, 180);
		LoginPane= new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(bg.getImage(), 0, 0, null);
				Dimension d = getSize();
				g.drawImage(bg.getImage(), 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		LoginPane.setBackground(Color.BLACK);
		LoginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(LoginPane);

		JLabel lblEnterYourNickname = new JLabel("Enter Your Nickname");
		lblEnterYourNickname.setFont(new Font("Bodoni MT", Font.BOLD, 19));

		EnterName = new JTextField();
		EnterName.setBackground(Color.LIGHT_GRAY);
		EnterName.setColumns(10);
 
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(EnterName.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Name is empty. Write please.");
				else
					out.println(EnterName.getText());
			}
		});
		GroupLayout gl_LoginPane = new GroupLayout(LoginPane);
		gl_LoginPane.setHorizontalGroup(gl_LoginPane.createParallelGroup(Alignment.LEADING).addGroup(gl_LoginPane
				.createSequentialGroup().addGap(49)
				.addGroup(gl_LoginPane.createParallelGroup(Alignment.LEADING).addComponent(EnterName).addComponent(
						lblEnterYourNickname, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(48, Short.MAX_VALUE))
				.addGroup(gl_LoginPane.createSequentialGroup().addGap(92).addComponent(btnSubmit).addContainerGap(97,
						Short.MAX_VALUE)));
		gl_LoginPane.setVerticalGroup(gl_LoginPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LoginPane.createSequentialGroup().addGap(27).addComponent(lblEnterYourNickname).addGap(2)
						.addComponent(EnterName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnSubmit)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		LoginPane.setLayout(gl_LoginPane);
	}
}
