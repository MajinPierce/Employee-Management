package com.hcl.employeeManagement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger log = LogManager.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	log.debug("Begin program execution");
    	UserInterface.startApp();
    	log.debug("End program execution");
    }
}
