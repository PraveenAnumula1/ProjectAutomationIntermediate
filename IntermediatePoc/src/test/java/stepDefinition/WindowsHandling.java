package stepDefinition;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WindowsHandling {
	
	public static WebDriver driver;
	@Given("user is able to enter the url and launch the Naukari application")
	
	public void user_is_able_to_enter_the_url_and_launch_the_naukari_application() {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		
		driver.get("http://www.naukri.com/");
		
	}

	@Then("perform Windows handling operation")
	
	public void perform_windows_handling_operation() {
		
		        WebDriver driver = new ChromeDriver();
		        
		// It will return the parent window name as a String
				String parent=driver.getWindowHandle();

				Set<String>s=driver.getWindowHandles();

				// Now iterate using Iterator
				Iterator<String> I1= s.iterator();

				while(I1.hasNext())
			
				{

				String child_window=I1.next();


				if(!parent.equals(child_window))
				{
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();
				}

				}
				//switch to the parent window
				driver.switchTo().window(parent);

				}
				
		
	}



