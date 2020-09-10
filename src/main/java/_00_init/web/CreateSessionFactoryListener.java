package _00_init.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import ch02_h_login.util.HibernateUtils;




@WebListener
public class CreateSessionFactoryListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	HibernateUtils.getSessionFactory().close();
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	HibernateUtils.getSessionFactory();
    }
	
}
