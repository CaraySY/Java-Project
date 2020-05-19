package com.wsy.transaction;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.wsy.common.ConnectionUtils;

/**
 * 	Anonymous transaction
 * 
 * @author Administrator
 *
 */
public class AnonymousProducer {

	private static final String QUEUE_NAME = "test_queue_anonymous";

	public static void main(String[] args) {

		try {
			produce();
		} catch (IOException | TimeoutException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void produce() throws IOException, TimeoutException, InterruptedException {

		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		// declare queue
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		// open confirm mode
		channel.confirmSelect();
		// save unconfirmed message 
		final SortedSet<Long> confirmSet=Collections.synchronizedSortedSet(new TreeSet<Long>());
		// add listener to channel
		channel.addConfirmListener(new ConfirmListener() {
			
			// no another problems
			@Override
			public void handleAck(long deliveryTag, boolean multiple) throws IOException {

				if(multiple) {
					System.out.println("---handleAck----multiple---success");
					confirmSet.headSet((deliveryTag++)).clear();
				}else {
					System.out.println("---handleAck----multiple----failed");
					System.out.println(deliveryTag);
				}
			}
			
			@Override
			public void handleNack(long deliveryTag, boolean multiple) throws IOException {

				if(multiple) {
					System.out.println("---handleAck----multiple---success");
					confirmSet.headSet((deliveryTag++)).clear();
				}else {
					System.out.println("---handleAck----multiple----failed");
					System.out.println(deliveryTag);
				}
			}
		});
		String msg = "hello anonymous...";
		while(true) {
			// get publishing sequence no
			long seqNo=channel.getNextPublishSeqNo();
			// publish message
			channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
			// add to set
			confirmSet.add(seqNo);
		}
	}
}
