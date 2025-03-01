import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utilityMethods.ExcelUtils;

public class ExcelSeleniumTest {
	
	@Test
    public  void ExcelTest(String[] args) throws IOException {
        // Load Excel file
        ExcelUtils.loadExcel("/Interview/src/test/resources/UN^0Pwd.xlsx", "Sheet1");

        // Get test data
        String username = ExcelUtils.getCellData(1, 0);
        String password = ExcelUtils.getCellData(1, 1);

        // Set up Selenium WebDriver
       // System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://demowebshop.tricentis.com/login");

        // Find elements and perform actions
        WebElement usernameField = driver.findElement(By.id("Email"));
        WebElement passwordField = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.linkText("Log in"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        // Close resources
        driver.quit();
        ExcelUtils.closeExcel();
    }
}

