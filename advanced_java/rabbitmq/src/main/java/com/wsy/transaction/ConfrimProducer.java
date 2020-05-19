package com.wsy.transaction;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wsy.common.ConnectionUtils;

/**
 * 	Advantage:<strong>anonymous</strong> <br>
 *   pattern:<br>
 *   	1.common->one message waitForConfirms() <br>
 *   	2.batch-> a batch of messages. waitForConfirms() <br>
 *   	3.can run in anonymous mode. <br>
 * @author Administrator
 *
 */
public class ConfrimProducer {

	private static final String QUEUE_NAME="test_queue_confirm";
	
	public static void main(String[] args) {
		
		try {
			produce2();
		} catch (IOException | TimeoutException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	common pattern of confirmation
	 *  every time only can send one message to a message queue
	 * @throws IOException
	 * @throws TimeoutException
	 * @throws InterruptedException
	 */
	public static void produce() throws IOException, TimeoutException, InterruptedException {
		
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		// declare queue
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String msg="hello confirm";
		channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
		// judge
		if(!channel.waitForConfirms()) {
			System.out.println("message fail to send.");
		}else {
			System.out.println("message arrived successful.");
		}
		// close resources
		channel.close();
		connection.close();
	}
	
	/**
	 * 	batch pattern of confirmation
	 * @throws IOException
	 * @throws TimeoutException
	 * @throws InterruptedException
	 */
	public static void produce2() throws IOException, TimeoutException, InterruptedException {
		
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		// declare queue
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		// open confirming mode
		channel.confirmSelect();
		String msg="hello confirm]";
		// send a batch of messages
		IntStream.range(0, 10).forEach(i->{
			try {
				channel.basicPublish("", QUEUE_NAME, null,(msg+i).getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		// judge
		if(!channel.waitForConfirms()) {
			System.out.println("message fail to send.");
		}else {
			System.out.println("message arrived successful.");
		}
		// close resources
		channel.close();
		connection.close();
	}
	
	/**
	 * 	anonymous pattern of confirmation
	 * @throws IOException
	 * @throws TimeoutException
	 * @throws InterruptedException
	 */
	public static void produce3() throws IOException, TimeoutException, InterruptedException {
		
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		// declare queue
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		// open confirming mode
		channel.confirmSelect();
		String msg="hello confirm]";
		// send a batch of messages
		IntStream.range(0, 10).forEach(i->{
			try {
				channel.basicPublish("", QUEUE_NAME, null,(msg+i).getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		// judge
		if(!channel.waitForConfirms()) {
			System.out.println("message fail to send.");
		}else {
			System.out.println("message arrived successful.");
		}
		// close resources
		channel.close();
		connection.close();
	}
}
