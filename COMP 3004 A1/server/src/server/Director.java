
package server;

import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class Director implements Runnable{
	
	private Socket socket;
	
	public Director(Socket s){
		socket = s;
	}
	
	public void run(){
		try{
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			while(true){
				String scoreStatus = in.nextLine();
				out.println(scoreStatus);
				out.flush();
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
