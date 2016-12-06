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
      lblYourExtraPoint.setText("Your Extra Point : " + currentP);
   }
   
   public MainMenu(String Username, PrintWriter pw, int point) {
      icon=new ImageIcon("C://Users//À¯¹Î//Documents//GitHub//Term-project//src//image//MainMenu.png");
      
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

      JLabel lblChoice = new JLabel("");
      lblChoice.setBounds(39, 33, 174, 28);
      lblChoice.setFont(new Font("Elephant", Font.BOLD, 22));
      MainManuPane.add(lblChoice);

      lblYourExtraPoint = new JLabel("Your Extra Point : " + currentP);
      lblYourExtraPoint.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
      lblYourExtraPoint.setBounds(294, 12, 207, 18);
      MainManuPane.add(lblYourExtraPoint);

      JButton btnchoMoive = new JButton("Moive");
      btnchoMoive.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 0 " + currentP);
         }
      });
      btnchoMoive.setBounds(49, 85, 127, 36);
      MainManuPane.add(btnchoMoive);

      JButton btnchoProgram = new JButton("Programming");
      btnchoProgram.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 1 " + currentP);
         }
      });
      btnchoProgram.setBounds(48, 140, 128, 36);
      MainManuPane.add(btnchoProgram);

      JButton btnchoSocial = new JButton();
      btnchoSocial.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 2 " + currentP);
         }
      });
      btnchoSocial.setBounds(49, 195, 140, 36);
      btnchoSocial.setContentAreaFilled(false);
      btnchoSocial.setBorderPainted(false);
      btnchoSocial.setIcon(new ImageIcon("C://Users//À¯¹Î//Documents//GitHub//Term-project//src//image//game.png"));
      MainManuPane.add(btnchoSocial);

      JLabel lblSubjective = new JLabel("");
      lblSubjective.setFont(new Font("MV Boli", Font.BOLD, 22));
      lblSubjective.setBounds(227, 33, 174, 28);
      MainManuPane.add(lblSubjective);

      JButton btnSubMovie = new JButton("Movie");
      btnSubMovie.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 3 " + currentP);
         }
      });
      btnSubMovie.setBounds(253, 85, 127, 36);
      MainManuPane.add(btnSubMovie);

      JButton btnSubProgramming = new JButton("Programming");
      btnSubProgramming.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 4 " + currentP);
         }
      });
      btnSubProgramming.setBounds(253, 140, 127, 36);
      MainManuPane.add(btnSubProgramming);

      JButton btnSubSocial = new JButton("Social");
      btnSubSocial.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 5 " + currentP);
         }
      });
      btnSubSocial.setBounds(253, 195, 127, 36);
      MainManuPane.add(btnSubSocial);

      JLabel lblSpeed = new JLabel("");
      lblSpeed.setFont(new Font("Harlow Solid Italic", Font.BOLD, 22));
      lblSpeed.setBounds(444, 35, 116, 28);
      MainManuPane.add(lblSpeed);

      JButton btnSpMovie = new JButton("Moive");
      btnSpMovie.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 6 " + currentP);
         }
      });
      btnSpMovie.setBounds(444, 85, 127, 36);
      MainManuPane.add(btnSpMovie);

      JButton btnSpProgramming = new JButton("Programming");
      btnSpProgramming.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 7 " + currentP);
         }
      });
      btnSpProgramming.setBounds(444, 140, 127, 36);
      MainManuPane.add(btnSpProgramming);

      JButton btnSpSocial = new JButton("Social");
      btnSpSocial.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("ENTER 8 " + currentP);
         }
      });
      btnSpSocial.setBounds(444, 195, 127, 36);
      MainManuPane.add(btnSpSocial);

      JLabel lblchoEnter = new JLabel("");
      lblchoEnter.setBounds(46, 214, 147, 18);
      MainManuPane.add(lblchoEnter);

      JLabel lblchoRaise = new JLabel("");
      lblchoRaise.setBounds(46, 239, 149, 18);
      MainManuPane.add(lblchoRaise);

      JLabel lblSubEnter = new JLabel("");
      lblSubEnter.setBounds(250, 212, 157, 18);
      MainManuPane.add(lblSubEnter);

      JLabel lblSubRaise = new JLabel("");
      lblSubRaise.setBounds(250, 239, 151, 18);
      MainManuPane.add(lblSubRaise);

      JLabel lblSpEnter = new JLabel("");
      lblSpEnter.setBounds(444, 212, 157, 18);
      MainManuPane.add(lblSpEnter);

      JLabel lblSpRaise = new JLabel("");
      lblSpRaise.setBounds(444, 239, 157, 18);
      MainManuPane.add(lblSpRaise);

      JButton btnPractice = new JButton("Just Join!");
      btnPractice.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            out.println("PRACTICE");
         }
      });
      btnPractice.setBounds(627, 68, 150, 132);
      btnPractice.setContentAreaFilled(false);
      btnPractice.setBorderPainted(false);
      //btnPractice.setIcon(new ImageIcon("C://Users//À¯¹Î//Documents//GitHub//Term-project//src//image//quiz.png"));
      MainManuPane.add(btnPractice);

      JLabel lblPractice = new JLabel("");
      lblPractice.setFont(new Font("Hobo BT", Font.BOLD, 22));
      lblPractice.setBounds(627, 43, 150, 18);
      MainManuPane.add(lblPractice);

      JLabel lblNoEnterFee = new JLabel("");
      lblNoEnterFee.setBounds(652, 214, 110, 18);
      MainManuPane.add(lblNoEnterFee);

      JLabel lblGetPoints = new JLabel("");
      lblGetPoints.setBounds(652, 239, 101, 18);
      MainManuPane.add(lblGetPoints);

      JLabel lblWelcome = new JLabel(Username);
      lblWelcome.setBounds(137, 11, 250, 18);
      lblWelcome.setForeground(Color.WHITE);
      lblWelcome.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
      MainManuPane.add(lblWelcome);   
      }
   
}