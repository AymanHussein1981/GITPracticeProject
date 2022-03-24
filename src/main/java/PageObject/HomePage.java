package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	public HomePage(AndroidDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement Text;
	
	public WebElement getText()
	{
		System.out.println("Writethename");
		return Text;
	}
	
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	public WebElement Femail;
	
	public WebElement getFemail()
	{
		System.out.println("XXXXXXX");
		return Femail;
	}
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	public WebElement spinner;
	

}
