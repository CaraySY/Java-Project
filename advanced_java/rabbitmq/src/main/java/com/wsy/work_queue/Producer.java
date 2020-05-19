package com.wsy.work_queue;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wsy.common.ConnectionUtils;

/**
 * 	Why is this work-queue appearing? <br>
 *  Simple queue is one 2 one model,usually producers product message easily <br>
 *  	at real program but consumer always combined with business. Consumer should  <br>
 *  	be handle it when they receive message.Because this way will spend more time <br>
 *  	to solve messages.Often backlog of many things in real program. <br>
 * @author Administrator
 *
 */
public class Producer {

	// define work queue name
	private static final String QUEUE_NAME="test_work_queue";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		produce();
	}
	
	public static void produce() throws IOException, TimeoutException {
		
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		// declare queue
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		IntStream.range(0,20).forEach(i->{
			String msg="hello world]->"+i;
			// publish messages to queue
			try {
				channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(1_00);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}
