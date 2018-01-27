package com.java8.learn.two;

@FunctionalInterface
public interface BiFunction<T, Q, R> {
	T function(Q q, R r);

}
