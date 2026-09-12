package VirtusaTesting.VirtusaTesting_artifact;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Registration_tutorialninja {
    
    private WebDriver driver;
    private RegistrationPageObject registrationPage;
    
    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        registrationPage = new RegistrationPageObject(driver);
        System.out.println("✓ Browser launched!");
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("✓ Browser closed!");
        }
    }
    
    @Test
    public void testSignUp() {
        System.out.println("\n====== Starting Sign Up Test ======");
        
        try {
            registrationPage.navigateToRegistrationPage();
            System.out.println("✓ Navigated to Registration Page");
            
            registrationPage.waitForPageLoad();
            System.out.println("✓ Registration form loaded");
            
            String uniqueEmail = "rohit.singh" + System.currentTimeMillis() + "@example.com";
            registrationPage.fillRegistrationForm("Rohit", "Singh", uniqueEmail, "9876543210", "Test@12345");
            System.out.println("✓ Filled registration form");
            
            registrationPage.submitFormWithoutNewsletter();
            System.out.println("✓ Submitted form");
            
            Thread.sleep(3000);
            String pageTitle = registrationPage.getPageTitle();
            String currentUrl = registrationPage.getCurrentUrl();
            System.out.println("✓ Page Title: " + pageTitle);
            System.out.println("✓ Current URL: " + currentUrl);
            
            Assert.assertTrue(registrationPage.isPageHeadingDisplayed(), "Should display success page");
            Assert.assertTrue(currentUrl.contains("success"), "URL should contain 'success'");
            System.out.println("✓ Registration Successful!");
            System.out.println("====== Sign Up Test PASSED ======\n");
            
        } catch (Exception e) {
            System.out.println("✗ Sign Up Test FAILED: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Sign up test failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testSignUpWithNewsletterSubscription() {
        System.out.println("\n====== Starting Sign Up With Newsletter Test ======");
        
        try {
            registrationPage.navigateToRegistrationPage();
            System.out.println("✓ Navigated to Registration Page");
            
            registrationPage.waitForPageLoad();
            
            String uniqueEmail = "rahul.kumar" + System.currentTimeMillis() + "@example.com";
            registrationPage.fillRegistrationForm("Rahul", "Kumar", uniqueEmail, "9876543210", "Test@12345");
            System.out.println("✓ Filled all form fields");
            
            registrationPage.submitFormWithNewsletter();
            System.out.println("✓ Submitted Registration Form");
            
            Thread.sleep(3000);
            Assert.assertTrue(registrationPage.isPageHeadingDisplayed(), "Should display success page");
            System.out.println("✓ Registration with Newsletter Successful!");
            System.out.println("====== Sign Up With Newsletter Test PASSED ======\n");
            
        } catch (Exception e) {
            System.out.println("✗ Sign Up With Newsletter Test FAILED: " + e.getMessage());
            Assert.fail("Sign up with newsletter test failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testSignUpValidation() {
        System.out.println("\n====== Starting Sign Up Validation Test ======");
        
        try {
            registrationPage.navigateToRegistrationPage();
            System.out.println("✓ Navigated to Registration Page");
            
            registrationPage.waitForPageLoad();
            
            registrationPage.enterFirstName("Rohit");
            registrationPage.clickContinueButton();
            System.out.println("✓ Submitted form with incomplete fields");
            
            Thread.sleep(2000);
            String pageSource = registrationPage.getPageSource();
            
            Assert.assertTrue(pageSource.contains("First Name") || pageSource.contains("input-firstname"),
                    "Form should still be visible with validation errors");
            
            System.out.println("✓ Form validation working correctly");
            System.out.println("====== Sign Up Validation Test PASSED ======\n");
            
        } catch (Exception e) {
            System.out.println("✗ Sign Up Validation Test FAILED: " + e.getMessage());
            Assert.fail("Sign up validation test failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testDirectRegistrationPageAccess() {
        System.out.println("\n====== Starting Direct Registration Page Access Test ======");
        
        try {
            registrationPage.navigateToRegistrationPage();
            System.out.println("✓ Navigated to Registration Page");
            
            registrationPage.waitForPageLoad();
            
            String pageTitle = registrationPage.getPageTitle();
            System.out.println("✓ Page Title: " + pageTitle);
            
            Assert.assertTrue(registrationPage.isFirstNameFieldDisplayed(), "First Name field should be visible");
            Assert.assertTrue(registrationPage.isLastNameFieldDisplayed(), "Last Name field should be visible");
            Assert.assertTrue(registrationPage.isEmailFieldDisplayed(), "Email field should be visible");
            Assert.assertTrue(registrationPage.isTelephoneFieldDisplayed(), "Telephone field should be visible");
            Assert.assertTrue(registrationPage.isPasswordFieldDisplayed(), "Password field should be visible");
            Assert.assertTrue(registrationPage.isConfirmPasswordFieldDisplayed(), "Confirm Password field should be visible");
            System.out.println("✓ All form fields are present and visible");
            
            Assert.assertTrue(registrationPage.isContinueButtonDisplayed(), "Continue button should be visible");
            System.out.println("✓ Continue button is present");
            
            System.out.println("====== Direct Registration Page Access Test PASSED ======\n");
            
        } catch (Exception e) {
            System.out.println("✗ Direct Registration Page Access Test FAILED: " + e.getMessage());
            Assert.fail("Direct registration page access test failed: " + e.getMessage());
        }
    }
}
