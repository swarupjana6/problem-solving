package com.practice.solid.singleresponsibility.good;

public class ConsolePrint implements Print<String> {

	@Override
	public void print(String content) {

		System.out.println(content);
	}

}
