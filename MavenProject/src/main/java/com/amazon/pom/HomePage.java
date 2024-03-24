package com.amazon.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	@FindBy(xpath="//div[@class='lp-rhs']/div/ul/li[7]/a")
	private WebElement signoutLink;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public void logout() {
		//WebElement resources = driver.findElement(By.linkText("Resources"));
		//Actions hover=new Actions(driver);
		//hover.moveToElement(hoverSignout).perform();
		signoutLink.click();
		
	}
	
	

}
