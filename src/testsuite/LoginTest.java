package testsuite;
/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password is invalid!”
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username field type the username address to username field
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Enter password field type the password address to password field
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //Find the login button element and click
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //Find the errorMessage element and get the text
        String expectedText = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter username field type the username address to username field
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        //Enter password field type the password address to password field
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        // //Find the login button element and click
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //Find the errorMessage element and get the text
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals("Your username is invalid!", "Your username is invalid!");
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter username field type the username address to username field
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Enter password field type the password address to password field
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
        //Find the login button element and click
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //Find the errorMessage element and get the text
        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals("Your password is invalid!", "Your password is invalid!");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
