package client;

import java.io.Serializable;

public class Request implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7923661429084687689L;
	private boolean[] scoreState = new boolean[13];
	
	public boolean[] getScoreState(){ return scoreState; }
	public void setScoreState(boolean[] newScoreState){ scoreState = newScoreState; }
}
