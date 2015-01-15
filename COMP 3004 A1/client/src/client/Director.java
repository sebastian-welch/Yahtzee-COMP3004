package client;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;

public class Director implements Runnable{
	private Socket socket;
	
	public Director(Socket s){
		socket = s;
	}
	
	public void run(){
		try{
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			Scanner in = new Scanner(socket.getInputStream());
			GameLogic game = new GameLogic(out);
			
			while(true){
				/*System.out.println(game.getRoundStatus());
				if(game.getRoundStatus() == true && game.getScoreSent() == false){
					out.println(game.getScoreStatus());
					out.flush();
					game.setScoreSent(true);
				}
				System.out.println("Test");*/
				if(in.hasNextLine() == true)
					game.setScoreStatus(game.deserializeScoreLock(in.nextLine()));
			}
		}catch(Exception e){
			System.out.println("Error:");
			e.printStackTrace();
		}
	}
}
