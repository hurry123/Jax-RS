package org.hari.javabrains;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Controller;

@Controller
public class MyEventLister implements ApplicationListener {

	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event.toString());
		
	}


}
