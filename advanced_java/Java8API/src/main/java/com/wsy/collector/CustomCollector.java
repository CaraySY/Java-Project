package com.wsy.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollector<T> implements Collector<T,List<T>,List<T>> {

	@Override
	public Supplier<List<T>> supplier() {
		
		return ArrayList::new;
	}

	@Override
	public BiConsumer<List<T>, T> accumulator() {

		return List::add;
	}

	@Override
	public BinaryOperator<List<T>> combiner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Function<List<T>, List<T>> finisher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Characteristics> characteristics() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
