package com.frame;

import java.util.Random;

public class RockPaperScissor {
	
	private static final String[] sysChoices = {"Rock","Paper","Scissor"};
	private String sysChoice;
	private int systemScore, playerScore;
	
	
	public String getSysChoice() {
		return sysChoice;
	}

	public int getSystemScore() {
		return systemScore;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	private Random random;
	
	public RockPaperScissor() {
		random = new Random();
	}
	
	public String startGame(String playerChoice) {
		String result= "";
		sysChoice = sysChoices[random.nextInt(3)];
		
		if(sysChoice.equals("Rock")) {
			if(playerChoice.equals("Paper")) {
				result = "You Win !";
				playerScore++;
			} else if(playerChoice.equals("Scissor")) {
				result = "You loose";
				systemScore++;
			} else {
				result = "Its a draw";
			}
		} else if(sysChoice.equals("Paper")) {
			if(playerChoice.equals("Scissor")) {
				result = "You Win !";
				playerScore++;
			} else if(playerChoice.equals("Rock")) {
				result = "You loose";
				systemScore++;
			} else {
				result = "Its a draw";
			}
		} else {
			if(playerChoice.equals("Rock")) {
				result = "You Win !";
				playerScore++;
			} else if(playerChoice.equals("Paper")) {
				result = "You loose";
				systemScore++;
			} else {
				result = "Its a draw";
			}
		}
		
		return result;
	}

}
