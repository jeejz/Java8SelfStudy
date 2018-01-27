package com.java8.splQn.q1;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class BiggestNumberFromCombination {

	public static void main(String[] args) {

		/**
		 * Function To convert Integer To String.
		 */
		IntFunction<String> mapIntToString = String::valueOf; 
				
		/**
		 * Function to convert string to integer.
		 */
		ToIntFunction<String> stringToInt = Integer::valueOf;

		/**
		 * Create String list of 1Lac size using Random.
		 */
		List<String> dataList = new Random().ints(1, 10000).limit(100000)
				.mapToObj(mapIntToString)
				.peek(System.out::println)
				.collect(Collectors.toList());

		System.out.println("Data List Size : " + dataList.size());

		/**
		 * Comparator to compare the biggest combination
		 */
		BiFunction<String, String, Integer> bigNumberCombComp = (numS1, numS2) -> {
			if (stringToInt.applyAsInt(numS1 + numS2) > stringToInt.applyAsInt(numS2 + numS1)) {
				return -1;
			}
			return 1;
		};

		LocalTime startTime = LocalTime.now();

		String resultString = dataList.stream().sorted(bigNumberCombComp::apply).collect(Collectors.joining(","));
		System.out.println("Result String : " + resultString);
		LocalTime endTime = LocalTime.now();

		System.out.println("Time taken : " + Duration.between(startTime, endTime).getSeconds());

	}

}
