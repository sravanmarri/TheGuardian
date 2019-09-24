package testScripts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import reusability.Components;

public class ValidateUrl {


	public static void main(String[] args) throws IOException, Exception {
		
		String href = "https://www.theguardian.com/tone/news";
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(href);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#top > div.site-message.js-site-message.site-message--banner.site-message--first-pv-consent.site-message--permanent > div > div > div.site-message__copy.js-site-message-copy.u-cf > div.site-message--first-pv-consent__actions > button > span:nth-child(2)")).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Sport")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String sportText = driver.findElement(By.cssSelector("a[href*='cycling-road-world-championships-2019-womens-individual-time-trial-live']")).getText();
		System.out.println("ss"+sportText);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(sportText);
		driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='ellip'][contains(text(),'Cycling Road World Championships 2019: Chloe Dyger')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		//Validate response code of url from google account
		String surl = driver.getCurrentUrl();
		URL url = new URL(surl);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int code = connection.getResponseCode();
		HashSet rscodes = new HashSet();
		rscodes.add("302");
		rscodes.add("304");
		rscodes.add("200");
	
		if(!rscodes.contains(code))
		{

			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}

	}

}
