import java.net.Socket;

class ClientThread extends Thread {

	boolean flag = true;
	int count = 1;

	@Override
	public void run() {

		while (flag) {
			try {
				System.out.println("Client : Waiting for response from Server " + count);
				count++;
				Thread.sleep(1000);
			}

			catch (Exception ex) {
				System.out.println("Exception has" + " been caught" + ex);
			}

		}
	}
}