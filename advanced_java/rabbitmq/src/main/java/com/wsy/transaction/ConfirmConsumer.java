package com.wsy.transaction;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.wsy.common.ConnectionUtils;

/**
 * 	Transaction(RabbitMQ message acknowledge)---> transaction + confirm <br>
 * 	 two method: AMQP+Confirm
 * 	
 * 
 * @author Administrator
 *
 */
public class ConfirmConsumer {

	private static final String QUEUE_NAME="test_queue_confirm";
	
	public static void main(String[] args) {
		
		try {
			consume();
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	public static void consume() throws IOException, TimeoutException {
		
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		// declare queue
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		DefaultConsumer consumer=new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				System.out.println("received.]->"+new String(body));
				channel.basicAck(envelope.getDeliveryTag(), false);
				try {
					Thread.sleep(1_000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					System.out.println("finished.");
				}
			}
		};
		// manual response mode
		channel.basicConsume(QUEUE_NAME, false, consumer);
	}
}
