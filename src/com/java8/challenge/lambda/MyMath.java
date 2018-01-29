package com.java8.challenge.lambda;

import java.util.stream.IntStream;

public class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	PerformOperation isOdd = x -> {
		return (x % 2 == 0) ? Boolean.FALSE : Boolean.TRUE;
	};

	PerformOperation isPrime = x -> {
		return IntStream.rangeClosed(2, x / 2).peek(System.out::println).noneMatch(t -> x % t == 0);
	};

	PerformOperation isPalindrome = x -> {
		String y = String.valueOf(x);
		String z = new StringBuilder(y).reverse().toString();
		return (y.equals(z)) ? Boolean.TRUE : Boolean.FALSE;
	};

}
