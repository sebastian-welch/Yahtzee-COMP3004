package server;

import java.io.IOException;

import config.Config;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	public static void main(String[] args) throws IOException{
		try{
			ServerSocket server = new ServerSocket(Config.portID);
			Scorecard scorecard = new Scorecard();
			
			System.out.println("Waiting for a client to connect.");
			int i = 0;
			Socket s = new Socket();
			
			while(i < 2){
				s = server.accept();	
				
				System.out.println("Client connected from: " + 
						s.getLocalAddress().getHostName());
				i++;
				
				Director d = new Director(s, scorecard);
				Thread t = new Thread(d);
				t.start();
			}
			
		}catch (Exception e){
			System.out.println("Error: ");
			e.printStackTrace();
		}
	}
}
