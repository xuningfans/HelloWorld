package net.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println();
    	System.out.println("MySessionListener Initialized!");
    	System.out.println();
    }
    
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println();
    	System.out.println("MySessionListener Destroyed!");
    	System.out.println();
    }
	
}
