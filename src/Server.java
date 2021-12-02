
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.net.*;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author hasan
 */
public class Server {
	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(10);
		int portNumber = 4999;

		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			System.out.println("Server is listening on port " + portNumber);
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Client Found");

				new ServerThread(socket, latch).start();
				latch.countDown();
				System.out.println("latch count: " + latch.getCount());
				// latch.await();
			}
		} catch (Exception e) {
			System.out.println("Server exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
