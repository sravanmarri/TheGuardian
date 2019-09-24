package reusability;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Components {
	public static WebDriver driver;
	public static void main(String[] args) {

		// Selection of browser
		// driver = Components.selectBrowser(TestConstants.IE);

	}
	public static WebDriver selectBrowser(String browserName,String url)
	{
		WebDriver driver = null;

		if(TestConstants.FIREFOX.equalsIgnoreCase(browserName))
		{
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase(TestConstants.IE))
		{

			// window code
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();   
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, url);
			System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver(caps); 
			System.out.println("Complete");

		}
		else if(browserName.equalsIgnoreCase(TestConstants.CHROME))
		{
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}

	
	
	}
