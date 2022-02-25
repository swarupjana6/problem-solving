/** 
 * 
 */
package com.practice.solid.singleresponsibility.good;

/**
 * @author swjana
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Book book = new Book();
		TextFormatter formatter = new TextFormatter();
		ConsolePrint consolePrint = new ConsolePrint();
		String formattedText = formatter.format(book.getText(), book.getAuthor());
		
		consolePrint.print(formattedText);
		
	}

}
