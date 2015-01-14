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
			GameLogic game = new GameLogic();
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			Scanner in = new Scanner(socket.getInputStream());
			
			while(true){
				out.println(game.serializeScoreLock(game.getScoreStatus()));
				out.flush();
			}
		}catch(Exception e){
			System.out.println("Error:");
			e.printStackTrace();
		}
	}
}
