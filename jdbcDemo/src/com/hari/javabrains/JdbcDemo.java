package com.hari.javabrains;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hari.javabrains.dao.JdbcDaoImpl;
import com.hari.javabrains.dao.NamedJdbcDaoImpl;
import com.hari.javabrains.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		NamedJdbcDaoImpl dao = ctx.getBean("namedJdbcDaoImpl", NamedJdbcDaoImpl.class);
		//JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class );
		
		//Circle circle = dao.getCircle(1);
		
		/*
		 * for JDBC use
		 * Circle circle = new JdbcDaoImpl().getCircle(1); 
		 */
		
		//System.out.println(circle.getName());
		//System.out.println(dao.getCircleCount());
		//System.out.println(dao.getCircleName(1));
		//System.out.println(dao.getCircleById(1).getName());
		
		//dao.inserCircle(new Circle(3,"Third Circle"));
		//System.out.println(dao.getAllCircles().size());
		
		//dao.createTriangleTable();
		
		//dao.inserCircle(new Circle(5,"Fifth Circle"));
		System.out.println(dao.getCircleCount());
		//System.out.println(dao.getAllCircles().size());

	}

}
