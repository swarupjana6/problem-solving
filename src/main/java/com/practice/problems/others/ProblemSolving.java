package com.practice.problems.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProblemSolving {

	/**
	 * How can you reverse a string ?
	 * 
	 * Initiate The string which is to be reversed is declared. Get the length of
	 * the string. Start a loop and then swap the position of the array elements.
	 * Keep the exchanged positions. Print the reversed string.
	 * 
	 * @param word
	 * @return
	 */
	public static String reverseString(String word) {

		StringBuilder finalWord = new StringBuilder();

		for (int i = word.length() - 1; i >= 0; i--) {
			finalWord.append(word.charAt(i));
		}

		return finalWord.toString();
	}

	/**
	 * palindrome string.
	 * 
	 * @param word
	 * @return
	 */
	public static boolean palindromeString(String word) {

		String reverseWord = reverseString(word);
		return word.equalsIgnoreCase(reverseWord);
	}

	/**
	 * How to get the matching characters in a string
	 * 
	 * Hash Map data structure is taken which works with the key-value pair. Loop
	 * the strings, character by character, and verify if that character of the
	 * string exists in the hash map or not. If the result is true, the counter for
	 * the character in the hash map is increased or else then put a count as 1.
	 * Once the loop ends, then the Hash map is traversed and print the characters
	 * with more than 1 count.
	 * 
	 * @param word
	 * @return
	 */
	public static String matchingCharacterCount(String word, Character character) {

		Map<Character, Long> characterCount = word.chars().mapToObj(c -> (char)c)
															.collect(Collectors.groupingBy(
																	Function.identity(),
																	HashMap::new,
																	Collectors.counting()));
		characterCount.forEach((k,v) -> {if(v > 1l) System.out.println(k + " : "+ v);});
		return characterCount.toString(); 
	}
	
	/**
	 * How to get the non-matching characters in a string
	 * 
	 * Hash Map data structure is taken which works with the key-value pair. Loop
	 * the string, character by character, and verify if that character of the
	 * string exists in the hash map or not. If the result is true, the counter for
	 * the character in the hash map is increased or else then put a count as 1.
	 * Once the loop ends, then the Hash map is traversed and print the characters
	 * with a count equal to 1.
	 * 
	 * @param word
	 * @param character
	 * @return
	 */
	public static String nonMatchingCharacterCount(String word, Character character) {
		
		Map<Character, Long> characterCount = word.chars().mapToObj(c -> (char)c)
				.collect(Collectors.groupingBy(
						Function.identity(),
						HashMap::new,
						Collectors.counting()));
		
		characterCount.forEach((k,v) -> {if(v == 1l) System.out.println(k + " : "+ v);});
		return characterCount.toString();
	}
	
	/**
	 * How to calculate the number of vowels and consonants in a string
	 * 
	 * Get the string on which count has to be performed. Run a loop from 0 to the
	 * length of the string. Take a single character at a time and verify if they
	 * are a part of the group of vowels. If the result is true, increase the count
	 * of vowels or else increment the count of consonants.
	 * 
	 * @param word
	 * @return
	 */
	public static String vowelAndConsonentCount(String word) {
		
		List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
		long vowelCount = 0;
		long consonentCount = 0;
		
		vowelCount = word.chars().filter(c -> vowels.contains((char)c)).count();
		consonentCount = word.chars().filter(c -> !vowels.contains((char)c)).count();
		
		Map<String, Long> vowelAndConsonentCount = new HashMap<String, Long>(2);
		vowelAndConsonentCount.put("vowels", vowelCount);
		vowelAndConsonentCount.put("consonent", consonentCount);
		
		return vowelAndConsonentCount.toString();
	}
	
	/**
	 * How do you prove that the two strings are anagrams
	 * 
	 * Two strings are called anagrams if they accommodate a similar group of
	 * characters in a varied sequence.
	 * 
	 * To check if two strings are anagrams, the below steps are followed:
	 * 
	 * Initialize two strings in two variables. Check if the length of the two
	 * strings is similar, if not then the strings are not an anagram. If the result
	 * is true, take the two strings and store them in a character array. Sort the
	 * two character arrays, then check if the two sorted arrays are alike. If the
	 * result is true, the two strings are anagram else, not anagram.
	 * 
	 * @param word
	 * @param anotherWord
	 * @return
	 */
	public static boolean anagramCheck(String word, String anotherWord) {
		
		if(word.length() != anotherWord.length()) {
			return false;
		}
		
		char [] word1 = word.toCharArray();
		char [] word2 = anotherWord.toCharArray();
		
		Arrays.sort(word1);
		Arrays.sort(word2);
		
		
		return Arrays.equals(word1, word2);
	}

	public static void main(String[] args) {

		System.out.print("Input your word : - ");
		Scanner inputWord = new Scanner(System.in);
		String word = inputWord.next();
		System.out.println("Reverse of word " + word + " :- " + reverseString(word));
		System.out.println("Is " + word + " word palindrome : - " + palindromeString(word));
		System.out.print("Input character for character count : - " );
		Character character = inputWord.next().charAt(0);
		System.out.println("Matching Character count from word " + word + " for character " + character + " : - " + matchingCharacterCount(word, character));
		System.out.println("non Matchting Character count from word " + word + " for character " + character + " : - " + nonMatchingCharacterCount(word, character));
		System.out.println("Number of vowels and consonent for " + word + " :- " + vowelAndConsonentCount(word));
	}

}
