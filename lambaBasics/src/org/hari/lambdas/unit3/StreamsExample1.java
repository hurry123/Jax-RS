package org.hari.lambdas.unit3;

import java.util.Arrays;
import java.util.List;

import org.hari.lamdas.unit1.Person;

public class StreamsExample1 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList( 
				new Person("Hari","Krishna",30),
				new Person("Teja", "Satya",23),
				new Person("Lewis", "Carroll", 32),
				new Person("Mathew", "Arnold",34),
				new Person("Darwin", "Charles", 32)
				);
		
		people.stream()
			.filter( p -> p.getLastName().startsWith("C"))
			.forEach(p -> System.out.println(p.getFirstName()));
	}

}
