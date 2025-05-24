package com.pack1;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

//@WebListener
public class RequestListner implements ServletRequestListener,ServletRequestAttributeListener
{
     @Override
    public void requestInitialized(ServletRequestEvent sre) 
     {
    	// TODO Auto-generated method stub
    	System.out.println("request object Initialized");
    }
     @Override
    public void requestDestroyed(ServletRequestEvent sre)
     {
    	// TODO Auto-generated method stub
    	 System.out.println("request object destroyed");
    }
     
     @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) 
     {
    	// TODO Auto-generated method stub
    	 System.out.println("Attribute added to servletrequest");
    	 System.out.println("===>"+srae.getName());
    }
     
     @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) 
     {
    	// TODO Auto-generated method stub
    	 System.out.println("Attribute removed to servletrequest");
    }
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) 
    {
    	// TODO Auto-generated method stub
    	 System.out.println("Attribute replaced to servletrequest");
    }
     
     
     
     
}

