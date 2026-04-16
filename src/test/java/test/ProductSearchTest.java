package test;

import org.testng.annotations.Test;
import utils.DriverManager;

public class ProductSearchTest extends DriverManager {

    @Test
    public void searchProductTest() throws InterruptedException {

        String keyword = "Build";
        String keyword1= "pride";

        
        productsearch.enterSearchKeyword(keyword);
        productsearch.clickSearch();
        productsearch.enterSearchKeyword(keyword1);
        productsearch.clickSearch();
    }
}