package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class CheckingAttendence {
    WebDriver driver;
    @Given("MIST Student log in page")
    public void mistStudentLogInPage() throws InterruptedException {
        ChromeOptions options = new ChromeOptions(); //
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Integer> contentSettings = new HashMap<String, Integer>();
        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://student.mist.ac.bd/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        
    }

    @When("Student input {string} and {string}")
    public void studentInputStudentIDAndPassword(String StudentID, String password) {
        driver.findElement(By.xpath("(//input)[1]")).sendKeys(StudentID);
        driver.findElement(By.xpath("(//input)[2]")).sendKeys(password);

        
    }

    @And("click on the log in button")
    public void clickOnTheLogInButton() throws InterruptedException {

        driver.findElement(By.xpath("//button[@class=\"MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root w-full mx-auto mt-16 muiltr-y5iv2g\"]")).click();
        Thread.sleep(3000);
    }

    @And("Click on the Running Courses")
    public void clickOnTheRunningCourses() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//span[@class=\"material-icons notranslate MuiIcon-root MuiIcon-fontSizeMedium muiltr-1cpc5a8\"])[5]")).click();

    }

    @And("Click on Course")
    public void clickOnCourse() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//div[@class=\"MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-4 muiltr-19egsyp\"])[2]")).click();
        Thread.sleep(2000);
    }

    @And("Click on attendance")
    public void clickOnAttendance() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//div[text()=\"attendances\"])")).click();
        Actions actions = new Actions(driver);
        // Scroll down the page
        actions.sendKeys(Keys.PAGE_DOWN);
        actions.build().perform();
        Thread.sleep(2000);
    }


    @Then("log out from this page")
    public void logOutFromThisPage() {
        driver.quit();
    }



}
