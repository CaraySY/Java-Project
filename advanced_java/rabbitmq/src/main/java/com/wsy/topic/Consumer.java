package com.wsy.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.wsy.common.ConnectionUtils;

public class Consumer {

	private static final String EXCHANGE_NAME="test_exchange_topic";
	private static final String QUEUE_NAME="test_queue_topic";
	
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
		// bind queue
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "goods.add");
		// 
		DefaultConsumer consumer=new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				System.out.println("[1]received."+new String(body));
				try {
					Thread.sleep(1_000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					System.out.println("[1]finished.");
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			}
		};
		// set manual received mode
		channel.basicConsume(QUEUE_NAME, false, consumer);
	}
}
