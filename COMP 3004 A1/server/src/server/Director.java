
package server;

import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Director implements Runnable{
	private int playerNum;
	private Socket socket;
	private Scorecard scorecard;
	
	public Director(int player, Socket s, Scorecard score){
		playerNum = player;
		socket = s;
		scorecard = score;
	}
	
	public void run(){
		try{
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			while(true){
				String scoreStatus;
				if(in.hasNext()){
					scoreStatus = in.nextLine();
					scorecard.deserializeScoreLock(scoreStatus);
					
					scoreStatus = scorecard.getScoreStatus();
					out.println(scoreStatus);
					out.flush();
					}
			}
			
		}catch(IOException e){
			System.out.println("Error: ");
			e.printStackTrace();
			System.out.println("Connection dropped, closing socket connection.");
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}			
		}
	}
}
