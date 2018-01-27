package com.java8.learn.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LessonTwo {

	public static void main(String[] args) {
		
		List<String> myList = Arrays.asList(
			"one","two","trheee"
		);
		
		Stream s = myList.stream();
		String search = "two";
		String t;
		BiFunction<String, String, String> f = (inc,sea) -> 
			 (inc.equals(sea)?"true":"false");
		
		List<String> newList = new ArrayList<>();
		newList.add("test");
		//s.map((s)->(System.out::println))
		Predicate<String> p = c->c.equals("two");
		Consumer<String> c = (x) -> {System.out.println(x);};
		Predicate<String> d = (y) -> {
			throw new NullPointerException();
		};
		
			 myList.stream().filter(p.or(d)).forEach(newList::add);
			 newList.forEach(System.out::println);
		//s.peek(f).forEach(System.out::println);
		
	}
}
