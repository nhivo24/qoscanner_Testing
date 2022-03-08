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

public class ForgotPass {
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
	public void TC_01_Forgot_Valid_Email() {
		driver.get("http://qoscanner.site/forgot");
		driver.findElement(By.id("email")).sendKeys("vothinhi2410@gmail.com");
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[text()=' Gửi mật khẩu mới '] ")).click();
		sleepInSecond(2);
		// kiểm tra dữ liệu trả về đúng/sai
		// Assert.assertFalse(false);
		// Assert.assertTrue(true);
		// Verify error message as expected
		Assert.assertEquals(driver
				.findElement(By.xpath("//div[contains(text(),'Xác thực lấy lại mật khẩu đã được gửi tới Email củ')]"))
				.getText(), "Xác thực lấy lại mật khẩu đã được gửi tới Email của bạn. Vui lòng kiểm tra.");
	}
	@Test
	public void TC_02_Forgot_Invalid_Email() {
		driver.get("http://qoscanner.site/forgot");
		driver.findElement(By.id("email")).sendKeys("nhivo@gmail.com");
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[text()=' Gửi mật khẩu mới '] ")).click();
		sleepInSecond(2);
		// kiểm tra dữ liệu trả về đúng/sai
		// Assert.assertFalse(false);
		// Assert.assertTrue(true);
		// Verify error message as expected
		Assert.assertEquals(driver
				.findElement(By.xpath("//div[contains(text(),'Tài khoản Email không đúng. Vui lòng thử lại bằng ')]"))
				.getText(), "Tài khoản Email không đúng. Vui lòng thử lại bằng Email khác!");
	}

	@Test
	public void TC_03_Forgot_Empty_Email() {
		sleepInSecond(2);
		driver.get("http://qoscanner.site/forgot");
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.xpath("//button[text()=' Gửi mật khẩu mới '] ")).click();
		sleepInSecond(2);

		// kiểm tra dữ liệu trả về đúng/sai
		// Assert.assertFalse(false);
		// Assert.assertTrue(true);
		// Verify error message as expected
		Assert.assertEquals(driver.findElement(By.id("email-helper-text")).getText(), "Nhập một địa chỉ Email");
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
