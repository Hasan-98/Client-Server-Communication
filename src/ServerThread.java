import java.io.*;
import java.net.*;
import java.util.concurrent.CountDownLatch;

public class ServerThread extends Thread {
	private Socket socket;
	private CountDownLatch latch;

	public ServerThread(Socket socket, CountDownLatch countDownLatch) {

		this.socket = socket;
		latch = countDownLatch;
	}

	public void run() {
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String str = (String) dis.readUTF();
			System.out.println("Client: " + str);
			int delay = 1000;
			Thread.sleep(delay);
			DataOutputStream data = new DataOutputStream(socket.getOutputStream());
			data.writeUTF("I AM ALIVE");

			latch.countDown();

		} catch (Exception e) {
			e.getMessage();
		}
	}

}
