import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class ClientThread extends Thread {
	CountDownLatch countDownLatch = new CountDownLatch(2);
	boolean flag = true;
	int count = 1;

	@Override
	public void run() {

		while (flag) {
			try {
				System.out.println("Client : Waiting for response from Server " + count);
				count++;
				countDownLatch.await(1000, TimeUnit.MILLISECONDS);
			//	Thread.sleep(1000);
			}

			catch (Exception ex) {
				System.out.println("Exception has" + " been caught" + ex);
			}

		}
	}
}