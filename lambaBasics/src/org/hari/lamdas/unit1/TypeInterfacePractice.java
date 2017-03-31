package org.hari.lamdas.unit1;

public class TypeInterfacePractice {
	
	public static void main(String[] args){
		
		 printLambda(p -> p.length());
		}
	
	public static void printLambda(lambdaPrint l){
		
		System.out.println(l.printString("Hello Lambda"));
		
	}

}


interface lambdaPrint{
	
	int printString(String a);
	
}