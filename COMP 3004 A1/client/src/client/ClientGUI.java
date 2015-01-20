package client;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClientGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3539956299820039412L;
	private JLabel  rollNum   = new JLabel("Roll#: 1");
	private JLabel[] dieValue = new JLabel[5];
	private JLabel  score     = new JLabel("SCORE POINTS");
	private JLabel  section1  = new JLabel("SECTION 1");
	private JLabel  section2  = new JLabel("SECTION 2");
	private JLabel  playerScore = new JLabel("Your Score: 0");
	
	private JButton[] holdDie  = new JButton[5];
	private JButton rollDice   = new JButton("Roll Dice");
	private JButton aces       = new JButton("Aces");
	private JButton twos       = new JButton("Twos");
	private JButton threes     = new JButton("Threes");
	private JButton fours      = new JButton("Fours");
	private JButton fives      = new JButton("Fives");
	private JButton sixes      = new JButton("Sixes");
	private JButton threeKind  = new JButton("3 of a Kind");
	private JButton fourKind   = new JButton("4 of a Kind");
	private JButton fullHouse  = new JButton("Full House");
	private JButton smStraight = new JButton("Sm. Straight");
	private JButton lgStraight = new JButton("Lg. Straight");
	private JButton yahtzee    = new JButton("YAHTZEE");
	private JButton chance     = new JButton("CHANCE");
	
	public ClientGUI(Die[] gameDice){
		super("Yahtzee");
		for (int i = 0; i < dieValue.length; i++){
			dieValue[i] = new JLabel("0");
			holdDie[i] = new JButton("Lock");
			holdDie[i].setEnabled(false);
		}
		
		getContentPane().setLayout(new GridBagLayout());

		setSize(new Dimension(520, 400));

		GridBagConstraints c = new GridBagConstraints();
		
        c.insets = new Insets(5, 5, 5, 5);
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        getContentPane().add(holdDie[0], c);
        
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        getContentPane().add(holdDie[1], c);
        
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        getContentPane().add(holdDie[2], c);
        
        c.gridx = 3;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        getContentPane().add(holdDie[3], c);
        
        c.gridx = 4;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        getContentPane().add(holdDie[4], c);
        
        c.gridx = 5;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        getContentPane().add(rollNum, c);
        
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(dieValue[0], c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(dieValue[1], c);

		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(dieValue[2], c);
		
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(dieValue[3], c);
		
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(dieValue[4], c);
		
		c.gridx = 5;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		getContentPane().add(rollDice, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(score, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(section1, c);
		
		setScoreStateFalse();
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(aces, c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(twos, c);
		
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(threes, c);
		
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(fours, c);
		
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(fives, c);
		
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(sixes, c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(section2, c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(threeKind, c);
		
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(fourKind, c);
		
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(fullHouse, c);
		
		c.gridx = 1;
		c.gridy = 7;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(smStraight, c);
		
		c.gridx = 1;
		c.gridy = 8;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(lgStraight, c);
		
		c.gridx = 1;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(yahtzee, c);
		
		c.gridx = 1;
		c.gridy = 10;
		c.gridwidth = 1;
		c.gridheight = 1;
		getContentPane().add(chance, c);
		
		c.gridx = 2;
		c.gridy = 3;
		getContentPane().add(playerScore, c);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void setDice(Die[] newValues){
		for(int i = 0; i < newValues.length; i++){
			dieValue[i].setText(Integer.toString(newValues[i].getValue()));
		}
	}
	public void setRollNum(int newRollNum){
		if(newRollNum != -1)
			rollNum.setText("Roll#: " + Integer.toString(newRollNum));
		else{
			rollNum.setText("No Rolls Left");
			for(int i = 0; i < 5; i++)
				holdDie[i].setEnabled(false);
		}
	}
	
	public void setScoreStateFalse(){
		aces.setEnabled(false);
		twos.setEnabled(false);
		threes.setEnabled(false);
		fours.setEnabled(false);
		fives.setEnabled(false);
		sixes.setEnabled(false);
		threeKind.setEnabled(false);
		fourKind.setEnabled(false);
		fullHouse.setEnabled(false);
		smStraight.setEnabled(false);
		lgStraight.setEnabled(false);
		yahtzee.setEnabled(false);
		chance.setEnabled(false);
	}
	
	public void setScoreState(boolean[] newState){
		aces.setEnabled(newState[0]);
		twos.setEnabled(newState[1]);
		threes.setEnabled(newState[2]);
		fours.setEnabled(newState[3]);
		fives.setEnabled(newState[4]);
		sixes.setEnabled(newState[5]);
		threeKind.setEnabled(newState[6]);
		fourKind.setEnabled(newState[7]);
		fullHouse.setEnabled(newState[8]);
		smStraight.setEnabled(newState[9]);
		lgStraight.setEnabled(newState[10]);
		yahtzee.setEnabled(newState[11]);
		chance.setEnabled(newState[12]);
	}
	
	public JButton getAces(){ return aces; }
	public JButton getTwos(){ return twos; }
	public JButton getThrees(){ return threes; }
	public JButton getFours(){ return fours; }
	public JButton getFives(){ return fives; }
	public JButton getSixes(){ return sixes; }
	public JButton getThreeKind(){ return threeKind; }
	public JButton getFourKind(){ return fourKind; }
	public JButton getFullHouse(){ return fullHouse; }
	public JButton getSmStraight(){ return smStraight; }
	public JButton getLgStraight(){ return lgStraight; }
	public JButton getYahtzee(){ return yahtzee; }
	public JButton getChance(){ return chance; }
	public JButton[] getLocks() { return holdDie; }
	public JButton getRoller(){ return rollDice; }
	
	public void  setScore(int newScore){ 
		playerScore.setText("Your Score: " + Integer.toString(newScore));
	}
}
