package set_student;

import java.util.*;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iterator = coll.iterator();
		while (iterator.hasNext()) {
			T next = iterator.next();
			if (p.test(next)) iterator.remove();
		}

	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iterator = coll.iterator();
		while (iterator.hasNext()) {
			T next = iterator.next();
			if (!p.test(next)) iterator.remove();
		}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		// TODO
		Set<T> result = new HashSet<>();
		Iterator<T> iterator = coll.iterator();
		while (iterator.hasNext()) {
			T next = iterator.next();
			if (p.test(next)) result.add(next);
		}
		return result;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		// TODO
		List<T> arrL = new ArrayList<>(coll);
		for (int i = 0; i < arrL.size(); i++) {
			if (p.test(arrL.get(i))) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		List<Integer> arrL = new ArrayList<>();
		for (int i = 1; i < 11; i++) arrL.add(i);
		arrL.add(10);
		Even p = new Even();
		System.out.println(find(arrL, p));
		System.out.println(Arrays.toString(collect(arrL, p).toArray()));
		retain(arrL, p);
		System.out.println(Arrays.toString(arrL.toArray()));
		remove(arrL, p);
		System.out.println(Arrays.toString(arrL.toArray()));
	}
}
