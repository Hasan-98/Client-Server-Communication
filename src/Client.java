
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

			// send message to Server
			DataOutputStream dout=new DataOutputStream(socket.getOutputStream());
			dout.writeUTF("Are you ALIVE?");

			System.out.println("Waiting for response from Server");
			// receive message from Server
			DataInputStream data = new DataInputStream(socket.getInputStream());
			String message = data.readUTF();
			System.out.println("Server: " + message);

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
