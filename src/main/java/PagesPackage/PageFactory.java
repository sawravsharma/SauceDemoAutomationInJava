package PagesPackage;

import static TestBasePackage.TestBase.driver;

public class PageFactory {

    private LoginPage loginPage;
    private HomePage homePage;

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public HomePage getProductDetails(){
        if (homePage == null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }
}
