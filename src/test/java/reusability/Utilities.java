package reusability;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;


public class Utilities{

	private static WebDriver driver;
	private static WebElement element;

	public static String getProperty(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);		
	}

	
	//Scroll To And Highlight the Particular Element
	public static void ScrollToAndHighlight(WebDriver driver,WebElement element){
		try{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);",element);
			/*js.executeScript("arguments[0].style.border='3px solid green'", element);
				Thread.sleep(200);
				js.executeScript("arguments[0].style.border=''", element);*/
			js.executeScript("arguments[0].style.border='2px solid green'",
					element);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	
}






