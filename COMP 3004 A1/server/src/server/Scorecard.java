package server;

public class Scorecard {
	private boolean[] scoreState = new boolean[13];
	private boolean[] roundState;
	
	public Scorecard(int numPlayers){
		roundState = new boolean[numPlayers];
		
		for(int i = 0; i < roundState.length; i++)
			roundState[i] = false;
		for(int i = 0; i < scoreState.length; i++)
			scoreState[i] = true;
	}
	
	public String serializeScoreLock(boolean[] scoreStatus){
		String lock = "";
		
		for(int i = 0; i < scoreStatus.length; i++){
			if (scoreStatus[i])
				lock += "true,";
			else
				lock += "false,";
		}
		lock = lock.substring(0, lock.length() - 1);
		return lock;
	}
	
	//Compares the current status to the new statuses, never change from false to true
	public boolean[] deserializeScoreLock(String scoreStatus){
		boolean[] newScoreStatus = new boolean[13];
		String[] splitScoreStatus = new String[14];
		String[] splitCurrentStatus = new String[14];
		String currentScoreState =  serializeScoreLock(scoreState);
		
		splitScoreStatus = scoreStatus.split(",");
		splitCurrentStatus = currentScoreState.split(",");
		
		for(int i = 0; i < 13; i++){
			if(splitScoreStatus[i].equals("true") && splitCurrentStatus[i].equals("true"))
				newScoreStatus[i] = true;
			else
				newScoreStatus[i] = false;
		}
		scoreState = newScoreStatus;
		return newScoreStatus;
	}
	
	public String getScoreStatus() { return serializeScoreLock(scoreState); }
}
