package com.pack1;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListner  implements HttpSessionListener,HttpSessionAttributeListener
{
	@Override
	public void sessionCreated(HttpSessionEvent se) 
	{
		// TODO Auto-generated method stub
		System.out.println("session ceated");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) 
	{
		// TODO Auto-generated method stub
		System.out.println("session destroyed");
	}
	
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) 
	{
		// TODO Auto-generated method stub
		System.out.println("attribute added");
	}
	
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) 
	{
		// TODO Auto-generated method stub
		System.out.println("attribute removed");
	}
	
	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) 
	{
		// TODO Auto-generated method stub
		System.out.println("attribute replaceds");
	}
	
	
	
	
	
	
	
	
	

}
