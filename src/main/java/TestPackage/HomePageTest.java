package TestPackage;

import TestBasePackage.TestBase;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    @Test
    public void productDetails() throws InterruptedException {
        pageFactory.getLoginPage().login();
        pageFactory.getProductDetails().addProductsInCart();
        pageFactory.getProductDetails().logOut();
    }

    @Test
    public void productDetailsList() throws InterruptedException {
        pageFactory.getLoginPage().login();
        pageFactory.getProductDetails().getProducts();
        pageFactory.getProductDetails().logOut();
    }
}
