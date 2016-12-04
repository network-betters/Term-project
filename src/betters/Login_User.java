package betters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;


public class Login_User extends JFrame {
	private PrintWriter out;
	private BufferedReader in;
	private int currentP = 0;
	private JPanel LoginPane;
	private JTextField EnterName;
	private JButton btnSubmit;
	public String Enter_UserName = "";
	private DataBox dataBox;

	public Login_User(DataBox db, BufferedReader br, PrintWriter pw, int point) {
		this.dataBox = db;
		this.in = br;
		this.out = pw;
		this.currentP = point;
		
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Login.class.getResource("/com/sun/javafx/scene/web/skin/Bold_16x16_JFX.png")));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 294, 180);
		LoginPane = new JPanel();
		LoginPane.setBackground(Color.WHITE);
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
				Enter_UserName = EnterName.getText();
				MainMenu mainmanu = new MainMenu(dataBox, Enter_UserName, in, out, currentP);
				mainmanu.setVisible(true);
				dispose();
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
