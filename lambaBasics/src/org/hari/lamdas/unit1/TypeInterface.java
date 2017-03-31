package org.hari.lamdas.unit1;

public class TypeInterface {

	public static void main(String[] args) {
		
		printLambda(s -> s.length());

		//StringLengthLambda myLambda = s -> s.length();
		
		//System.out.println (myLambda.lamdaFunction("Hello Lambda"));
	}

	public static void printLambda(StringLengthLambda l){
		
		System.out.println (l.lamdaFunction("Hello Lambda"));

	}
	
}

interface StringLengthLambda{
	int lamdaFunction(String a);
}