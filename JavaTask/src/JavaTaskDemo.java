import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JavaTaskDemo {

	public static void main(String[] args) {

		//way1
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println("Hello world!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		t.run();

		//way2
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("Hello world!");

			}
		}, 10000, 1000);

		
		//way3
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		ses.schedule(new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello Cisco!");

			}
		}, 10000, TimeUnit.MILLISECONDS);
	}
}
