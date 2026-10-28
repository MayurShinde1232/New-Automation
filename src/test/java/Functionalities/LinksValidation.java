package Functionalities;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksValidation {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		int brokenliks=0;
		List<WebElement> links= driver.findElements(By.tagName("a"));
		for(WebElement element: links) {
			
			String url = element.getAttribute("href");
			if(url== null || url.isEmpty())
			{
				System.out.print("URL is Empty");
				continue;
			}
			URL link= new URL(url);
			try
			{
				HttpURLConnection httpsconn= (HttpURLConnection) link.openConnection();
				httpsconn.connect();
				if(httpsconn.getResponseCode()>400)
				{
					System.out.println(httpsconn.getResponseCode()+url+" is"+" Broken link");
					brokenliks++;
				}
				else 
				{
					System.out.println(httpsconn.getResponseCode()+url+" is valid link");
				}
				
						
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			
		}

	}

}
