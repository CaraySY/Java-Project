package com.wsy.subscription;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wsy.common.ConnectionUtils;

/**
 * 	Subscription Model <br>
 *  <strong>key</strong>  <br>
 *  1.one producer to many consumers  <br>
 *  2.every consumer have oneself queue.  <br>
 *  3.producer product message to exchange.  <br>
 *  4.Every queue should be bound by exchange.  <br>
 *  5.producer->exchange->queue->consumer.  <br>
 *  **********************************
 *   important! received message and send message to queue
 *mode:
 *  > "":anonymous send
 *  > Fanout:not handle routing key
 *  > Direct(route mode):handle routing key
 * @author Administrator
 *
 */
public class Producer {

	private static final String EXCHANGE_NAME="test_exchanage_fanout";
	
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
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		String msg="hello ,this is first message to exchange";
		System.out.println(msg);
		// publish message to exchange but message discarded
		channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());
		channel.close();
		connection.close();
	}
}
