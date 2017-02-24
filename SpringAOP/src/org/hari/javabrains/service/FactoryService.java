package org.hari.javabrains.service;

import org.hari.javabrains.model.Circle;
import org.hari.javabrains.model.Triangle;

public class FactoryService {

	public Object getBean(String beanType){
		
		if(beanType.equals("shapeService")) return new ShapeServiceProxy();
		if(beanType.equals("triangle")) return new Triangle();
		if(beanType.equals("circle")) return new Circle();
		return null;
  		
	}
}
