package producer.consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerPattern {
	public static void main(String[] args) {
		
		BlockingQueue sharedQueue = new LinkedBlockingQueue();
		Thread prodThread=new Thread(new Producer(sharedQueue));
		Thread consuThread=new Thread(new Consumer(sharedQueue),"consumer 1");
		Thread consu1Thread=new Thread(new Consumer(sharedQueue),"consumer 2");
		prodThread.start();
		consuThread.start();
		consu1Thread.start();
	}
}
