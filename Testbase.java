package com.mercury.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mercury.qa.utility.Testutil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	
    //global varible which is use everywhere
public static WebDriver driver;
public static Properties prop;
       //constructor name same as class name
public Testbase() {
try	{
      //reading properties by using fileinputstream which is useful for everywhere
prop=new Properties();
FileInputStream ip=new FileInputStream("C:\\seleniumpractice\\Mercurry\\src\\main\\java\\com\\mercury\\qa\\confg\\configuration.properties");
prop.load(ip);

}
catch(FileNotFoundException e)
{
e.printStackTrace();
}
catch(IOException e)
{
e.printStackTrace();
}
}
public static void initialitation()
{
String browsername=prop.getProperty("browser");
//considering every browser
if(browsername.equals("chrome"))
{
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
}
else if(browsername.equals("firefox"))
{
WebDriverManager.firefoxdriver().setup();
driver=new FirefoxDriver();
}
else if(browsername.equals("edge"))
{
WebDriverManager.edgedriver().setup();
driver=new EdgeDriver();
}
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(Testutil.implicit_load_timeout, TimeUnit.MILLISECONDS);
driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(Testutil.lpage_load_timeout, TimeUnit.SECONDS);
driver.get(prop.getProperty("url"));
driver.get(prop.getProperty("username"));
driver.get(prop.getProperty("password"));
}

}
