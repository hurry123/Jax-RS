package org.hari.lamdas.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandling1 {

	public static void main(String[] args) {
		
		int[] somenumbers = { 2,3,4,5,6 };
		int key = 0;
		
		process(somenumbers,key, wrapperLambda((k,v) -> System.out.println(k / v)));
		
	}

	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer,Integer> consumer) {
		return (v,k) -> {
		try{
			consumer.accept(v,k);
		} catch(ArithmeticException e){
			e.printStackTrace();
		}
	
	};
	}
	private static void process(int[] somenumbers, int key, BiConsumer<Integer,Integer> consumer) {
		
		for(int i : somenumbers) {
			consumer.accept(i, key);
		}
	}
}
