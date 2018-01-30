package com.java8.challenge.lambda;

import java.util.stream.IntStream;

public class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	public PerformOperation isOdd(){
   PerformOperation isOdd = x -> {
		return (x % 2 != 0);
	};
    
    return isOdd;
}    

public PerformOperation isPrime(){
	 PerformOperation isPrime = x -> {
		return java.util.stream.IntStream.rangeClosed(2, x / 2).noneMatch(t -> x % t == 0);
	};
    return isPrime;
}
    public PerformOperation isPalindrome(){
	 PerformOperation isPalindrome = x -> {
		String y = String.valueOf(x);
		String z = new StringBuilder(y).reverse().toString();
		return (y.equals(z)) ;
	};
        return isPalindrome;
    }
}

}
