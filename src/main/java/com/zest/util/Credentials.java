package com.zest.util;

public class Credentials {

	// java object class to pass the parameters as the object
	String appuserName;
	String apppassword;

	// create a constructor for passing the java objects
	public Credentials(String appuserName, String apppassword) {
		this.appuserName = appuserName;
		this.apppassword = apppassword;
	}

	// these methods are encapsulated
	public String getappuserName() {
		return appuserName;
	}

	public void setappuserName(String appuserName) {
		this.appuserName = appuserName;
	}

	public String getapppassword() {
		return apppassword;
	}

	public void setapppassword(String apppassword) {
		this.apppassword = apppassword;
	}

}
