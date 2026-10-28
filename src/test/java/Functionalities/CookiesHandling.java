package Functionalities;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesHandling {
	
	public static void main(String [] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		//How to capture cookies from browser
		Set<Cookie> cookies=driver.manage().getCookies();
		
		System.out.println(cookies.size());
		
		//How to print cookies from browser
		for(Cookie cookie:cookies)
		{
			System.out.println(cookie.getName()+" : "+cookie.getValue());
			
		}
		
		//How to add cookie to the browser
		
		Cookie cookieobj= new Cookie("MyCookie","12344554");
		driver.manage().addCookie(cookieobj);
		cookies= driver.manage().getCookies(); 
		System.out.println("Cookies Size ="+cookies.size());
		
		//How to delete specific cookie
		
		//driver.manage().deleteCookie(cookieobj);
		
		
		//Delete cookie by named
		driver.manage().deleteCookieNamed("MyCookie");
		cookies= driver.manage().getCookies();
		System.out.println("Cookies after deletin one cookie = "+ cookies.size());
		
		
		//How to delete all cookies
		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println("Deleting all cookies ="+ cookies.size());
		
		driver.quit();
	}

}
