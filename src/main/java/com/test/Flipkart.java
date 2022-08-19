
package com.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Flipkart 
{
	private AndroidDriver driver;
	
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "11");
		desiredCapabilities.setCapability("appium:deviceName", "CT40");
		desiredCapabilities.setCapability("appium:appPackage", "com.flipkart.android");
		desiredCapabilities.setCapability("appium:appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
	}

	
	
	@Test
	public void sampleTest() throws Exception 
	{
		Thread.sleep(5000);
		MobileElement language= (MobileElement) driver.findElementByXPath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[2]\r\n"
				);
		language.click();
		
		driver.findElementById("com.flipkart.android:id/select_btn").click();

		//driver.findElementById("com.flipkart.android:id/button").click();
		driver.findElementById("com.flipkart.android:id/custom_back_icon").click();
		Thread.sleep(5000);
		driver.findElementById("com.flipkart.android:id/search_widget_textbox").click();
		MobileElement searchtext = (MobileElement) driver.findElementByAccessibilityId("Search grocery products");
		searchtext.sendKeys("samsung phones");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inputext()
	{
		MobileElement menuOptionText= (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Text\"]");
		menuOptionText.click();

		MobileElement menuOption_LogTextBox =(MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"LogTextBox\"]");
		menuOption_LogTextBox.click();

		MobileElement txtBox_logtxtbox =(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView");
		txtBox_logtxtbox.sendKeys(" Hello Day 4 Phase 4");

	}


	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
