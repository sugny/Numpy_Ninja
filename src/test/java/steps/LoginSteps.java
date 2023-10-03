package steps;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class LoginSteps {
	public ChromeDriver driver;

	@Given("Open the chrome browser - maximize and set the timeout")
	public void setupBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@And("Load the application url {string}")
	public void loadURL(String url) {
		driver.get(url);
	}

	@And("Enter username as {string}")
	public void enterUsername(String userID) {
		driver.findElement(By.id("username")).sendKeys(userID);
	}

	@And("Enter password as {string}")
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("Login button is clicked")
	public void clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("verify the user logged-in successfully")
	public void verifySuccessMessage() {
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

	}

	@And("get all the tab name")
	public void get_all_the_tab_name() {
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
	}

	@Then("dataTable")
	public void data_table(DataTable dataTable) {
		List<String> asLists = dataTable.asList();
		String[] arrExpected = asLists.get(0).split(",");
		String[] arrActual = driver.findElement(By.className("x-grid3-hd-row")).getText().split("\\n");
		// System.out.println("************"+actualText);
		
		List<WebElement> eleMenu = driver.findElements(By.className("x-grid3-hd-row"));
		
		assertEquals(arrExpected, arrActual);
		String[] text;
		System.out.println(eleMenu.size());
		for(int i=0;i<arrExpected.length;i++ ) {
			text = eleMenu.get(i).getText().split("\\n");
			System.out.println("***********"+text[i]);
		}
	}

}