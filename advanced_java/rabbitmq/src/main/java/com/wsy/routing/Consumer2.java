package com.wsy.routing;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.wsy.common.ConnectionUtils;

public class Consumer2 {

	private static final String EXCHANGE_NAME="test_exchanage_routing";
	private static final String QUEUE_NAME="test_queue_routing";
	
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
		channel.basicQos(1);
		String routingKey="error";
		String routingKey2="info";
		String routingKey3="warning";
		// bind queue
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, routingKey);
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, routingKey2);
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, routingKey3);
		DefaultConsumer consumer=new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				String msg=new String(body);
				Optional.of("[received]->"+msg).ifPresent(System.out::println);
				// response
				channel.basicAck(envelope.getDeliveryTag(), false);
			}
		};
		// consume 
		channel.basicConsume(QUEUE_NAME, false, consumer);
	}
}
