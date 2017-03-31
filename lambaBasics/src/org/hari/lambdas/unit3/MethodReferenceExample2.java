package org.hari.lambdas.unit3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.hari.lamdas.unit1.Person;

public class MethodReferenceExample2 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList( 
				new Person("Hari","Krishna",30),
				new Person("Teja", "Satya",23),
				new Person("Lewis", "Carroll", 32),
				new Person("Mathew", "Arnold",34)	
				);
		//Step1: sort list by last name
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
	    performConditionally(people, p -> true, System.out::println);	
	
	  //Step 2: create a method that prints all the elements in the list
	  		System.out.println("Printing all elements ");
	  		performConditionally(people,p -> true,p -> System.out.println(p));
	  		
	  // Step 3: Create a method that prints all people that have last name begining with C
	  		System.out.println("Printing all elements starting with C ");
	  		performConditionally(people, p -> p.getLastName().startsWith("C"),p -> System.out.println(p));
	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {

		for(Person p: people){
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}
}