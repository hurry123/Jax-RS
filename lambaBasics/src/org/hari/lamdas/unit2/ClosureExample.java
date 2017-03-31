package org.hari.lamdas.unit2;

public class ClosureExample {

	public static void main(String[] args) {

		int a= 10;
		int b = 20; //freezes the value & passes around. 
		doProcess(a, i -> System.out.println(a +b) );
		
	}
	
	public static void doProcess(int i, Process p){
		
		p.process(i);
	}
	

}


interface Process{
	void process(int i);
}