
package server;

import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Director implements Runnable{
	
	private Socket socket;
	private Scorecard scorecard;
	
	public Director(Socket s, Scorecard score){
		socket = s;
		scorecard = score;
	}
	
	public void run(){
		try{
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			while(true){
				if(in.hasNext()){
					String scoreStatus = in.nextLine();
					scorecard.deserializeScoreLock(scoreStatus);
					
					System.out.println(scoreStatus);
					
					out.println(scoreStatus);
					out.flush();
					}
			}
			
		}catch(Exception e){
			System.out.println("Error: ");
			e.printStackTrace();
			System.out.println("Connection dropped, closing socket connection.");
			/*try {
				socket[0].close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}*/
			
		}
	}
}
