import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
	private Socket socket;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String str = (String) dis.readUTF();
			System.out.println("Client: " + str);
			int delay = 5000;
			Thread.sleep(delay);
			DataOutputStream data = new DataOutputStream(socket.getOutputStream());
			data.writeUTF("I AM ALIVE");

		} catch (Exception e) {
			e.getMessage();
		}
	}

}
