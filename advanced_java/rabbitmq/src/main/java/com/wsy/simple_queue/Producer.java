package com.wsy.simple_queue;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wsy.common.ConnectionUtils;

/**
 * 	Simple message queue is one 2 one model but it 
 * 	isn't comfortable many 2 many model.
 * @author Administrator
 *
 */
public class Producer {

	private static final String QUEUE_NAME="simple_message_queue";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		// get a connection
		Connection connection = ConnectionUtils.getConnection();
		// get a channel from specified connection
		Channel channel = connection.createChannel();
		// declare queue
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		// message content
		String msg="hello , this is a simple msg$what are you doing ?";
		// publish to RabbitMQ
		channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
		System.out.println("send "+msg+" successful.");
		channel.close();
		connection.close();
	}
}
