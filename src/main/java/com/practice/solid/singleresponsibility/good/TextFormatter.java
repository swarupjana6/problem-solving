package com.practice.solid.singleresponsibility.good;

public class TextFormatter {

	private String formattedText;
	
	public String format(String... texts) {
		
		//write logic of formatting the text
		for (String text : texts) {
			formattedText += text;
		}
		return formattedText;
	}
}
