package org.hari.javabrains.rest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class MyDateConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type arg1, Annotation[] arg2) {
		
		if(rawType.getName().equals(MyDate.class.getName()) ) {
			
			return new ParamConverter<T>() {
				
				@Override
				public T fromString(String paramString) {
					
					Calendar requestedDate = Calendar.getInstance();
					if("tomorrow".equalsIgnoreCase(paramString)){
						requestedDate.add(Calendar.DATE, 1);
					}
					else if ("yesterday".equalsIgnoreCase(paramString)){
						requestedDate.add(Calendar.DATE, -1);
					}
					
					MyDate myDate = new MyDate();
					myDate.setDate(requestedDate.get(Calendar.DATE));
					myDate.setMonth(requestedDate.get(Calendar.MONTH));
					myDate.setYear(requestedDate.get(Calendar.YEAR));
					
					return rawType.cast(myDate);
					
				}

				@Override
				public String toString(T paramT) {
					if(paramT == null){
						return null;

					}
					return paramT.toString();
				}

				
				
			};
		}
		
		return null;
	}

}
