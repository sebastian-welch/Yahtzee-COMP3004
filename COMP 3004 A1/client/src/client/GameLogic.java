package client;

import java.util.Random;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GameLogic {
	private Die[] die = new Die[5];
	private int rollNum;
	private int playerScore;
	private ClientGUI gui;
	private JButton diceRoller;
	
	private boolean[] scoreState = new boolean[13];
	
	private boolean endRound = false;
	private boolean allowScoring = false;
	
	private JButton[] diceLock = new JButton[5];
	
	private Request serverRequest = new Request();
	private ObjectOutputStream out;
	
	public GameLogic(ObjectOutputStream o){
		out = o;
		
		for(int i = 0; i < die.length; i++)
			die[i] = new Die();
		for(int i = 0; i < scoreState.length; i++)
			scoreState[i] = true;
		
		rollNum = 1;
		playerScore = 0;
		gui = new ClientGUI(die);
		
		diceRoller = gui.getRoller();
		diceLock = gui.getLocks();
		
		//ROLLER ACTION LISTENER
		diceRoller.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				rollDice();
			}
		});
		
		//LOCK ACTION LISTENERS
		//-------------------------------------------------
		diceLock[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(die[0].getHeld() == false){
					diceLock[0].setText("Unlock");
					die[0].setHeld(true);
				}
				else{
					diceLock[0].setText("Lock");
					die[0].setHeld(false);
				}
			}
		});
		
		diceLock[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(die[1].getHeld() == false){
					diceLock[1].setText("Unlock");
					die[1].setHeld(true);
				}
				else{
					diceLock[1].setText("Lock");
					die[1].setHeld(false);
				}
			}
		});
		
		diceLock[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(die[2].getHeld() == false){
					diceLock[2].setText("Unlock");
					die[2].setHeld(true);
				}
				else{
					diceLock[2].setText("Lock");
					die[2].setHeld(false);
				}
			}
		});
		
		diceLock[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(die[3].getHeld() == false){
					diceLock[3].setText("Unlock");
					die[3].setHeld(true);
				}
				else{
					diceLock[3].setText("Lock");
					die[3].setHeld(false);
				}
			}
		});
		
		diceLock[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(die[4].getHeld() == false){
					diceLock[4].setText("Unlock");
					die[4].setHeld(true);
				}
				else{
					diceLock[4].setText("Lock");
					die[4].setHeld(false);
				}
			}
		});
		//-------------------------------------------------
		
		//SCORE BUTTON ACTION LISTENERS
		//-------------------------------------------------
		gui.getAces().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				for(int i = 0; i < die.length; i++){
					if(die[i].getValue() == 1)
						playerScore += 1;
				}
				scoreState[0] = false;
				endRound();
			}
		});
		
		gui.getTwos().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				for(int i = 0; i < die.length; i++){
					if(die[i].getValue() == 2)
						playerScore += 2;
				}
				scoreState[1] = false;
				endRound();
			}
		});
		
		gui.getThrees().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				for(int i = 0; i < die.length; i++){
					if(die[i].getValue() == 3)
						playerScore += 3;
				}
				scoreState[2] = false;
				endRound();
			}
		});
		
		gui.getFours().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				for(int i = 0; i < die.length; i++){
					if(die[i].getValue() == 4)
						playerScore += 4;
				}
				scoreState[3] = false;
				endRound();
			}
		});
		
		gui.getFives().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				for(int i = 0; i < die.length; i++){
					if(die[i].getValue() == 5)
						playerScore += 5;
				}
				scoreState[4] = false;
				endRound();
			}
		});
		
		gui.getSixes().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				for(int i = 0; i < die.length; i++){
					if(die[i].getValue() == 6)
						playerScore += 6;
				}
				scoreState[5] = false;
				endRound();
			}
		});
		
		gui.getThreeKind().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				scoreState[6] = false;
				endRound();
			}
		});
		
		gui.getFourKind().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				scoreState[7] = false;
				endRound();
			}
		});
		
		gui.getFullHouse().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				scoreState[8] = false;
				endRound();
			}
		});
		
		gui.getSmStraight().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				scoreState[9] = false;
				endRound();
			}
		});
		
		gui.getLgStraight().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				scoreState[10] = false;
				endRound();
			}
		});
		
		gui.getYahtzee().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				scoreState[11] = false;
				endRound();
			}
		});
		
		gui.getChance().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				scoreState[12] = false;
				endRound();
			}
		});
		//-------------------------------------------------
	}
	
	//Initialize the dice
	public void setupGame(){
		for(int i = 0; i < die.length; i++){
			die[i].setValue(0);
			die[i].setHeld(false);
		}
	}
	
	//Roll the dice
	public void rollDice(){
		Random roll = new Random();
		
		if(rollNum == 1){
			for(int i = 0; i < diceLock.length; i++){
				diceLock[i].setEnabled(true);
				gui.setScoreState(scoreState);
			}
			allowScoring = true;
		}
		
		for(int i = 0; i < 5; i++){
			if (die[i].getHeld() == false)
				die[i].setValue(roll.nextInt(6) + 1);
		}
		
		rollNum++;
		gui.setDice(die);
		gui.setRollNum(rollNum);
		
		//Disable the dice roller
		if(rollNum > 3){
			diceRoller.setEnabled(false);
			gui.setRollNum(-1);
		}
	}
	
	//Disable all buttons, end round after scoring
	public void endRound(){
		try{
			gui.setScoreStateFalse();
			gui.setScore(playerScore);
		
			for(int i = 0; i < diceLock.length; i++)
				diceLock[i].setEnabled(false);
		
			diceRoller.setEnabled(false);
			endRound = true;
			out.writeObject(getGameStatus());
			out.flush();
			allowScoring = false;
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	//For sending score board state to server
	
	//Translating score board state from server
	public boolean[] deserializeScoreLock(String scoreStatus){
		boolean[] newScoreStatus = new boolean[13];
		String[] splitScoreStatus = new String[13];
		splitScoreStatus = scoreStatus.split(",");
		
		for(int i = 0; i < splitScoreStatus.length; i++){
			if(splitScoreStatus[i].equals("true"))
				newScoreStatus[i] = true;
			else
				newScoreStatus[i] = false;
		}
		setScoreStatus(newScoreStatus);
		return newScoreStatus;
	}
	
	public Request getGameStatus() { return serverRequest; }
	public boolean getRoundStatus(){return endRound; }
	
	public void setScoreStatus(boolean[] newScoreStatus){
		for(int i = 0; i < scoreState.length; i++)
			scoreState[i] = newScoreStatus[i];
		if(allowScoring)
			gui.setScoreState(scoreState);
	}
}
