package com.java8.challenge.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;

		System.out.println("----");
		while (T-- > 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			switch (st.nextToken()) {
			case "1":
				if (MyMath.checker(ob.isOdd, Integer.valueOf(st.nextToken()))) {
					System.out.println("ODD");
				} else {
					System.out.println("EVEN");
				}
				break;
			case "2":
				if (MyMath.checker(ob.isPrime, Integer.valueOf(st.nextToken()))) {
					System.out.println("PRIME");
				} else {
					System.out.println("COMPOSITE");
				}
				break;
			case "3":
				if (MyMath.checker(ob.isPalindrome, Integer.valueOf(st.nextToken()))) {
					System.out.println("PALINDROME");
				} else {
					System.out.println("NOT PALINDROME");
				}
				break;
			default:
				System.out.println("Unexpected choice");
			}
		}
	}
}
