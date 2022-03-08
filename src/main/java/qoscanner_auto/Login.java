package qoscanner_auto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Login_Valid_Email_Pass() {
		driver.get("http://qoscanner.site/login");
		driver.findElement(By.id("email")).sendKeys("vothinhi2410@gmail.com");
		sleepInSecond(2);
		driver.findElement(By.id("password")).sendKeys("vothinhi");
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[text()=' Đăng nhập '] ")).click();
		sleepInSecond(2);

		// kiểm tra dữ liệu trả về đúng/sai
		// Assert.assertFalse(false);
		// Assert.assertTrue(true);
		// Verify error message as expected
		Assert.assertEquals(driver.findElement(By.xpath("//main[contains(text(),'Orders')]")).getText(), "Orders");
	}

	@Test
	public void TC_02_Login_Empty_Data() {
		sleepInSecond(2);
		driver.get("http://qoscanner.site/login");
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[text()=' Đăng nhập '] ")).click();
		sleepInSecond(2);

		// kiểm tra dữ liệu trả về đúng/sai
		// Assert.assertFalse(false);
		// Assert.assertTrue(true);
		// Verify error message as expected
		Assert.assertEquals(driver.findElement(By.id("email-helper-text")).getText(), "Nhập một địa chỉ Email");
		Assert.assertEquals(driver.findElement(By.id("password-helper-text")).getText(), "Nhập mật khẩu");
	}

	@Test
	public void TC_03_Login_Empty_Email() {
		sleepInSecond(2);
		driver.get("http://qoscanner.site/login");
		driver.findElement(By.id("email")).sendKeys("");
		sleepInSecond(2);
		driver.findElement(By.id("password")).sendKeys("vothinhi");
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[text()=' Đăng nhập '] ")).click();
		sleepInSecond(2);

		// kiểm tra dữ liệu trả về đúng/sai
		// Assert.assertFalse(false);
		// Assert.assertTrue(true);
		// Verify error message as expected
		Assert.assertEquals(driver.findElement(By.id("email-helper-text")).getText(), "Nhập một địa chỉ Email");
	}

	@Test
	public void TC_04_Login_Empty_Pass() {
		sleepInSecond(2);
		driver.get("http://qoscanner.site/login");
		sleepInSecond(2);
		driver.findElement(By.id("email")).sendKeys("vothinhi2410@gmail.com");
		sleepInSecond(2);
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.xpath("//button[text()=' Đăng nhập '] ")).click();
		sleepInSecond(2);

		// kiểm tra dữ liệu trả về đúng/sai
		// Assert.assertFalse(false);
		// Assert.assertTrue(true);
		// Verify error message as expected
		Assert.assertEquals(driver.findElement(By.id("password-helper-text")).getText(), "Nhập mật khẩu");
	}

	@Test
	public void TC_05_Login_Incorrect_Email() {
		sleepInSecond(2);
		driver.get("http://qoscanner.site/login");
		sleepInSecond(2);
		driver.findElement(By.id("email")).sendKeys("nhivo@gmail.com");
		sleepInSecond(2);
		driver.findElement(By.id("password")).sendKeys("vothinhi");
		driver.findElement(By.xpath("//button[text()=' Đăng nhập '] ")).click();
		sleepInSecond(2);

		// kiểm tra dữ liệu trả về đúng/sai
		// Assert.assertFalse(false);
		// Assert.assertTrue(true);
		// Verify error message as expected
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException Ex) {
		}
		Assert.assertEquals(driver
				.findElement(By.xpath("//div[contains(text(),'Tài khoản Email không đúng. Vui lòng thử lại bằng ')]"))
				.getText(), "Tài khoản Email không đúng. Vui lòng thử lại bằng Email khác!");
	}

	@Test
	public void TC_06_Login_Incorrect_Pass() {
		sleepInSecond(2);
		driver.get("http://qoscanner.site/login");
		sleepInSecond(2);
		driver.findElement(By.id("email")).sendKeys("vothinhi2410@gmail.com");
		sleepInSecond(2);
		driver.findElement(By.id("password")).sendKeys("vothinhi2410");
		driver.findElement(By.xpath("//button[text()=' Đăng nhập '] ")).click();
		sleepInSecond(2);

		// kiểm tra dữ liệu trả về đúng/sai
		// Assert.assertFalse(false);
		// Assert.assertTrue(true);
		// Verify error message as expected
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException Ex) {
		}
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[contains(text(),'Mật khẩu của bạn không đúng!')]")).getText(),
				"Mật khẩu của bạn không đúng!");
	}

	@Test
	public void TC_07_Login_Password_Less_Than_8_Chars() {
		driver.get("http://qoscanner.site/login");
		sleepInSecond(2);
		driver.findElement(By.id("email")).sendKeys("vothinhi2410@gmail.com");
		sleepInSecond(2);
		driver.findElement(By.id("password")).sendKeys("vothi");
		driver.findElement(By.xpath("//button[text()=' Đăng nhập '] ")).click();
		sleepInSecond(2);

		// kiểm tra dữ liệu trả về đúng/sai
		// Assert.assertFalse(false);
		// Assert.assertTrue(true);
		// Verify error message as expected
		Assert.assertEquals(driver.findElement(By.id("password-helper-text")).getText(), "Sử dụng 8 ký tự trở lên");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 900);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
