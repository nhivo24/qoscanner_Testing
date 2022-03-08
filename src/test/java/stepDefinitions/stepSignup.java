package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepSignup {
	WebDriver driver = null;
	
	@Given("User is on the sign up page")
	public void user_is_on_the_sign_up_page() {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://qoscanner.site/signup");
	}
	
	@Given("verify sign up page")
	public void verify_sign_up_page() throws Throwable {
		//verify the website address
		String signUpUrl = driver.getCurrentUrl();
		Assert.assertEquals(signUpUrl, "http://qoscanner.site/signup");
		//Verify the title of page
		String managementPageTitle = driver.getTitle();
		Assert.assertEquals(managementPageTitle, "React App");
		Thread.sleep(2*1000);
	}

	@When("user enter <username> and <email> and <password> and <repassword>")
	public void user_enter_username_and_email_and_password_and_repassword() throws Throwable {
		driver.findElement(By.id("name")).sendKeys("Trịnh Thị Thục Trưng");
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("trungtrinh01@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("12345678");
		Thread.sleep(1000);
		driver.findElement(By.id("repassword")).sendKeys("12345678");
		Thread.sleep(2*1000);
	}
	@When("user enter <username> and <in_email> and <password> and <repassword>")
	public void user_enter_username_and_in_email_and_password_and_repassword() throws Throwable {
		driver.findElement(By.id("name")).sendKeys("Trịnh Thị Thục Trưng");
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("trungtrinh.com");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("12345678");
		Thread.sleep(1000);
		driver.findElement(By.id("repassword")).sendKeys("12345678");
		Thread.sleep(2*1000);
	}

	@When("user enter <username> and <email> and <in_password> and <repassword>")
	public void user_enter_username_and_email_and_in_password_and_repassword() throws Throwable {
		driver.findElement(By.id("name")).sendKeys("Trịnh Thị Thục Trưng");
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("trungtrinh01@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("1234");
		Thread.sleep(1000);
		driver.findElement(By.id("repassword")).sendKeys("1234");
		Thread.sleep(2*1000);
	}

	@When("user enter <username> and <email> and <password> and <dif_repassword>")
	public void user_enter_username_and_email_and_password_and_dif_repassword() throws Throwable {
		driver.findElement(By.id("name")).sendKeys("Trịnh Thị Thục Trưng");
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("trungtrinh01@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("12345678");
		Thread.sleep(1000);
		driver.findElement(By.id("repassword")).sendKeys("123456789");
		Thread.sleep(2*1000);
	}
	@When("user enter and <email> and <password> and <repassword>")
	public void user_enter_and_email_and_password_and_repassword() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("trungtrinh@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("12345678");
		Thread.sleep(1000);
		driver.findElement(By.id("repassword")).sendKeys("12345678");
		Thread.sleep(2*1000);
	}

	@When("user enter and <username> and <password> and <repassword>")
	public void user_enter_and_username_and_password_and_repassword() throws Throwable {
		driver.findElement(By.id("name")).sendKeys("Trịnh Thị Thục Trưng");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("12345678");
		Thread.sleep(1000);
		driver.findElement(By.id("repassword")).sendKeys("12345678");
		Thread.sleep(2*1000);
	}

	@When("user enter and <username> and <email> and <repassword>") 
	public void user_enter_and_username_and_email_and_repassword() throws Throwable{
		driver.findElement(By.id("name")).sendKeys("Trịnh Thị Thục Trưng");
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("trungtrinh@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("repassword")).sendKeys("12345678");
		Thread.sleep(2*1000);
	}

	@When("user enter and <username> and <email> and <password>")
	public void user_enter_and_username_and_email_and_password() throws Throwable {
		driver.findElement(By.id("name")).sendKeys("Trịnh Thị Thục Trưng");
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("trungtrinh@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("12345678");
		Thread.sleep(2*1000);
	}


	@And("click on sign up button")
	public void click_on_sign_up_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),' Đăng ký ')]")).click();
		Thread.sleep(3*1000);
	}

	@Then("message is display")
	public void message_is_display() {
	    System.out.println("Successful execution!");
	    driver.quit();
	}

}
