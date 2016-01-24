package net.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class MyservletRequestListener implements ServletRequestListener {

    
    public void requestDestroyed(ServletRequestEvent sre)  { 
		System.out.println();
		System.out.println("ServletRequestListener Destroyed!");
		System.out.println();
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println();
    	System.out.println("ServletRequestListener Initialized!");
    	System.out.println();
    }
	
}
