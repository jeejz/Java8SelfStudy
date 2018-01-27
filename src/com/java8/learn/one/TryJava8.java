package com.java8.learn.one;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class TryJava8 {

	public static void main(String[] args) {
		List<String> s = new Random().ints(1, 10000).limit(100000).mapToObj(String::valueOf)
				.collect(Collectors.toList());
		// List<String> num = Stream.iterate(1, i -> i +
		// 1).limit(100000).collect(Collectors.toList());

		/**
		 * Group by 
		 */
		Map<Object, Long> myMap = s.stream().collect(Collectors.groupingBy(z -> z, Collectors.counting()));

		/**
		 * Sorting on a group by
		 */
		Map<Object, Long> finalMap = new LinkedHashMap<>();
		myMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

	}

}
