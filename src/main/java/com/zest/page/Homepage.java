package com.zest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zest.base.Basepage;
import com.zest.util.ElementUtil;

public class Homepage extends Basepage {

	WebDriver driver;
	ElementUtil elementUtil;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	By postsomething = By.xpath("//div[@aria-label='Account Controls and Settings']//div[3]//span[1]");
	By post = By.xpath(
			"//div/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/div/div[2]/div[1]/div/div[1]/div[1]");
	By writepost = By.xpath("//div[contains(@class,'o6r2urh6 buofh1pr datstx6m l9j0dhe7 oh7imozk')]");
	By postthepost = By.className(
			"oajrlxb2 s1i5eluu gcieejh5 bn081pho humdl8nn izx4hr6d rq0escxv nhd2j8a9 j83agx80 p7hjln8o kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x jb3vyjys d1544ag0 qt6c0cv9 tw6a2znq i1ao9s8h esuyzwwr f1sip0of lzcic4wl l9j0dhe7 abiwlrkh p8dawk7l beltcj47 p86d2i9g aot14ch1 kzx2olss cbu4d94t taijpn5t ni8dbmo4 stjgntxs k4urcfbm tv7at329");

	public void makeapost() throws InterruptedException {
		elementUtil.doActionsClick(postsomething);
		// Thread.sleep(5000);
		elementUtil.waitForElementToBeLocated(post, 10);
		elementUtil.doclick(post);
		elementUtil.waitForElementToBeLocated(post, 10);
		elementUtil.doActionsSendKeys(writepost, "Hello world");
		elementUtil.waitForElementToBeLocated(post, 10);
		elementUtil.doActionsClick(postthepost);
	}

}
