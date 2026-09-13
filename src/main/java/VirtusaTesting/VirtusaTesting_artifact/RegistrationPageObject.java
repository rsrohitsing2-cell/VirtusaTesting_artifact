package VirtusaTesting.VirtusaTesting_artifact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class RegistrationPageObject {
    

     it is the commeting added to project
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String REMOTE_PAGE_URL = "https://tutorialsninja.com/demo/index.php?route=account/register";
    private static final String PAGE_URL = resolveDefaultPageUrl();

    private static String resolveDefaultPageUrl() {
        String override = System.getProperty("registration.page.url");
        if (override != null && !override.isBlank()) {
            return override;
        }
        Path localUi = Paths.get("src/main/resources/ui/register.html").toAbsolutePath();
        if (Files.exists(localUi)) {
            return localUi.toUri().toString();
        }
        return REMOTE_PAGE_URL;
    }
    
    private By firstNameField = By.id("input-firstname");
    private By lastNameField = By.id("input-lastname");
    private By emailField = By.id("input-email");
    private By telephoneField = By.id("input-telephone");
    private By passwordField = By.id("input-password");
    private By confirmPasswordField = By.id("input-confirm");
    private By newsletterYes = By.xpath("//input[@name='newsletter' and @value='1']");
    private By newsletterNo = By.xpath("//input[@name='newsletter' and @value='0']");
    private By agreeCheckbox = By.xpath("//input[@name='agree' and @value='1']");
    private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
    private By pageHeading = By.tagName("h1");
    
    public RegistrationPageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void navigateToRegistrationPage() {
        driver.navigate().to(PAGE_URL);
    }
    
    public void waitForPageLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(firstNameField));
    }
    
    public void enterFirstName(String firstName) {
        WebElement element = driver.findElement(firstNameField);
        element.clear();
        element.sendKeys(firstName);
    }
    
    public void enterLastName(String lastName) {
        WebElement element = driver.findElement(lastNameField);
        element.clear();
        element.sendKeys(lastName);
    }
    
    public void enterEmail(String email) {
        WebElement element = driver.findElement(emailField);
        element.clear();
        element.sendKeys(email);
    }
    
    public void enterTelephone(String telephone) {
        WebElement element = driver.findElement(telephoneField);
        element.clear();
        element.sendKeys(telephone);
    }
    
    public void enterPassword(String password) {
        WebElement element = driver.findElement(passwordField);
        element.clear();
        element.sendKeys(password);
    }
    
    public void enterConfirmPassword(String confirmPassword) {
        WebElement element = driver.findElement(confirmPasswordField);
        element.clear();
        element.sendKeys(confirmPassword);
    }
    
    public void selectNewsletterYes() {
        WebElement element = driver.findElement(newsletterYes);
        element.click();
    }
    
    public void selectNewsletterNo() {
        WebElement element = driver.findElement(newsletterNo);
        if (!element.isSelected()) {
            element.click();
        }
    }
    
    public void acceptPrivacyPolicy() {
        WebElement element = driver.findElement(agreeCheckbox);
        if (!element.isSelected()) {
            element.click();
        }
    }
    
    public void clickContinueButton() {
        WebElement element = driver.findElement(continueButton);
        element.click();
    }
    
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    public boolean isPageHeadingDisplayed() {
        try {
            return driver.findElement(pageHeading).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isFirstNameFieldDisplayed() {
        return driver.findElement(firstNameField).isDisplayed();
    }
    
    public boolean isLastNameFieldDisplayed() {
        return driver.findElement(lastNameField).isDisplayed();
    }
    
    public boolean isEmailFieldDisplayed() {
        return driver.findElement(emailField).isDisplayed();
    }
    
    public boolean isTelephoneFieldDisplayed() {
        return driver.findElement(telephoneField).isDisplayed();
    }
    
    public boolean isPasswordFieldDisplayed() {
        return driver.findElement(passwordField).isDisplayed();
    }
    
    public boolean isConfirmPasswordFieldDisplayed() {
        return driver.findElement(confirmPasswordField).isDisplayed();
    }
    
    public boolean isContinueButtonDisplayed() {
        return driver.findElement(continueButton).isDisplayed();
    }
    
    public String getPageSource() {
        return driver.getPageSource();
    }
    
    public void fillRegistrationForm(String firstName, String lastName, String email, String telephone, String password) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterTelephone(telephone);
        enterPassword(password);
        enterConfirmPassword(password);
    }
    
    public void submitFormWithoutNewsletter() {
        selectNewsletterNo();
        acceptPrivacyPolicy();
        clickContinueButton();
    }
    
    public void submitFormWithNewsletter() {
        selectNewsletterYes();
        acceptPrivacyPolicy();
        clickContinueButton();
    }
}
