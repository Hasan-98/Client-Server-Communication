
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author hasan
 */
public class Client {
	public static void main(String[] args) {



		ClientThread t = new ClientThread();

		try {
			Socket socket = new Socket("localhost", 4999);

			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF("Are you ALIVE?");

			int waitCount = 0;
			// send message to Server

			t.start();
			waitCount++;

			// end client
			Scanner scan = new Scanner(System.in);
			String endMsg;

			// receive message from Server
			DataInputStream data = new DataInputStream(socket.getInputStream());
			String message = data.readUTF();
			t.flag = false;
			System.out.println("Server: " + message);
			System.out.println("Client: Response Received\nWait Count Seconds " + waitCount);

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
