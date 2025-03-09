package randomTestScenarios;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class DropDownSelection {
	
	// Dropdown can be handled in 3 ways 1. Keyboard Strokes eg: keys.ENTER;  keys.ARROW_UP ; 2. Using Select Class as below; 3. Using locators
	
public void dropdowncheck() {
	
	WebDriver driver = new ChromeDriver();
	 driver.get("https://demowebshop.tricentis.com/books");
	 driver.manage().window().maximize();	 
	 
	 WebElement dropdown = driver.findElement(By.xpath("//select[@id=\"products-orderby\"]"));
	 
	 Select option = new Select(dropdown);
	// option.selectByIndex(3);
	 
	// option.selectByValue("https://demowebshop.tricentis.com/books?orderby=5");
	 
	 option.selectByVisibleText("Price: Low to High");
	
}

}
