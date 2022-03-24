package Framework.Practice;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ECommerce1Test extends Base01Test  {

	@Test
	public void Ecommerce() throws InterruptedException, IOException
	{
		service=startServer();
		
		AndroidDriver<AndroidElement> driver = capabilities("GenaralStoreApp");
		
		
		HomePage home=new HomePage(driver);
		home.getText().sendKeys("CELIA");
		home.getFemail().click();
		home.spinner.click();
		
		Utilities ui=new Utilities(driver);
		ui.scrollToText("Algeria");
		driver.findElementByXPath("//android.widget.TextView[@text='Algeria']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(1).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));");
		int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		for (int i=0;i<count;i++)
		{
			String text = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			if (text.equalsIgnoreCase("Jordan 6 Rings"))
			{
		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
			}
		}
		
			driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

Thread.sleep(4000);

	

		double sum=0;
		int text = driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		for (int i=0;i<text;i++)
		{
			String amount=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
			double valueamount=getAmount(amount);
			sum=sum+valueamount;
		}
	
		String totalamount = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		double totalamount1 = getAmount(totalamount);
		
		System.out.println(sum);
		System.out.println(totalamount1);
		System.out.println(sum-totalamount1);
		
		 
		service.stop(); 
	}
	
	public static double getAmount(String value)
	{
		 value=value.substring(1);
		 double valueamount=Double.parseDouble(value); 
		 return valueamount;
	}
	

}
