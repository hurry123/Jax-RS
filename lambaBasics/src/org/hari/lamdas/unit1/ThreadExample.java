package org.hari.lamdas.unit1;

public class ThreadExample {

	public static void main(String[] args) {

		Thread myThread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Inside Runnable method");
			}
			
		});
		
		
		myThread.run();
		
		Thread lamdaThreadObj = new Thread(()->System.out.println("lamdaThread Runnable method"));
		lamdaThreadObj.run();
	}

}
