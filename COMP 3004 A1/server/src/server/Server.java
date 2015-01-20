package server;

import java.io.IOException;

import config.Config;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException{
		try{
			ServerSocket server = new ServerSocket(Config.portID);
			serverGUI gui = new serverGUI();
			int numPlayers = 0;
			int i = 0;
			
			while(gui.getStartGame() == false){
				Thread.sleep(10);
			}
			
			numPlayers = gui.getNumPlayers();
			gui.dispose();
			
			System.out.println("Waiting for a client to connect.");
			Scorecard scorecard = new Scorecard(numPlayers);
			Socket s = new Socket();
			
			while(i < numPlayers){
				s = server.accept();	
				
				System.out.println("Client connected from: " + 
						s.getLocalAddress().getHostName());
				i++;
				
				Director d = new Director(i, s, scorecard);
				Thread t = new Thread(d);
				t.start();
			}
			
			server.close();
			
		}catch (Exception e){
			System.out.println("Error: ");
			e.printStackTrace();
		}
	}
}
