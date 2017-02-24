package org.hari.javabrains;

import org.hari.javabrains.model.Triangle;
import org.hari.javabrains.service.FactoryService;
import org.hari.javabrains.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class AopMain {

	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		//ShapeService shapeService =   (ShapeService) ctx.getBean("shapeService", ShapeService.class);
		//shapeService.getCircle().setName("Teja");
		//System.out.println(shapeService.getCircle().getName());
		//shapeService.getCircle();
		//System.out.println(shapeService.getTriangle().getName());
		

	  	FactoryService factoryService = new FactoryService();		
		ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");		
		shapeService.getCircle();
	}
}
