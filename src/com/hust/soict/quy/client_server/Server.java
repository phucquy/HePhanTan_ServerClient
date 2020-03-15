package com.hust.soict.quy.client_server;


import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.Arrays;

import com.hust.soict.quy.helper.BubbleSort;
import com.hust.soict.quy.helper.InsertionSort;
import com.hust.soict.quy.helper.SelectionSort;

public class Server {
	public static void main(String[] args) throws IOException {
		
		System.out.println("The Sorter Server is running!");
		int clientNumber = 0;
		try (ServerSocket listener = new ServerSocket(3000)) 
		{
			while (true) 
			{
			new Sorter(listener.accept(), clientNumber++).start();
			}
		}
	}
	private static class Sorter extends Thread {
		private Socket socket;
		private int clientNumber;
		
		public Sorter(Socket socket, int clientNumber) 
		{
			this.socket = socket;
			this.clientNumber = clientNumber;
			System.out.println("New client #" + clientNumber + " connected at " + socket);
		}
		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
				
				// Send a welcome message to the client.
				out.println("Hello, you are client #" + clientNumber);
				
				
				// Get messages from the client, line by line;
				// Each line has several numbers separated by a space character
				while (true)
				{
					String input = in.readLine();
					if (input == null || input.isEmpty()) {
						break;
					}
					
					//Put it in a string array
					String[] nums = input.split(" ");
					
					//Convert this string array to an int array
					int[] intarr = new int[ nums.length ];
					
					int i = 0;
					for ( String textValue : nums ) {
						intarr[i] = Integer.parseInt( textValue );
						i++;
					}
					//Sort the numbers in this int array
					
					// Selection Sort 
//					new SelectionSort().sort(intarr);
					
					// Bubble Sort
//					new BubbleSort().sort(intarr);

					 
					// Insertion Sort
					new InsertionSort().sort(intarr);
					
					
					System.out.println("Sorting done");
					
					//Convert the int array to String
					String strArray[] = Arrays.stream(intarr).mapToObj(String::valueOf).toArray(String[]::new);
					//Send the result to Client
					out.println(Arrays.toString(strArray));
					
		
				}	
				
			} catch (Exception e) {
				System.out.println("Error handling client #" + clientNumber);
			} finally {
				try { 
					socket.close(); 
					} catch (IOException e) {}
				System.out.println("Connection with client # " +
				clientNumber + " closed");
			}
		}
	}
}
