package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Robot_class
{
	public static WebDriver driver;
	
	@Given("user is able to enter the url and launch naukari application")
	public void user_is_able_to_enter_the_url_and_launch_naukari_application() {
	    try {
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://www.naukri.com/registration/createAccount?othersrcp=23531&wExp=N&utm_source=google&utm_medium=cpc&utm_campaign=Brand&gclid=EAIaIQobChMIm-H64-Gv_AIVzp1LBR0zbQRKEAAYAiAAEgKys_D_BwE&gclsrc=aw.ds");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	        WebElement UploadButton = driver.findElement(By.xpath("//button[contains(.,'Upload Resume')]"));
	        UploadButton.click();
	        Thread.sleep(1000);

	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle or log the exception as per your application's error handling strategy
	    }
	}
	@Then("perform Actions using robot class")
	
	public void perform_actions_using_robot_class() throws Exception {
	
	
		//This syntax will copy string into clipboard
		String path="C:\\Users\\Praveen Anumula\\Documents\\Ramesh resume.docx";
		StringSelection spath=new StringSelection(path);
		Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(spath, spath);

		//Create object for robot
		
		Robot robot=new Robot();
		robot.setAutoDelay(400);
		
		//Pressing Control+V Shortcut
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		//Press Enter key
		robot.keyPress(KeyEvent.VK_ENTER);
	
	}

}
