package com.wsy.work_queue;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.wsy.common.ConnectionUtils;

public class Consumer {

	// define work queue name
	private static final String QUEUE_NAME="test_work_queue";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		consume();
	}
	
	public static void consume() throws IOException, TimeoutException {
		
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		// define a consumer
		DefaultConsumer consumer=new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				
				String msg=new String(body);
				Optional.of("C1 received msg:"+msg).ifPresent(System.out::println);
				try {
					Thread.sleep(2_000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					System.out.println("C1 done.");
				}
			}
		};
		// listen queue
		channel.basicConsume(QUEUE_NAME, consumer);
	}
}
