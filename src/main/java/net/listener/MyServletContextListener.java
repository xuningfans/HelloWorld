package net.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


public class MyServletContextListener implements ServletContextListener {

    

    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println();
         System.out.println("ServletContextListener Destroy");
         System.out.println();
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println();
         System.out.println("ServletContextListerner Intialized!");
         System.out.println();
    }
	
}
