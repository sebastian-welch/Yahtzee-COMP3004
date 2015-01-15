package server;

public class Scorecard {
	private boolean[] scoreState = new boolean[13];
	
	public Scorecard(){
		for(int i = 0; i < scoreState.length; i++)
			scoreState[i] = false;
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
	
	public boolean[] deserializeScoreLock(String scoreStatus){
		boolean[] newScoreStatus = new boolean[13];
		String[] splitScoreStatus = new String[13];
		splitScoreStatus = scoreStatus.split(",");
		
		for(int i = 0; i < splitScoreStatus.length; i++){
			System.out.println(splitScoreStatus[0]);
			if(splitScoreStatus[i].equals("true"))
				newScoreStatus[i] = true;
			else
				newScoreStatus[i] = false;
		}
		scoreState = newScoreStatus;
		return newScoreStatus;
	}
}
