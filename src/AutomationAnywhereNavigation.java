import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationAnywhereNavigation{

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\WorkSpace\\SDET_Comprehensive_Assignment_JavaPythonProject\\Drivers\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the specified URL
        driver.get("https://www.automationanywhere.com/");
        driver.manage().window().maximize();
        // Verify Automation Anywhere logo is present
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Automation Anywhere']"));
        if (logo.isDisplayed()) {
            System.out.println("Automation Anywhere logo is present.");
        } else {
            System.out.println("Automation Anywhere logo is not present.");
        }
        // Verify Request demo button is present and clickable
        WebElement requestDemoButton = driver.findElement(By.xpath("//a[@title='Request demo']"));
        if (requestDemoButton.isDisplayed()) {
            System.out.println("Request demo button is present.");

            // Check if the button is clickable
            if (requestDemoButton.isEnabled()) {
                System.out.println("Request demo button is clickable.");
            } else {
                System.out.println("Request demo button is not clickable.");
            }
        } else {
            System.out.println("Request demo button is not present.");
        }

        // Close the browser
        driver.quit();
    }
}
