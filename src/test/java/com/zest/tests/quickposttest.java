package com.zest.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zest.base.Basepage;
import com.zest.page.Homepage;
import com.zest.page.Loginpage;
import com.zest.util.Credentials;

public class quickposttest {
	Basepage basepage;
	Properties prop;
	WebDriver driver;
	Loginpage loginpage;
	Homepage homepage;
	Credentials usercred;

	/*
	 * Before test will execute within the test level and it will open the browser
	 * only one time and execute the test case Before method will execute the test
	 * cases for each and every method and it
	 */

	@BeforeTest
	// @BeforeMethod
	public void setup() {
		basepage = new Basepage();
		prop = basepage.init_Properties();
		String browsername = prop.getProperty("browser");
		driver = basepage.init_driver(browsername);
		driver.get(prop.getProperty("url"));
		loginpage = new Loginpage(driver);
		usercred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		homepage=loginpage.dologin(usercred);
		
	}

	@Test
	public void createafbpost() throws InterruptedException {
		homepage.makeapost();
	}
	
	
	

	

}