package Framework.Practice;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class APIDemoTEst extends Base01Test{
	
	


	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void APIDemo(String input) throws IOException, InterruptedException
	{

		service=startServer();
		
		AndroidDriver<AndroidElement> driver=capabilities("APIDemoApp");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementByClassName("android.widget.CheckBox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys(input);
		System.out.println("CELIA");
		System.out.println("YOUSEF");
		//driver.findElementById("android:id/button1").click();
		//driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
		driver.findElementsByClassName("android.widget.Button").get(1).click();

		
		service.stop(); 
		
		

	}

}
