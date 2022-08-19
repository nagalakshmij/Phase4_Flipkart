package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;



public class TimeSpinner {

private AndroidDriver driver;
private WebDriverWait wait;

@BeforeMethod


public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("appium:platformVersion", "11");
    desiredCapabilities.setCapability("appium:deviceName", "CT40");
    desiredCapabilities.setCapability("appium:appPackage", "io.appium.android.apis");
    desiredCapabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
  }
@Test
public void sampleTest() throws InterruptedException 
{
	//SwipeUpLong();
	//SwipeUpLong();
	//SwipeUpSmall();
	(new TouchAction(driver))
	.press(PointOption.point(520, 830))
	.moveTo(PointOption.point(520, 649))
	.release()
	.perform();

	driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]").click();
    driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Date Widgets\"]").click();
    driver.findElementByXPath("//android.widget.TextView[@content-desc=\"1. Dialog\"]").click();
    driver.findElementByXPath("//android.widget.Button[@content-desc=\"change the time (spinner)\"]").click();
    Thread.sleep(5000);
    MobileElement CenterButton= (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.EditText");
    System.out.println("CenterButton text ="+CenterButton.getAttribute("text"));
    System.out.println("CenterButton position X ="+CenterButton.getCenter().getX());
    System.out.println("CenterButton position Y ="+CenterButton.getCenter().getY());
    
    
    MobileElement DownButton = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[1]/android.widget.Button[2]");
    System.out.println("DownButton text ="+DownButton.getAttribute("text"));
    System.out.println("DownButton position X ="+DownButton.getCenter().getX());
    System.out.println("DownButton position Y ="+DownButton.getCenter().getY());
    int startX=DownButton.getCenter().getX();
    int startY=DownButton.getCenter().getY();
    
    int endX=CenterButton.getCenter().getX();
    int endY=CenterButton.getCenter().getY()-400;
    endY= startY-100;
    System.out.println("StartY ="+startY);
    System.out.println("endY ="+endY);
    
    TouchAction touchAction = new TouchAction(driver);
    
    touchAction
    .press(PointOption.point(startX,startY))
    .moveTo(PointOption.point(startX,endY))
    .release()
    .perform();
}
}
