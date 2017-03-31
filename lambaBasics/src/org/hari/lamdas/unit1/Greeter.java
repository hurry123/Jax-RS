package org.hari.lamdas.unit1;

public class Greeter {
	
	public void greet(Greeting greeting){
		greeting.perform();
	}

	public static void main(String[] args) {

		Greeter greet = new Greeter();
		HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
		//greet.greet(helloWorldGreeting);
		
		Greeting greetInterfaceObj = new HelloWorldGreeting();
		
		greetInterfaceObj.perform();
		
		Greeting lamdaFunction = () -> System.out.print("Hello world");
		
		//lamdaFunction.perform();
	}

}
