package com.amazon.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath="//input[@placeholder='Enter your email / mobile no.']")
	private WebElement unTbx;
	
	@FindBy(xpath="//input[@placeholder='Enter password']")
	private WebElement pwdTbx;
	
	@FindBy(xpath="//input[@value='SIGN IN']")
	private WebElement signBtn;

	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public void login(String un,String pwd) throws InterruptedException {
		unTbx.sendKeys(un);
		pwdTbx.sendKeys(pwd);
		signBtn.click();
	}
}
