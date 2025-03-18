package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Streams {

	// @Test
	public void regular() {
		ArrayList<String> Names = new ArrayList<String>();
		Names.add("Aravind");
		Names.add("Arjun");
		Names.add("Ravi");
		Names.add("Raju");
		Names.add("Ajay");

		int count = 0;

		for (int i = 0; i < Names.size(); i++) {
			String s = Names.get(i);
			// System.out.println(s);
			if (s.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}

	// @Test
	public void streamFilter() {
		ArrayList<String> Names = new ArrayList<String>();
		Names.add("Aravind");
		Names.add("Arjun");
		Names.add("Ravi");
		Names.add("Raju");
		Names.add("Ajay");

		long C = Names.stream().filter(s -> s.startsWith("A")).count(); // filter method checks parallelly unlike for
																		// loop(checks 1 by 1) and saves execution time.
		System.out.println(C);

		// creation of steam directly instead of converting
		long d = Stream.of("Arjun", "Abijit", "Ramesh", "Raju").filter(s -> {
			s.startsWith("A"); // if there are more conditions, can be writeen in {} braces.
			return false;
		}).count();
		System.out.println(d);

		// print the names of ArrayList
		Names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		Names.stream().filter(s -> s.length() > 3).limit(3).forEach(s -> System.out.println(s));
	}

	// @Test
	public void streamMap() {

		ArrayList<String> Names = new ArrayList<String>();
		Names.add("Aravind");
		Names.add("Arjun");
		Names.add("Ravi");
		Names.add("Raju");
		Names.add("Ajay");

		// print names which have last letter as U with Uppercase
		Stream.of("Arjun", "Abijit", "Ramu", "Raju").filter(s -> s.endsWith("u")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// print names starts with A in uppercase in alphabetical order
		List<String> names = Arrays.asList("Arjun", "Abijit", "Ramu", "Raju"); // converted array(of strings) to arrayList
		names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toLowerCase())
				.forEach(s -> System.out.println(s));

		// Merging two diff ArrayLists
		Stream<String> newStream = Stream.concat(Names.stream(), names.stream());
		// newStream.sorted().forEach(d -> System.out.println(d));

		boolean flag = newStream.anyMatch(d -> d.equalsIgnoreCase("Ramu"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	@Test
	public void streamCollect() {

		// creating new List after doing manipulations
		List<String> ls = Stream.of("Arjun", "Abijit", "Ramu", "Raju").filter(a -> a.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.collect(Collectors.toList());
		
		System.out.println(ls.get(1));
		
		int l = Stream.of(1,3,2,2,5,8,3,9).distinct().sorted().collect(Collectors.toList()).get(2);
		System.out.println(l);
	}
}
