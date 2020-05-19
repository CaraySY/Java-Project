package com.wsy.transaction;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wsy.common.ConnectionUtils;

/**
 * 	Transaction(RabbitMQ message acknowledge)---> transaction + confirm <br>
 * 	 two method: AMQP+Confirm
 * 	
 * 
 * @author Administrator
 *
 */
public class TransactionProducer {

	private static final String QUEUE_NAME="test_queue_tx";
	
	public static void main(String[] args) {
		
		try {
			producer();
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	public static void producer() throws IOException, TimeoutException {
		
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		// declare queue
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String msg="hello transaction.";
		try {
			// open RabbtiMQ Transaction
			channel.txSelect();
			// publish message
			channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
			//int i=1/0;
			channel.txCommit(); // commit
		} catch (Exception e) {
			// transaction Roll_back
			channel.txRollback();
			System.out.println("message fail to send.");
		}
		channel.close();
		connection.close();
	}
}
