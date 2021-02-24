package actions;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginActions {
    public WebDriver driver;


    public LoginActions(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickContButton();
        loginPage.clickAutentificareButton();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickCheckbox();
        loginPage.clickAutentificareButtonDupaIntroducereDate();
    }
}
