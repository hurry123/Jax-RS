package org.hari.lamdas.unit2;

public class ThisReferenceExample { 

	public static void main(String[] args) { //this reference cannot be called for static classes
		ThisReferenceExample thisreference = new ThisReferenceExample();
		
		/*thisreference.doProcess(12, i -> {
			System.out.println(i);
			//System.out.println(this);
		});*/
		
		thisreference.execute();
		
	}
//lambda expression doesn't override this implementation
	
	public void doProcess(int i, Process p){
		p.process(i);
	}
	
	public void execute(){
		 //System.out.println(this); //this here reference to the object on which execute method is being called

		doProcess(20, i -> {
			System.out.println(i);
			System.out.println(this);
		});
		
		
		
	}

	public String toString(){
		return "This is the main ThisReferenceExample Class instance";
	}
}
