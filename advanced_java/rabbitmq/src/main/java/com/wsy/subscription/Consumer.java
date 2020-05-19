package com.wsy.subscription;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.wsy.common.ConnectionUtils;

public class Consumer {

	private static final String QUEUE_NAME="email_queue_fanout";
	private static final String EXCHANGE_NAME="test_exchanage_fanout";
	
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
		// bind to exchange
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
		// limit one message
		channel.basicQos(1);
		// read message from queue
		DefaultConsumer consumer=new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				String msg=new String(body);
				System.out.println("received msg]->"+msg);
			}
		};
		// consume 
		channel.basicConsume(QUEUE_NAME, consumer);
	}
}
