package org.hari.lamdas.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Unit1ExcerciseSolutionsJava8 {

	public static <T> void main(String[] args) {
		
		List<Person> people = Arrays.asList( 
				new Person("Hari","Krishna",30),
				new Person("Teja", "Satya",23),
				new Person("Lewis", "Carroll", 32),
				new Person("Mathew", "Arnold",34)	
								
				);
		//Step1: sort list by last name
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
	    printConditionally(people, p -> true);	
	
	  //Step 2: create a method that prints all the elements in the list
	  		System.out.println("Printing all elements ");
	  		printConditionally(people,p -> true);
	  		
	  // Step 3: Create a method that prints all people that have last name begining with C
	  		System.out.println("Printing all elements starting with C ");
	  		printConditionally(people, p -> p.getLastName().startsWith("C"));
	}

	private static void printConditionally(List<Person> people, Predicate<Person> predicate) {

		for(Person p: people){
			if (predicate.test(p)) {
				System.out.println(p);
			}
		}
	}
}

