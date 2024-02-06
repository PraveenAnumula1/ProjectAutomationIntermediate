package stepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Ajax_call {

private String URL = "https://demo.guru99.com/test/ajax.html";
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("user is able to enter the url and launch application")
	public void user_is_able_to_enter_the_url_and_launch_application() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}

	@Then("perform Ajaxcall operation")
	public void perform_ajaxcall_operation() {
		By container = By.cssSelector(".container");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(container));
		
		//Get the text before performing an ajax call
		WebElement noTextElement = driver.findElement(By.className("radiobutton"));
		String textBefore = noTextElement.getText();
		
		//Click on the radio button
		driver.findElement(By.id("yes")).click();
	
		//Click on Check Button
		driver.findElement(By.id("buttoncheck")).click();
		
		//Get the text after Ajax call
		WebElement TextElement = driver.findElement(By.className("radiobutton"));
		wait.until(ExpectedConditions.visibilityOf(TextElement));
		String textAfter = TextElement.getText();
		
		//Verify both texts before Ajax call and after Ajax call text are not equal
		Assert.assertNotEquals(textBefore, textAfter);
		
		System.out.println("Ajax Call Performed");
		
		String expectedText = "Radio button is checked and it's value is Yes";
		
		//Verify expected text with text updated after ajax call
		Assert.assertEquals(textAfter, expectedText);
		driver.close();
	}
  
	}


