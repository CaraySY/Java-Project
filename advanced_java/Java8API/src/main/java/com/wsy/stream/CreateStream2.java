package com.wsy.stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CreateStream2 {

	public static void main(String[] args) {
		
		//createStreamFromIterator().forEach(System.out::println);
		//createStreamFromGenerator().forEach(System.out::println);
		createStreamFromCustom().forEach(System.out::println);
		
	}
	
	// return an infinity sequence
	public static Stream<Integer> createStreamFromIterator(){
		
		Stream<Integer> stream = Stream.iterate(0,n->n+2).limit(10);
		return stream;
	}
	
	// return an custom stream
	public static Stream<Double> createStreamFromGenerator(){
		
		return Stream.generate(Math::random).limit(10);
	}
	public static Stream<Obj> createStreamFromCustom(){
		
		return Stream.generate(new ObjSupplier()).limit(10);
	}
	
	// return a new _obj instance
	static class ObjSupplier implements Supplier<Obj>{

		Random random=new Random(System.currentTimeMillis());
		
		@Override
		public Obj get() {
			
			int index=random.nextInt(100);
			return new Obj(index,"name->"+index);
		}
	}
	
	// define a class
	static class Obj{
		
		private Integer id;
		private String name;
		
		public Obj(Integer id, String name) {

			this.id = id;
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		
		@Override
		public String toString() {
			return "Obj [id=" + id + ", name=" + name + "]";
		}
	}
}
