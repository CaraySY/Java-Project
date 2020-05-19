package com.wsy.simple_queue;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.rabbitmq.client.ShutdownSignalException;
import com.wsy.common.ConnectionUtils;

/**
 * 	 consumer get message from RabbitMQ
 * @author Administrator
 *
 */
public class Consumer {

	private static final String QUEUE_NAME="simple_message_queue";
	
	public static void main(String[] args) throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException {
		
		newAPI();
	}
	
	/**
	 * 	the pass method to operate RabbitMQ
	 * @throws IOException
	 * @throws TimeoutException
	 * @throws ShutdownSignalException
	 * @throws ConsumerCancelledException
	 * @throws InterruptedException
	 */
	@SuppressWarnings("all")
	public static void oidAPI() throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException {
		
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		// use deprecated API to receive 
		QueueingConsumer consumer=new QueueingConsumer(channel);
		// listen queue
		channel.basicConsume(QUEUE_NAME, true,consumer);
		while(true) {
			Delivery delivery=consumer.nextDelivery();
			String msg=new String(delivery.getBody());
			System.out.println("[received]:"+msg);
		}
	}
	
	/**
	 * 	use new API to listen queue messages
	 * @throws IOException
	 * @throws TimeoutException
	 */
	public static void newAPI() throws IOException, TimeoutException {
		
		// get a connection
		Connection connection = ConnectionUtils.getConnection();
		// get channel from specified connection
		Channel channel = connection.createChannel();
		// declare queue
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		// define a consumer
		DefaultConsumer consumer=new DefaultConsumer(channel) {

			// handle received message
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				
				System.out.println("use new api received :"+new String(body));
			}
		};
		// listen queue
		channel.basicConsume(QUEUE_NAME, consumer);
	}
}
