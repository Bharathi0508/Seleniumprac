import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import jdk.javadoc.doclet.Reporter;

@Test
public class LoginTest {
	
	public void Login( ) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
          String url = "https://demowebshop.tricentis.com/login";
		    driver.manage().window().maximize();
		    driver.get(url);
		    driver.navigate().refresh();
		    
		 FileInputStream fis = new FileInputStream("./External/UNandPwd.xlsx");
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sheet = wb.getSheet("Sheet1");
		  
		String  Username = sheet.getRow(1).getCell(0).toString(); 
		String Password = sheet.getRow(1).getCell(1).toString();
		
		  WebElement usernameField = driver.findElement(By.id("Email"));
	        WebElement passwordField = driver.findElement(By.id("Password"));
	        WebElement loginButton = driver.findElement(By.xpath("//input[@value =\"Log in\"]"));

	        usernameField.sendKeys(Username);
	        passwordField.sendKeys(Password);
	        loginButton.click();
	        
	      driver.close();


}}
