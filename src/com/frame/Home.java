package com.frame;

import java.awt.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {
	
	JButton buttonRock, buttonPaper, buttonScissor;
	JLabel sysChoice;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// to terminate JVM while closing the GUI
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// ------------ components -------------------------
		addComponents();
		
		
		
		
	}
	
	private void addComponents() {
		
		// 1) System score Label 
		JLabel sysScoreLabel = new JLabel("System : 0");
		sysScoreLabel.setBounds(0,43,450,30);
		sysScoreLabel.setFont(new Font("Dialog",Font.BOLD, 26)); 
		sysScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(sysScoreLabel);
		
		// 2) System Choice
		sysChoice = new JLabel("?");
		sysChoice.setBounds(175,118,98,81);
		sysChoice.setFont(new Font("Dialog",Font.PLAIN,18));
		sysChoice.setHorizontalAlignment(SwingConstants.CENTER);
		sysChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		getContentPane().add(sysChoice);
		
		// 3) Player score Label
		JLabel playerScoreLabel = new JLabel("Player : 0");
		playerScoreLabel.setBounds(0,317,450,30);
		playerScoreLabel.setFont(new Font("Dialog",Font.BOLD, 26)); 
		playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(playerScoreLabel);
		
		// 4) Rock Paper Scissor Buttons
		
		// -> Rock
		buttonRock = new JButton("Rock");
		buttonRock.setBounds(60,387,105,81);
		buttonRock.setFont(new Font("Dialog",Font.PLAIN,18));
		add(buttonRock);
		// -> Paper
		buttonPaper = new JButton("Paper");
		buttonPaper.setBounds(185,387,105,81);
		buttonPaper.setFont(new Font("Dialog",Font.PLAIN,18));
		add(buttonPaper);
		// -> Scissor
		buttonScissor = new JButton("Scissor");
		buttonScissor.setBounds(310,387,105,81);
		buttonScissor.setFont(new Font("Dialog",Font.PLAIN,18));
		add(buttonScissor);
		
	}
	
	private void showPopUp(String message) {
		
		JDialog resultPopUp = new JDialog(this,"Result",true);
		resultPopUp.setSize(227,124);
		resultPopUp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		resultPopUp.setResizable(false);
		
		JLabel resultLabel = new JLabel(message);
		resultLabel.setFont(new Font("Dialog",Font.PLAIN,18));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultPopUp.add(resultLabel);
		
		JButton tryAgainButton = new JButton("Try Again");
		tryAgainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sysChoice.setText("?");
				resultPopUp.dispose(); // to close the dialog box
			}
			
		});
		
		
	}
	
	

}
