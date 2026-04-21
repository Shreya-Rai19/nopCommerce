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

	       cart.goToCart();
	       
	       int count = cart.getItemCount();
	       System.out.println("Item Count: "+count);

	       cart.removeTwoItems();


	       int after = cart.getItemCount();
	       System.out.println("After Remove: " + after);

	     //  Assert.assertEquals(after, count - 2);
	       

	       
	}

}
