package org.hari.lambdas.unit3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.hari.lamdas.unit1.Person;

public class ForEachExample3 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList( 
				new Person("Hari","Krishna",30),
				new Person("Teja", "Satya",23),
				new Person("Lewis", "Carroll", 32),
				new Person("Mathew", "Arnold",34),
				new Person("Darwin", "Charles", 32)
				);
		
		System.out.println("Using Lambda");

		for (int i = 0; i< people.size(); i ++){
			System.out.println(people.get(i));
		}
		
		System.out.println("Using Lambda");
		people.forEach(System.out::println);
		
	}
}