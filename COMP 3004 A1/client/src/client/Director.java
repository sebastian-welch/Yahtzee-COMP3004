package client;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Director implements Runnable{
	private Socket socket;
	
	public Director(Socket s){
		socket = s;
	}
	
	public void run(){
		try{
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			Scanner in = new Scanner(socket.getInputStream());
			GameLogic game = new GameLogic(out);
			
			while(true){
				out.writeObject(game.getGameStatus());
				out.flush();
				
				if(in.hasNext()){
					Thread.sleep(10);
					game.setScoreStatus(game.deserializeScoreLock(in.nextLine()));
				}
			}
		}catch(Exception e){
			System.out.println("Error:");
			e.printStackTrace();
		}
	}
}
