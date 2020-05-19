package com.wsy.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 	how to create a stream
 * @author Administrator
 *
 */
public class CreateStream {

	public static void main(String[] args) {
		
		Stream<String> stream = createStreamFromCollection();
		stream.forEach(System.out::println);
		createStreamFromValues().forEach(System.out::println);
		createStreamFromArrays().forEach(System.out::println);
		createStreamFromFile();
	}
	
	/**
	 * 	stream has a serial sequence from list
	 * @return
	 */
	public static Stream<String> createStreamFromCollection(){
		
		System.out.println("==========stream has a serial sequence from list==============");
		List<String> list = Arrays.asList("hello","alex","syw","world","stream");
		return list.stream();
	}
	
	// use static method from stream
	public static Stream<String> createStreamFromValues(){
		
		System.out.println("==========use static method from stream==============");
		return Stream.of("hello","alex","syw","world","stream");
	}
	
	// use Arrays.stream()
	public static Stream<String> createStreamFromArrays(){
		
		System.out.println("==========use Arrays.stream()==============");
		return Arrays.stream(new String[]{"hello","alex","syw","world","stream"});
	}
	
	// create stream from file
	public static Stream<String> createStreamFromFile(){
		
		System.out.println("==========create stream from file==============");
		Path path=Paths.get("G:\\advanced_java\\Java8API\\src\\main\\java\\com\\wsy\\stream\\CreateStream.java");
		try(Stream<String> stream=Files.lines(path)){
			stream.forEach(System.out::println);
			return stream;
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
}
