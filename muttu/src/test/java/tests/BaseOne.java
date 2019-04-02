package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;


public class BaseOne {
	
	private Logger logger=LogManager.getLogger(BaseOne.class);
	
	@BeforeTest
	public void beforeTest() {
		
		logger.debug("this is befor test fron the base class");

	}

}
