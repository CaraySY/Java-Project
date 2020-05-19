package com.wsy.buffer;

import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * 	Buffer base on Array to create
 * @author Administrator
 *  
 *	put---> put data to buffer
 *	get---> get data from buffer
 *	
 *	capacity: max buffer capacity
 *	limit: buffer can contain data
 *	position: position of operation
 *	position <= limit <= capacity
 *	 allocate : distribute data to JVM Heap
 *	 allocateDirect : distribute data to Physical Memory
 */
public class TestBuffer {

	@Test
	public void test1() {
		
		// allocate a buffer
		System.out.println("Write Mode...");
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		buffer.flip();
		System.out.println("Read Mode...");
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
	}
	
	@Test
	public void test2() {
		
		// allocate a buffer
		System.out.println("allocate...");
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		String s="Hello World!!!";
		buffer.put(s.getBytes());
		// put data to buffer
		System.out.println("Write Mode...");
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		// switch to read mode
		buffer.flip();
		byte[] b=new byte[buffer.limit()];
		buffer.get(b);
		System.out.println("Read Mode...");
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		System.out.println(new String(b));
		System.out.println("rewind...read data repeatly");
		buffer.rewind();
		System.out.println("Read Mode...");
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		System.out.println(new String(b));
	}
}
