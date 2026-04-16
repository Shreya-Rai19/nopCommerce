package test;

import org.testng.annotations.Test;

import utils.DriverManager;

public class AddToCartTest extends DriverManager{
	@Test
	public void addTest() throws InterruptedException
	{
		addtocart.selectApparel();
		addtocart.selectElectronics();
		addtocart.selectBooks();
		addtocart.displayCart();
		Thread.sleep(2000);
	}

}
