package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.Testbase;

public class Login  extends Testbase{
	
	//page factory-OR object recognisation;
	
		@FindBy(name="userName")
		WebElement username;
		
	@FindBy(name="password")
	WebElement password;

	@FindBy(name ="submit")
	WebElement submit;

	@FindBy(xpath="//img[@src='images/logo.gif']")
	WebElement MercuryLogo;

	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[10]/td/table/tbody/tr/td[2]/font/a")
	WebElement Registerpage;

	public Login()
	{
		//initialise object   //initialisation driver
		
		PageFactory.initElements(driver,this);
	}
	public String validatePagelogintitle()//title of application
	{
		//method write here
		//actions
		return driver.getTitle();
	}
	public boolean validatemercurylogo()//logo of application
	{
		return MercuryLogo.isDisplayed();//given true or false
	}
	public Homepage Login1(String un,String pw)
	{
		///after login return to login page no home page here
		//which is define above username and login
		username.sendKeys(un);
		password.sendKeys(pw);
		 submit.click();
		 return new Homepage();//return home page after logging
	}

}
