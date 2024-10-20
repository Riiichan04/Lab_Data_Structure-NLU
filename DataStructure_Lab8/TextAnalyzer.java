package lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	public TextAnalyzer(String fileName) throws IOException {
		this.load(fileName);
	}

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file lab8.TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int eolPos = 0;
		while (true) {
			line = reader.readLine();
			if (line == null) break;
			String[] words = line.split("\\s");
			for (int i = 0; i < words.length; i++) {
				int	value = eolPos + i + 1;
				if (i == words.length - 1) value = -value;
				add(words[i], value);
			}
			eolPos += words.length;
		}
		reader.close();
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		if (map.containsKey(word)) {
			map.get(word).add(position);
		}
		else {
			ArrayList<Integer> listPos = new ArrayList<>();
			listPos.add(position);
			map.put(word, listPos);
		}
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		Map<String, ArrayList<Integer>> listWord = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		listWord.putAll(map);
		Set<Map.Entry<String, ArrayList<Integer>>> set = listWord.entrySet();
		System.out.println(Arrays.toString(set.toArray()));
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		Set<String> setKey = map.keySet();
		List<Integer> listPos = new ArrayList<>();
		List<String> listString = new ArrayList<>();
		for (String key : setKey) {
			listPos.addAll(map.get(key));
			for (Integer temp : map.get(key)) {
				listString.add(key);
			}
		}
		int index = 0;
		for (String s : listString) {
			index++;
			if (!listPos.contains(index)) {
				System.out.print(listString.get(listPos.indexOf(-index)) + " ");
				System.out.println();
			}
			else System.out.print(listString.get(listPos.indexOf(index)) + " ");
		}
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		Set<String> setKey = map.keySet();
		int max_Value = 0;
		String result = "";
		for (String currentWord : setKey) {
			int tempValue = map.get(currentWord).size();
			if (tempValue > max_Value) {
				max_Value = tempValue;
				result = currentWord;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		TextAnalyzer textAnalyzer = new TextAnalyzer("src/lab8/data/short.txt");
		textAnalyzer.displayWords();
		System.out.println(textAnalyzer.mostFrequentWord());
		textAnalyzer.displayText();
	}
}
