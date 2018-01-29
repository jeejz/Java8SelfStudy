package com.java8.learn.one;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class TryJava8 {

	public static void main(String[] args) {

		List<String> a = new ArrayList<String>();
		a.add("8");
		a.add("899");
		a.add("7");
		a.add("3");
		a.add("89");
		a.add("29");
		a.add("71");
		a.add("9");

		IntFunction<String> intf = ss -> {
			System.out.println(ss);
			return String.valueOf(ss);
		};
		List<String> s = new Random().ints(1, 10000).limit(100000).mapToObj(intf).collect(Collectors.toList());
		//List<String> num = Stream.iterate(1, i -> i + 1).limit(100000).collect(Collectors.toList());

		Map<Object,Long> myMap = s.stream().collect(Collectors.groupingBy(z->z,Collectors.counting()));
		
		Map<Object, Long> finalMap = new LinkedHashMap<>();
		myMap.entrySet().stream()
			.sorted(Map.Entry.comparingByValue().reversed())
			.forEachOrdered(e->finalMap.put(e.getKey(), e.getValue()))
			;
		
		
		ToIntFunction<String> toInt = (i) -> {
			return new Integer(i);
		};

		BiFunction<String, String, Integer> comp = (q, w) -> {

			if (toInt.applyAsInt(q + w) > toInt.applyAsInt(w + q)) {
				return -1;
			}
			return 1;
		};

		Comparator<String> big = (f, qq) -> {
			return comp.apply(f, qq);
		};

		MyComparer m = new MyComparer();
		for (int i = 0; i < a.size(); i++) {
			// System.out.println(m.compare(a.get(i), a.get(i)));
		}

		long startTime = System.nanoTime();
		System.out.println(s.size());
		String out = s.stream().sorted(big).collect(Collectors.joining(" | "));
		// System.out.println(out);
		System.out.println("Time taken : " + (System.nanoTime() - startTime));
		System.out.println(s.size());
		String out1 = s.parallelStream().sorted(big).collect(Collectors.joining(" | "));
		// System.out.println(out1);
		System.out.println("Time taken : " + (System.nanoTime() - startTime));

	}

}

class MyComparer implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		System.out.println("Comparing a :" + o1 + " and b : " + o2);
		if (o1.length() > o2.length()) {
			return 1;
		} else if (o1.length() < o2.length()) {
			return -1;
		} else {
			return 0;
		}

	}

}