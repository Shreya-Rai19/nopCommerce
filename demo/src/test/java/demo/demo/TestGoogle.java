package demo.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import org.testng.Assert;

public class TestGoogle {
	@Test
	public void openGoogle() {
		System.setProperty("webdriver.edge.driver", "C:\\New folder\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com");
		 driver.findElement(By.name("q")).sendKeys("Selenium");
	        driver.findElement(By.name("q")).submit();
	        String title = driver.getTitle();
	        System.out.println("Page Title: " + title);
	        Assert.assertTrue(title.contains("Selenium"));
	        driver.quit();
	}
}
