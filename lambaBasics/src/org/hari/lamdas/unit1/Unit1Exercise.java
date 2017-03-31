package org.hari.lamdas.unit1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Unit1Exercise {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList( 
				new Person("Hari","Krishna",30),
				new Person("Teja", "Satya",23),
				new Person("Lewis", "Carroll", 32),
				new Person("Mathew", "Arnold",34)	
								
				); 
		
		Unit1Exercise step2 = new Unit1Exercise(); 
		
		step2.printAll(people);
		
		// Step 1 : Sort List by last name
		
		// Step 2: create a method that prints all elements in the list
		
		// Step 3: Create a method that prints all people that have last name begining with C
		
		//printLambda((List<Person> people) -> people.toString());

	}
	
	public static void printLambda(PrintAll p) {
		//System.out.println(p.lambdaList());
		
	}

	public void printAll(List<Person> list){
		 
		System.out.println(list.toString());
	}
	
}

interface PrintAll {
	List<Person> lambdaList(List<Person> l);
}
