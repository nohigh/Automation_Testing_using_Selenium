package actions;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LogoutActions {
    public WebDriver driver;

    public LogoutActions(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickContButton();
        loginPage.clickIesireButton();
    }
}
