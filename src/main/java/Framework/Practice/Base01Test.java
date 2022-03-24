package Framework.Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base01Test {
	
	public static AppiumDriverLocalService service;

	public AppiumDriverLocalService startServer()
		{
			service=AppiumDriverLocalService.buildDefaultService();
					service.start();
					return service;
		}
	
	@BeforeTest
	public void killallnodes() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(4000);
	}

	public static void StartEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("C:\\Users\\ayman\\eclipse-workspace\\Practice\\src\\main\\java\\StartEmulator.bat");
		Thread.sleep(6000);
	}
	
	public static AndroidDriver<AndroidElement> driver;

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		FileInputStream fis=new FileInputStream("C:\\Users\\ayman\\eclipse-workspace\\Practice\\src\\main\\java\\Framework\\Practice\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		
		File apploc=new File("src");
		File app=new File(apploc, (String) prop.get(appName));
		
		DesiredCapabilities cap=new DesiredCapabilities();
		//String device=(String) prop.get("device");
		String device=System.getProperty("deviceName");
	
		if(device.contains("emulator"))
		{
			StartEmulator();
		}
	

			
		
	
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		
		 driver =new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		return driver;
		

	}
	
	public static void getscreenshot(String s) throws IOException
	{
		File scrnfile =driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnfile, new File(System.getProperty("user.dir")+"\\"+s+".png"));
	}

}
