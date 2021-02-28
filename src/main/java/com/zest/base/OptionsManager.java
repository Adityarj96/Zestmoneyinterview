package com.zest.base;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	public ChromeOptions co;
	public FirefoxOptions ffo;
	public Properties prop;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if (prop.getProperty("headless").equals("yes"))
			co.addArguments("--headless");
		co.addArguments("--disable-popup-blocking");
		co.addArguments("--disable-notifications");
		return co;

	}

	public FirefoxOptions getFirefoxOptions() {
		ffo = new FirefoxOptions();
		if (prop.getProperty("headless").equals("yes"))
			ffo.addArguments("--headless");

		return ffo;
	}

}
