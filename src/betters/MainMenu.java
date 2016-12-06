package betters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class MainMenu extends JFrame {
   final JLabel lblYourExtraPoint;
   private JPanel MainManuPane;
   private PrintWriter out;
   private int currentP = 0;
   
   JScrollPane scrollPane;
   ImageIcon icon;
   
   public void setExtraPoint(int point) {
      currentP = point;
      lblYourExtraPoint.setText("" + currentP);
   }
   
   public MainMenu(String Username, PrintWriter pw, int point) {
      icon=new ImageIcon("./src/image/MainMenu.png");
      
      this.out = pw;
      this.currentP = point;
      setForeground(Color.WHITE);
      setIconImage(Toolkit.getDefaultToolkit()
            .getImage(GUI.class.getResource("/com/sun/javafx/scene/web/skin/Bold_16x16_JFX.png")));
      setTitle("Main Manu");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 827, 356);
      MainManuPane = new JPanel(){
      public void paintComponent(Graphics g){
            g.drawImage(icon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
      }
      };
      MainManuPane.setBackground(Color.WHITE);
      MainManuPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(MainManuPane);
      MainManuPane.setLayout(null);

      lblYourExtraPoint = new JLabel("" + currentP);
      lblYourExtraPoint.setForeground(Color.WHITE);
      lblYourExtraPoint.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
      lblYourExtraPoint.setBounds(504, 12, 207, 18);
      MainManuPane.add(lblYourExtraPoint);

      JButton btnchoMovie = new JButton("");
      btnchoMovie.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 0 " + currentP);
         }
      });
      btnchoMovie.setBounds(49, 85, 140, 36);
      btnchoMovie.setContentAreaFilled(false);
      btnchoMovie.setBorderPainted(false);
      btnchoMovie.setIcon(new ImageIcon("./src/image/movie.png"));
      btnchoMovie.setRolloverIcon(new ImageIcon("./src/image/movie_p.png"));
      MainManuPane.add(btnchoMovie);

      JButton btnchoProgram = new JButton("");
      btnchoProgram.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 1 " + currentP);
         }
      });
      btnchoProgram.setBounds(48, 140, 140, 36);
      btnchoProgram.setContentAreaFilled(false);
      btnchoProgram.setBorderPainted(false);
      btnchoProgram.setIcon(new ImageIcon("./src/image/pro.png"));
      btnchoProgram.setRolloverIcon(new ImageIcon("./src/image/pro_p.png"));
      MainManuPane.add(btnchoProgram);

      JButton btnchoGame = new JButton();
      btnchoGame.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 2 " + currentP);
         }
      });
      btnchoGame.setBounds(49, 195, 140, 36);
      btnchoGame.setContentAreaFilled(false);
      btnchoGame.setBorderPainted(false);
      btnchoGame.setIcon(new ImageIcon("./src/image/game.png"));
      btnchoGame.setRolloverIcon(new ImageIcon("./src/image/game_p.png"));
      MainManuPane.add(btnchoGame);

      JButton btnSubMovie = new JButton("");
      btnSubMovie.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 3 " + currentP);
         }
      });
      btnSubMovie.setBounds(265, 85, 127, 36);
      btnSubMovie.setContentAreaFilled(false);
      btnSubMovie.setBorderPainted(false);
      btnSubMovie.setIcon(new ImageIcon("./src/image/movie.png"));
      btnSubMovie.setRolloverIcon(new ImageIcon("./src/image/movie_p.png"));
      MainManuPane.add(btnSubMovie);

      JButton btnSubProgram = new JButton("");
      btnSubProgram.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 4 " + currentP);
         }
      });
      btnSubProgram.setBounds(265, 140, 127, 36);
      btnSubProgram.setContentAreaFilled(false);
      btnSubProgram.setBorderPainted(false);
      btnSubProgram.setIcon(new ImageIcon("./src/image/pro.png"));
      btnSubProgram.setRolloverIcon(new ImageIcon("./src/image/pro_p.png"));
      MainManuPane.add(btnSubProgram);

      JButton btnSubGame = new JButton("");
      btnSubGame.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 5 " + currentP);
         }
      });
      btnSubGame.setBounds(265, 195, 127, 36);
      btnSubGame.setContentAreaFilled(false);
      btnSubGame.setBorderPainted(false);
      btnSubGame.setIcon(new ImageIcon("./src/image/game.png"));
      btnSubGame.setRolloverIcon(new ImageIcon("./src/image/game_p.png"));
      MainManuPane.add(btnSubGame);

      JButton btnSpMovie = new JButton("");
      btnSpMovie.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 6 " + currentP);
         }
      });
      btnSpMovie.setBounds(465, 85, 127, 36);
      btnSpMovie.setContentAreaFilled(false);
      btnSpMovie.setBorderPainted(false);
      btnSpMovie.setIcon(new ImageIcon("./src/image/movie.png"));
      btnSpMovie.setRolloverIcon(new ImageIcon("./src/image/movie_p.png"));
      MainManuPane.add(btnSpMovie);

      JButton btnSpProgram = new JButton("");
      btnSpProgram.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 7 " + currentP);
         }
      });
      btnSpProgram.setBounds(465, 140, 127, 36);
      btnSpProgram.setContentAreaFilled(false);
      btnSpProgram.setBorderPainted(false);
      btnSpProgram.setIcon(new ImageIcon("./src/image/pro.png"));
      btnSpProgram.setRolloverIcon(new ImageIcon("./src/image/pro_p.png"));
      MainManuPane.add(btnSpProgram);

      JButton btnSpGame = new JButton("");
      btnSpGame.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 8 " + currentP);
         }
      });
      btnSpGame.setBounds(465, 195, 127, 36);
      btnSpGame.setContentAreaFilled(false);
      btnSpGame.setBorderPainted(false);
      btnSpGame.setIcon(new ImageIcon("./src/image/game.png"));
      btnSpGame.setRolloverIcon(new ImageIcon("./src/image/game_p.png"));
      MainManuPane.add(btnSpGame);

      JButton btnPractice = new JButton("");
      btnPractice.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("PRACTICE");
         }
      });
      btnPractice.setBounds(655, 95, 120, 120);
      btnPractice.setContentAreaFilled(false);
      btnPractice.setBorderPainted(false);
      btnPractice.setIcon(new ImageIcon("./src/image/join.png"));
      btnPractice.setRolloverIcon(new ImageIcon("./src/image/join_p.png"));
      MainManuPane.add(btnPractice);

      JLabel lblWelcome = new JLabel(Username);
      lblWelcome.setBounds(137, 11, 250, 19);
      lblWelcome.setForeground(Color.WHITE);
      lblWelcome.setFont(new Font("Bauhaus 93", Font.PLAIN, 21));
      MainManuPane.add(lblWelcome);   
      }
   
}