package betters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Quiz extends JFrame {
	public boolean client_ready = false;
	JTextArea ProblemArea;
	JTextArea ChattingArea;
	JTextArea UserList;
	JLabel lblMaximumRaise;
	JLabel lblCumulative;
	JLabel lblminR;
	JLabel lblPoint;
	JScrollPane scroll;
	private JPanel QuizPane;
	public JTextField ChattingUser;
	private PrintWriter out;
	private ImageIcon icon;
	JButton btnReady;

	public void showProblem(String problem) {
		ProblemArea.setText(problem);
	}

	public void showProblem(String problem, ArrayList<String> example) {
		ProblemArea.append(problem + "\n");
		ProblemArea.append(example.get(0) + "\t" + example.get(1) + example.get(2));
	}

	public void setLbl(int point, DataBox db) {
		lblPoint.setText("" + point);
		lblMaximumRaise.setText("" + db.maxP);
		lblCumulative.setText("" + db.cumulativeP);
		lblminR.setText("" + db.minRR);
	}

	public void chat(String msg) {
		ChattingArea.append(msg + "\n");
		ChattingArea.setCaretPosition(ChattingArea.getDocument().getLength());
	}

	public void userList(String names) {
		StringTokenizer token = new StringTokenizer(names, ":");
		UserList.setText("");
		
		while(token.hasMoreTokens()) {
			UserList.append(token.nextToken() + "\n");
		}
	}

	public Quiz(PrintWriter pw) {
		this.out = pw;
		icon = new ImageIcon("./src/image/Quiz.png");

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Quiz.class.getResource("/com/sun/javafx/scene/web/skin/Bold_16x16_JFX.png")));
		setTitle("Quiz");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 629, 493);
		QuizPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		QuizPane.setBackground(new Color(12, 42, 53));
		QuizPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(QuizPane);

		ChattingUser = new JTextField();
		ChattingUser.setBounds(14, 403, 449, 24);
		ChattingUser.setColumns(10);
		ChattingUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				out.println("MESSAGE" + ChattingUser.getText());
				ChattingUser.setText("");
			}
		});

		btnReady = new JButton();
		btnReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String msg;
					if (client_ready == false) {
						client_ready = true;
						out.println("READY");
						btnReady.setIcon(new ImageIcon("./src/image/readyp.png"));
					} else {
						btnReady.setIcon(new ImageIcon("./src/image/ready.png"));
						client_ready = false;
					}
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		btnReady.setBounds(477, 330, 116, 42);
		btnReady.setContentAreaFilled(false);
		btnReady.setBorderPainted(false);
		btnReady.setIcon(new ImageIcon("./src/image/ready.png"));
		btnReady.setRolloverIcon(new ImageIcon("./src/image/readyp.png"));
		btnReady.setBackground(new Color(23, 85, 110));

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(476, 385, 116, 42);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out.println("EXIT");
				dispose();
			}
		});
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setIcon(new ImageIcon("./src/image/exit.png"));
		btnExit.setBackground(new Color(255, 235, 205));

		ProblemArea = new JTextArea();
		ProblemArea.setEditable(false);
		ProblemArea.setFont(new Font("Bauhaus 93", Font.PLAIN, 18));
		ProblemArea.setForeground(new Color(255, 255, 240));
		ProblemArea.setBackground(new Color(23, 85, 110));
		ProblemArea.setBounds(14, 83, 449, 145);

		ChattingArea = new JTextArea();
		ChattingArea.setBounds(14, 240, 449, 156);
		ChattingArea.setEditable(false);
		scroll = new JScrollPane(ChattingArea);
		scroll.setOpaque(false);
		scroll.setBounds(14, 240, 449, 156);
		scroll.setViewportView(ChattingArea);
		QuizPane.add(scroll);

		QuizPane.setLayout(null);
		QuizPane.add(ChattingUser);
		QuizPane.add(ProblemArea);
		QuizPane.add(btnReady);
		QuizPane.add(btnExit);

		UserList = new JTextArea();
		UserList.setEditable(false);
		UserList.setForeground(new Color(255, 255, 240));
		UserList.setBackground(new Color(23, 85, 110));
		UserList.setBounds(477, 80, 116, 236);
		QuizPane.add(UserList);

		lblMaximumRaise = new JLabel("");
		lblMaximumRaise.setFont(new Font("Bauhaus 93", Font.PLAIN, 18));
		lblMaximumRaise.setForeground(new Color(255, 255, 240));
		lblMaximumRaise.setBounds(188, 28, 265, 18);
		QuizPane.add(lblMaximumRaise);

		lblCumulative = new JLabel("");
		lblCumulative.setFont(new Font("Bauhaus 93", Font.PLAIN, 18));
		lblCumulative.setForeground(new Color(255, 255, 240));
		lblCumulative.setBounds(468, 28, 275, 18);
		QuizPane.add(lblCumulative);

		lblminR = new JLabel("");
		lblminR.setFont(new Font("Bauhaus 93", Font.PLAIN, 18));
		lblminR.setForeground(Color.WHITE);
		lblminR.setBounds(188, 56, 115, 18);
		QuizPane.add(lblminR);

		lblPoint = new JLabel("");
		lblPoint.setFont(new Font("Bauhaus 93", Font.PLAIN, 18));
		lblPoint.setForeground(Color.WHITE);
		lblPoint.setBounds(468, 56, 275, 18);
		QuizPane.add(lblPoint);
	}
}
