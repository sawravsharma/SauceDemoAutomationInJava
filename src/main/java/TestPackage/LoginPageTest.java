package TestPackage;

import TestBasePackage.TestBase;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    @Test
    public void loginDetails() throws InterruptedException {
        pageFactory.getLoginPage().login();
    }
}
