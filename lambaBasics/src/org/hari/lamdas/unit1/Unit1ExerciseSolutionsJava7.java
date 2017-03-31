package org.hari.lamdas.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseSolutionsJava7 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList( 
				new Person("Hari","Krishna",30),
				new Person("Teja", "Satya",23),
				new Person("Lewis", "Carroll", 32),
				new Person("Mathew", "Arnold",34)	
								
				);
		
		//Step1: sort list by last name
		
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person arg0, Person arg1) {

				return arg0.getLastName().compareTo(arg1.getLastName());
			}
		});
		
		//Step 2: create a method that prints all the elements in the list
		
		System.out.println("Printing all elements ");
		printALL(people);
		
		// Step 3: Create a method that prints all people that have last name begining with C

		System.out.println("Printing all elements starting with last name C");
		printConditionally(people, new Condition() {

			@Override
			public boolean printCondition(Person p) {

				if(p.getLastName().startsWith("C")){
					return true;
				}
				return false;
			}
		}
			
		);
		

		System.out.println("Printing all elements starting with first name T");
		printConditionally(people, new Condition() {

			@Override
			public boolean printCondition(Person p) {

				if(p.getFirstName().startsWith("T")){
					return true;
				}
				return false;
			}
		}
		);
		
 }
	
	private static void printConditionally(List<Person> people, Condition condition) {
		
		for(Person p : people){
			if(condition.printCondition(p)){
			System.out.println(p);
			}
		}
	}

	private static void printALL(List<Person> list){
		
		for(Person p : list){
			System.out.println(p);
		}
		
	}
}


interface Condition{
	boolean printCondition(Person p);
}