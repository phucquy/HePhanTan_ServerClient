package com.hust.soict.quy.client_server;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
	

	public static void main(String[] args) {
		
		try 
		{	
			System.out.println("Client started");
			Socket soc = new Socket("localhost",3000);
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			System.out.println("Enter your numbers");
			System.out.println(in.readLine());
			Scanner scanner = new Scanner(System.in);
			
			boolean check = true;
			while(check) {
				String mess = scanner.nextLine();
				if(mess == "") {
					check = false;
				}else {
					out.println(mess); // send data to server
				}
				System.out.println(in.readLine()); // display mess from server
				// send to server
			}
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
