package com.zest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zest.base.Basepage;
import com.zest.util.Credentials;
import com.zest.util.ElementUtil;

public class Loginpage extends Basepage {

	// we need to create locators using By
	// we will only use By locators

	WebDriver driver;
	ElementUtil elementUtil;

	By username = By.id("email");

	By password = By.id("pass");

	By loginbutton = By.name("login");

	// After initializing create a constructor of the webdriver by creating object
	// of the page class
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// method for returning the landing class of the next page

	public Homepage dologin(Credentials cred)

{
	elementUtil.sendKeys(this.username, cred.getappuserName());
	elementUtil.sendKeys(this.password, cred.getapppassword());
	elementUtil.doclick(loginbutton);
	return new Homepage(driver);
	
}

}
