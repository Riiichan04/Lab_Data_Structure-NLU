package set_student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<set_student.WordCount> result = new LinkedList<>();
		for (String word: words) {
			WordCount wc = new WordCount(word, countWord(word));
			if (!result.contains(wc)) {
				result.add(wc);
			}
		}
		return result;
	}

	//Count how many times word appear in list
	public int countWord(String input) {
		int result = 0;
		for (String word : words) {
			if (word.equals(input)) result++;
		}
		return result;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> result = new HashSet<>();
		for (String word : words) {
			int count = countWord(word);
			if (count == 1) result.add(word);
		}
		return result;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> result = new HashSet<>();
		for (String word : words) {
			result.add(word);
		}
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> exportWordCounts() {
		Set<WordCount> result = new TreeSet<>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				if (o2.getCount() - o1.getCount() == 0) return o1.getWord().compareTo(o2.getWord());
				else return o1.getCount() - o2.getCount();
			}
		});

		for (String word : words) {
			WordCount wc = new WordCount(word, countWord(word));
			result.add(wc);
		}

		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> result = new TreeSet<>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				if (o2.getCount() - o1.getCount() == 0) return o2.getWord().compareTo(o1.getWord());
				else return o2.getCount() - o1.getCount();
			}
		});

		for (String word : words) {
			WordCount wc = new WordCount(word, countWord(word));
			result.add(wc);
		}

		return result;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<WordCount> filterWords(String pattern) {
		Set<WordCount> result = new HashSet<>();
		for (String word : words) {
			WordCount wc = new WordCount(word, countWord(word));
			if (word.indexOf(pattern) != 0) result.add(wc);
		}
		return result;
	}

	public static void main(String[] args) {
		lab7.MyWordCount mwc = new lab7.MyWordCount();
		System.out.println(Arrays.toString(mwc.exportWordCounts().toArray()));
		System.out.println(Arrays.toString(mwc.exportWordCountsOrderByOccurence().toArray()));
		System.out.println(Arrays.toString(mwc.getUniqueWords().toArray()));
		System.out.println(Arrays.toString(mwc.getDistinctWords().toArray()));
		System.out.println(Arrays.toString(mwc.filterWords("Da").toArray()));
		System.out.println(mwc.getUniqueWords().size());
	}
}
