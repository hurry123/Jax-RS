package org.hari.javabrains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.annotation.*;


@Component
public class Circle implements Shape, ApplicationContextAware{
	
	private Point center;
	private ApplicationEventPublisher publisher;
	
	
	@Autowired
	private MessageSource messageSource;
	
	public Point getCenter() {
		return center;
	}

	//@Required
	//@Autowired
	//@Qualifier("circleQualifier")
   @Resource(name="point2")
	public void setCenter(Point center) {
		this.center = center;
	}


	public MessageSource getMessageSource() {
	return messageSource;
}

public void setMessageSource(MessageSource messageSource) {
	this.messageSource = messageSource;
}

	public void draw() {
		
		//using messageSource here
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default drawing circle", null));
		
		//we can do context.getMessage in the below & put all static text in properties file
		//btw, context.get == messageSource.get
		
		//System.out.println("Circle, Point is, ( " + center.getX() + "," + center.getY() + " )");
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {center.getX(), center.getY()}, "Default Point Message", null));

		
		//we used messageResource interface & declared as a member variable & used it. 
		//System.out.println(this.messageSource.getMessage("greeting", null, "Default greeting", null));
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	
	}

	//@PostConstruct
	public void initCircle(){
		System.out.println("init of circle");
		
	}
	
	//@PreDestroy
	public void destroyCircle(){
		System.out.println("destroy of circle");
	}

	public void setApplicationContext(ApplicationContext publisher)
			throws BeansException {

		this.publisher = publisher;
	}
	
}
