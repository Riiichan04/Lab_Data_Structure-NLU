package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "src/lab8/data/fit.txt";
	// <word, its occurences>

	private Map<String, Integer> map = new HashMap<String, Integer>();

	public MyWordCountApp() throws FileNotFoundException {
		loadData();
	}


	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in lab8.TestReadFile.java
	public void loadData() throws FileNotFoundException {
		try {
			Scanner input = new Scanner(new File(fileName));

			while (input.hasNext()) {
				String word = input.next();
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}
		catch (FileNotFoundException e) {
			throw new FileNotFoundException("Uh huhhh");
		}
	}
	// Returns the number of distinct tokens in the file data/hamlet.txt or fit.txt
	public int countDistinct() {
		return map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		Collection<Integer> listValue =  map.values();
		System.out.println(Arrays.toString(listValue.toArray()));
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		Map<String, Integer> treeMap = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		treeMap.putAll(map);
		Set<Map.Entry<String, Integer>> set = treeMap.entrySet();
		System.out.println(Arrays.toString(set.toArray()));
	}

	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp mwca = new MyWordCountApp();
		System.out.println(mwca.countDistinct());
		mwca.printWordCounts();
		mwca.printWordCountsAlphabet();
	}
}
