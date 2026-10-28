package Functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TablesHandling {
	
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Locate the rows first
		int rows= driver.findElements(By.xpath("//table[@name='BookTable']//tbody/tr")).size();
		System.out.println("Rows count :"+ rows);
		//Locate the columns
		int columns= driver.findElements(By.xpath("//table[@name='BookTable']//tbody/tr/th")).size();
		System.out.println("Columns size :" +columns);
		String tableValue= driver.findElement(By.xpath("//table[@name='BookTable']//tbody/tr[4]/td[2]")).getText();
		System.out.println("TableValue :" + tableValue);
		
		
		//Print whole table
		/*for(int r=2; r<=rows;r++)
		{
			
			for(int c=1; c<=columns;c++)
			{
			
				String value= driver.findElement(By.xpath("//table[@name='BookTable']//tbody/tr["+r+"]/td["+c+"]")).getText();
					System.out.print(value+"\t");
			
			}
			System.out.println();
		}
		*/
		
		//Print books which are written by mukesh
		for(int r=2;r<=rows;r++)
		{
			String author= driver.findElement(By.xpath("//table[@name='BookTable']//tbody/tr["+r+"]/td[2]")).getText();
		
			if(author.equals("Mukesh"))
			{
				String bookName= driver.findElement(By.xpath("//table[@name='BookTable']//tbody/tr["+r+"]/td[1]")).getText();
				System.out.println(author+" = "+bookName);
			}
		
		}
		
		//Count the total price of books
		int count=0;
		for(int r=2;r<=rows;r++)
		{
			String value= driver.findElement(By.xpath("//table[@name='BookTable']//tbody/tr["+r+"]/td[4]")).getText();
			
			count= count+Integer.parseInt(value); // Convert string variable into Integer
			
		}
		System.out.println(count);
		
		
		/* Assessment -> Go on https://blazedemo.com/  click on search flights get lower price flight 
		click on book add details submit and get that last message and validate that write down the test case for it */
	
	
	}

}
