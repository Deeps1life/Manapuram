package com.amazon.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.amazon.pom.HomePage;
import com.amazon.pom.LoginPage;

public class Baseclass {
	public static WebDriver driver;
	public FileLib f=new FileLib();
	
	@BeforeClass
	public void openBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = f.readDataFromProperty("url");
		driver.get(url);
		
	}	
	
	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		String un = f.readDataFromProperty("un");
		String pwd=f.readDataFromProperty("pwd");
		LoginPage l=new LoginPage(driver);
		l.login(un, pwd);
		
	}
	
	@AfterMethod
	public void logout() {
		HomePage h=new HomePage(driver);
		h.logout();
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	
}


