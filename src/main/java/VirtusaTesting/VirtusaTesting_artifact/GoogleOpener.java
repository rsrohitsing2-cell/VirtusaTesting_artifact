package VirtusaTesting.VirtusaTesting_artifact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Class to open Google.com using Selenium WebDriver
 */
public class GoogleOpener {
    
    public static void main(String[] args) {
        openGoogle();
    }
    
    /**
     * Opens Google.com in Chrome browser
     */
    public static void openGoogle() {
        WebDriver driver = null;
        try {
            // Set up Chrome options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            
            // Initialize Chrome driver
            driver = new ChromeDriver(options);
            
            // Open Google.com
            driver.navigate().to("https://www.google.com");
            
            System.out.println("Successfully opened Google.com");
            System.out.println("Page title: " + driver.getTitle());
            
            // Keep the browser open for 5 seconds
            Thread.sleep(5000);
            
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.err.println("Error opening Google.com: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed successfully");
            }
        }
    }
}
