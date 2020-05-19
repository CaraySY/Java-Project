package com.wsy.work_fair;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wsy.common.ConnectionUtils;

/**
 *  fair work model
 * @author Administrator
 *
 */
public class Producer {

	// define work queue name
	private static final String QUEUE_NAME="test_work_queue";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		produce();
	}
	
	public static void produce() throws IOException, TimeoutException {
		
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		// declare queue
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		// close auto response
		// every time to send one message until consumer received next message
		channel.basicQos(1);  
		IntStream.range(0,20).forEach(i->{
			String msg="hello world]->"+i;
			// publish messages to queue
			Optional.of(msg).ifPresent(System.out::println);
			try {
				channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(1_00);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}
