package com.zest.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage {

	WebDriver driver;
	Properties prop;
	OptionsManager optm;

	public WebDriver init_driver(String browsername) {
		System.out.println("Browsername is" + browsername);
		optm = new OptionsManager(prop);
		if (browsername.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optm.getChromeOptions());
		} else if (browsername.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optm.getFirefoxOptions());
		} else {
			System.out.println("Browsername not found please find the right browser");
		}

		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.get( );

		return driver;
	}

	// To read all the credentials create a object of properties

	public Properties init_Properties() {
		prop = new Properties();
		String path = null;
		String env = null;

		try {
			env = System.getProperty("env");
			if (env.equals("qa")) {
				path = "F:\\New folder\\myzestinterview\\src\\main\\java\\com\\zest\\properties\\qa.config.properties";
			}
		} catch (Exception e) {
			path = "F:\\New folder\\myzestinterview\\src\\main\\java\\com\\zest\\properties\\qa.config.properties";
		}

		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("Some  issue with config properties...please correct your config");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}
}
