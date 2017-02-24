package org.hari.javabrains.model;

public class Circle {

	private String name;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle Setter has been called (target method)");
		//throw(new RuntimeException());
	}
	
	public String setNameandReturn(String name) {
		this.name = name;
		System.out.println("setNameandReturn Method called");
		return "Hari";
	}
}
