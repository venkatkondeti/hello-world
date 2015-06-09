package producer.consumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private final BlockingQueue sharedQueue;
	public Consumer(final BlockingQueue sharedQueue){
		this.sharedQueue=sharedQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(Thread.currentThread().getName()+" consumed : "+sharedQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
