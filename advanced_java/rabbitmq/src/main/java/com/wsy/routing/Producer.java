package com.wsy.routing;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wsy.common.ConnectionUtils;

public class Producer {

	private static final String EXCHANGE_NAME="test_exchanage_routing";
	
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
		channel.exchangeDeclare(EXCHANGE_NAME, "direct"); // routing mode
		// edit message and send it.
		String msg="error direct.";
		String msg2="info direct.";
		String msg3="warning direct.";
		String routingKey="error";
		String routingKey2="info";
		String routingKey3="warning";
		channel.basicQos(1);
		channel.basicPublish(EXCHANGE_NAME, routingKey, null, msg.getBytes());
		channel.basicPublish(EXCHANGE_NAME, routingKey2, null, msg2.getBytes());
		channel.basicPublish(EXCHANGE_NAME, routingKey3, null, msg3.getBytes());
		System.out.println(msg);
		System.out.println(msg2);
		System.out.println(msg3);
		channel.close();
		connection.close();
	}
}
