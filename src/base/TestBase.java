package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;




public class TestBase 
{
   public static WebDriver driver;
   public static Properties prob;
	
   public TestBase() throws IOException
	{
		
		try {
			
			prob = new Properties();
			FileInputStream ip = new FileInputStream("./src/config/config.properties");
			prob.load(ip);
		} catch (FileNotFoundException r) 
		{
		r.printStackTrace();
			// TODO: handle exception
		}
		catch (IOException r) 
		{
			r.printStackTrace();
		}
	}
   
    public static void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://techfios.com/test/101/");
	}
}
