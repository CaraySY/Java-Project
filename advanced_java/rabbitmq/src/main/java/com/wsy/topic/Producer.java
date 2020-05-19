package com.wsy.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wsy.common.ConnectionUtils;

/**
 * 	Topic Exchange <br>
 * 		routing key and pattern match	<br>
 *  # match one or more <br>
 *  * match one <br>
 *  For example: <br>
 *  	Goods: add delete update query <br>
 * 
 * @author Administrator
 *
 */
public class Producer {

	private static final String EXCHANGE_NAME="test_exchange_topic";
	
	public static void main(String[] args) {
		
		try {
			produce();
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	public static void produce() throws IOException, TimeoutException {

		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		// declare exchange
		channel.exchangeDeclare(EXCHANGE_NAME, "topic"); // topic mode
		String msg="goods";
		channel.basicPublish(EXCHANGE_NAME, "goods.add", null, msg.getBytes());
		System.out.println("send]->"+msg);
		channel.close();
		connection.close();
	}
}
