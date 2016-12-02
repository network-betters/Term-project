package betters;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class GUI_basic_quiz extends JFrame {

	public boolean client_ready = false;
	private JPanel QuizPane;
	private JTextField ChattingUser;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_basic_quiz frame = new GUI_basic_quiz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public GUI_basic_quiz() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_basic_quiz.class.getResource("/com/sun/javafx/scene/web/skin/Bold_16x16_JFX.png")));
		setTitle("Quiz");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 629, 447);
		QuizPane = new JPanel();
		QuizPane.setBackground(new Color(12, 42, 53));
		QuizPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(QuizPane);
		
		ChattingUser = new JTextField();
		ChattingUser.setBounds(14, 364, 449, 24);
		ChattingUser.setColumns(10);
		
		JButton btnReady = new JButton("Ready");
		btnReady.setSelectedIcon(null);
		btnReady.setContentAreaFilled(false);
		btnReady.setBorderPainted(false);
		btnReady.setFocusPainted(false);
		btnReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(client_ready == false)
					client_ready = true;
				else
					client_ready = false;
			}
		});
		btnReady.setBounds(477, 287, 138, 47);
		btnReady.setBackground(new Color(23, 85, 110));
		btnReady.setIcon(new ImageIcon("C:\\Users\\\uC720\uBBFC\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uB808\uB514\uC544\uC774\uCF582.png"));
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(476, 346, 116, 42);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBackground(new Color(255, 235, 205));
		
		JTextArea ProblemArea = new JTextArea();
		ProblemArea.setEditable(false);
		ProblemArea.setForeground(new Color(255, 255, 240));
		ProblemArea.setBackground(new Color(23, 85, 110));
		ProblemArea.setBounds(14, 39, 449, 145);
		
		JTextArea ChattingArea = new JTextArea();
		ChattingArea.setBounds(14, 196, 449, 156);
		QuizPane.setLayout(null);
		QuizPane.add(ChattingUser);
		QuizPane.add(ChattingArea);
		QuizPane.add(ProblemArea);
		QuizPane.add(btnReady);
		QuizPane.add(btnExit);
		
		JTextArea UserList = new JTextArea();
		UserList.setEditable(false);
		UserList.setForeground(new Color(255, 255, 240));
		UserList.setBackground(new Color(23, 85, 110));
		UserList.setBounds(477, 39, 116, 236);
		QuizPane.add(UserList);
		
		JLabel lblMaximumRaise = new JLabel("Maximum Raise Rate : ");
		lblMaximumRaise.setFont(new Font("Kristen ITC", Font.BOLD, 15));
		lblMaximumRaise.setForeground(new Color(255, 255, 240));
		lblMaximumRaise.setBounds(14, 12, 265, 18);
		QuizPane.add(lblMaximumRaise);
		
		JLabel lblCumulative = new JLabel("Cumulative Point : ");
		lblCumulative.setFont(new Font("Kristen ITC", Font.BOLD, 15));
		lblCumulative.setForeground(new Color(255, 255, 240));
		lblCumulative.setBounds(318, 12, 275, 18);
		QuizPane.add(lblCumulative);
	}
}
