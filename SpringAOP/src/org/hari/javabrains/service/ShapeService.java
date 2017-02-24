package org.hari.javabrains.service;

import org.hari.javabrains.aspect.Loggable;
import org.hari.javabrains.model.Circle;
import org.hari.javabrains.model.Triangle;

public class ShapeService {

	private Circle circle;
	private Triangle triangle;
	
	@Loggable
	public Circle getCircle() {
		System.out.println("For Proxy");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
}
