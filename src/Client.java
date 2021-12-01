
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author hasan
 */
public class Client {
	public static void main(String[] args) {
		// if (args.length < 1){
		// return;
		// }
		//
		// int portNumber = Integer.parseInt(args[0]);

		try {
			Socket socket = new Socket("localhost", 4999);
			int waitCount = 0;
			int delay = 1000;
			// send message to Server
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF("Are you ALIVE?");
			do {
				Thread.sleep(1000);
				waitCount++;
				System.out.println("Client : Waiting for response from Server " + waitCount + " seconds");

				delay += 1000;
			} while (delay <= 5000);

			// receive message from Server
			DataInputStream data = new DataInputStream(socket.getInputStream());
			String message = data.readUTF();
			System.out.println("Server: " + message);
			System.out.println("Client: Response Received\nWait Count Seconds " + waitCount);

			// end client
			Scanner scan = new Scanner(System.in);
			String endMsg;
			do {
				System.out.println("To terminate Client , Enter 'End'");
				endMsg = scan.nextLine();
			} while (!endMsg.toLowerCase().equals("end"));
			System.out.println("Client Terminated");
			socket.close();
		} catch (Exception e) {
			System.out.println("Client exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
