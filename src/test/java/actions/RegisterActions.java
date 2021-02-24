package actions;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterActions {
    public WebDriver driver;

    public RegisterActions(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegisterUserButton() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.clickContButton();
        homePage.clickInregistrareButton();
    }

    public void registerUser(String utilizator, String email, String parola, String confirmareParola) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterUtilizator(utilizator);
        registerPage.enterEmail(email);
        registerPage.enterParola(parola);
        registerPage.enterConfirmareParola(confirmareParola);
        registerPage.clickInregistrareButton();
    }
}
