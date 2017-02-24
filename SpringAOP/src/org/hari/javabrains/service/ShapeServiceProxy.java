package org.hari.javabrains.service;

import org.hari.javabrains.aspect.LoggingAspect;
import org.hari.javabrains.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}
