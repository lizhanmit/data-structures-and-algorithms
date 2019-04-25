package book.DSAInJava.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class WordCount {
	
	public static void main(String[] args) {
		Map<String, Integer> freq = new HashMap<>();
		Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");
		
		while (doc.hasNext()) {
			String word = doc.next().toLowerCase();
			Integer count = freq.get(word);
			// if there is no such a word in the map
			if (count == null) {
				count = 0;
			}
			freq.put(word, count + 1);
		}
		/*
		 * find the word with max count
		 */
		int maxCount = 0;
		String maxWord = "no word";
		for (Entry<String, Integer> entry : freq.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				maxWord = entry.getKey();
			}
		}
		System.out.print("The most frequent word is: " + maxWord);
		System.out.println("' with " + maxCount + " occurrences.");
	}
}
