package org.hari.javabrains;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//Triangle triangle = new Triangle();
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); 
		//use AbstractApplicationContext in above linke to access -> context.registerShutdownHook();
		//Triangle triangle = (Triangle) context.getBean("triangle");
		//triangle.draw();
		//Circle circle = (Circle) context.getBean("circle");
		// Shape shape = (Shape) context.getBean("shape");  // you can pass triangle object as a string to getBean, Instead we can pass an interface, called -> coding to interfaces
		
		Shape shape = (Shape) context.getBean("circle"); 
		shape.draw();
		//System.out.println(context.getMessage("greeting", null, "Default greeting", null));
		
		
		
	}

}
