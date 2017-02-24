package org.hari.javabrains;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware,BeanNameAware, InitializingBean,DisposableBean, Shape {
	
	private Shape shape; 
	
	
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	


	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context = null;
	
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	
	public void draw(){
		System.out.println("Drawing Triangle");
		System.out.println("PointA, x:" + getPointA().getX() + ", y:" + getPointA().getY());
		System.out.println("PointB, x:" + getPointB().getX() + ", y:" + getPointB().getY());
		System.out.println("PointC, x:" + getPointC().getX() + ", y:" + getPointC().getY());
		//System.out.println(context.isSingleton("triangle"));
	}
	
	
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
		
	}
	public void setBeanName(String beanName) {
		
		System.out.println("Bean Name " + beanName);
		
	}
	public void afterPropertiesSet() throws Exception { //Initializing using Spring provided interface
		System.out.println("Initialization bean called");
	}
	
	public void destroy() throws Exception {
		
		System.out.println("Disposable bean called to cleanup");
	}
	
	
	/* If the member variables are a list of user defined objects. we can call getter/setters like below
	 * List<Point> points;
	
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	

	public void draw(){
		for (Point point: points){
			System.out.println("Point A, X:" + point.getX() + ", Y: " + point.getY());
		}
	}*/
	
	
	public void initMethod(){
		System.out.println("Init method called from Global Bean");
	}
}
