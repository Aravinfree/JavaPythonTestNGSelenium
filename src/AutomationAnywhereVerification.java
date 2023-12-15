import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutomationAnywhereVerification {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\WorkSpace\\SDET_Comprehensive_Assignment_JavaPythonProject\\Drivers\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        // Navigate to the website
        driver.get("https://www.automationanywhere.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        findAcceptCookiesButton(driver);
        // Verify and click on each link
        verifyAndClickLink(driver, "Products");
        verifyAndClickLink(driver, "Solutions");
        verifyAndClickLink(driver, "Resources");
        verifyAndClickLink(driver, "Beyond RPA");
        verifyAndClickLink(driver, "Company");
        
        // Close the browser
        driver.quit();
    }
    
    private static void findAcceptCookiesButton(WebDriver driver) {
    	// Check if the "Accept All Cookies" button exists
    	try {
        WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[text()='Accept All Cookies']")); 
        if (acceptCookiesButton != null) {
            // Click the "Accept All Cookies" button
            acceptCookiesButton.click();
        } else {
            System.out.println("Accept All Cookies button not found or already accepted.");
            // Handle the case where the button is not found or has already been accepted
        }
        } catch (Exception e) {
            // Handle the exception or return null
            System.out.println(e.getMessage());
        }
    }
    
   
	private static void verifyAndClickLink(WebDriver driver, String linkText) {
    	WebElement link = null;
        // Verify link presence
    	if(linkText == "Beyond RPA"){
    		link = driver.findElement(By.xpath("//a[@title='" + linkText + "']"));
    	}else{
    		link = driver.findElement(By.xpath("//a[contains(text(), '" + linkText + "')]"));
    	}
    	if (link.isDisplayed()) {
            System.out.println(linkText + " link is present.");
        } else {
            System.out.println(linkText + " link is not present.");
        }
		link.click();
    	System.out.println("URL of the page: "+driver.getCurrentUrl());
    	String getCurrentURL = driver.getCurrentUrl();
    	if(linkText.equalsIgnoreCase("Beyond RPA")) {
    		boolean strRPA = getCurrentURL.equals("https://www.automationanywhere.com/rpa/robotic-process-automation");
    		if(strRPA) {
    			System.out.println("Beyond RPA page navigation successful");
    		}
    		else {
    			System.out.println("Beyond RPA page Navigation Unsuccessful");
    		}
    	}else if(linkText.equalsIgnoreCase("Products")) {
    		boolean strProducts = getCurrentURL.equals("https://www.automationanywhere.com/products");
    		if(strProducts) {
    			System.out.println("Products page navigation successful");
    		}
    		else {
    			System.out.println("Products page Navigation Unsuccessful");
    		}
    	}else if(linkText.equalsIgnoreCase("Solutions")){
    		boolean strSolutions = getCurrentURL.equals("https://www.automationanywhere.com/solutions");
    		if(strSolutions) {
    			System.out.println("Solutions page navigation successful");
    		}
    		else {
    			System.out.println("Solutions page Navigation Unsuccessful");
    		}
    	}else if(linkText.equalsIgnoreCase("Company")) {
    		boolean strCompany = getCurrentURL.equals("https://www.automationanywhere.com/company/about-us");
    		if(strCompany) {
    			System.out.println("Company page navigation successful");
    		}
    		else {
    			System.out.println("Company page Navigation Unsuccessful");
    		}
    	}else if(linkText.equalsIgnoreCase("Resources")) {
    		boolean strResources = getCurrentURL.equals("https://www.automationanywhere.com/resources");
    		if(strResources) {
    			System.out.println("Resources page navigation successful");
    		}
    		else {
    			System.out.println("Resources page Navigation Unsuccessful");
    		}
    	}
       

        // Navigate back to the home page for the next link verification
        driver.navigate().back();

    	}
      }

