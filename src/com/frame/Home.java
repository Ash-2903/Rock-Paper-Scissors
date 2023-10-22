package com.frame;

import java.awt.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


public class Home extends JFrame implements ActionListener {
	
	JButton buttonRock, buttonPaper, buttonScissor;
	JLabel sysChoice, sysScoreLabel, playerScoreLabel;
	
	RockPaperScissor rps ;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		
		super("Rock Paper Scissor");
		
		// -------------- initial window --------------------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(201, 200, 255));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// to terminate JVM while closing the GUI
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Initialize RockPaperScissor class
		rps = new RockPaperScissor();
		
		// ------------ components -------------------------
		addComponents();
		
		
		
		
	}
	
	private void addComponents() {
		
		// 1) System score Label 
		sysScoreLabel = new JLabel("Computer : 0");
		sysScoreLabel.setBounds(0,222,476,30);
		sysScoreLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 26)); 
		sysScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(sysScoreLabel);
		
		// 2) System Choice
		sysChoice = new JLabel("?");
		sysChoice.setBackground(new Color(255, 255, 255));
		sysChoice.setOpaque(true);
		sysChoice.setBounds(185,94,98,81);
		sysChoice.setFont(new Font("Dialog",Font.PLAIN,18));
		sysChoice.setHorizontalAlignment(SwingConstants.CENTER);
		sysChoice.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		getContentPane().add(sysChoice);
		
		// 3) Player score Label
		playerScoreLabel = new JLabel("Player : 0");
		playerScoreLabel.setBounds(0,291,476,30);
		playerScoreLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 26)); 
		playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(playerScoreLabel);
		
		// 4) Rock Paper Scissor Buttons
		
		// -> Rock
		buttonRock = new JButton("Rock");
		buttonRock.setBounds(60,387,105,81);
		buttonRock.setFont(new Font("Dialog",Font.PLAIN,18));
		buttonRock.addActionListener(this);
		getContentPane().add(buttonRock);
		// -> Paper
		buttonPaper = new JButton("Paper");
		buttonPaper.setBounds(185,387,105,81);
		buttonPaper.setFont(new Font("Dialog",Font.PLAIN,18));
		buttonPaper.addActionListener(this);
		getContentPane().add(buttonPaper);
		// -> Scissor
		buttonScissor = new JButton("Scissor");
		buttonScissor.setBounds(310,387,105,81);
		buttonScissor.setFont(new Font("Dialog",Font.PLAIN,18));
		buttonScissor.addActionListener(this);
		getContentPane().add(buttonScissor);
		
		// showPopUp("test message");
		
	}
	
	private void showPopUp(String message) {
		
		JDialog resultPopUp = new JDialog(this,"Result",true);
		resultPopUp.setSize(227,124);
		resultPopUp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		resultPopUp.setResizable(false);
		
		JLabel resultLabel = new JLabel(message);
		resultLabel.setFont(new Font("Dialog",Font.PLAIN,18));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultPopUp.getContentPane().add(resultLabel,BorderLayout.CENTER);
		
		JButton tryAgainButton = new JButton("Try Again");
		tryAgainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sysChoice.setText("?");
				resultPopUp.dispose(); // to close the dialog box
			}
			
		});
		
		resultPopUp.getContentPane().add(tryAgainButton, BorderLayout.SOUTH);
		resultPopUp.setLocationRelativeTo(this);
		resultPopUp.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String playerChoice = e.getActionCommand().toString();
		
		String result = rps.startGame(playerChoice);
		
		sysChoice.setText(rps.getSysChoice());
		sysScoreLabel.setText("Computer : " + rps.getSystemScore());
		playerScoreLabel.setText("Player : " + rps.getPlayerScore());
		
		showPopUp(result);
		
		
	}
	
	

}
