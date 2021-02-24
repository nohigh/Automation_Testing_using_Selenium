package actions;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SetariPage;

public class SetariActions {
    public WebDriver driver;

    public SetariActions(WebDriver driver) {
        this.driver = driver;
    }

    public void changeNumePrenume(String prenume, String nume) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SetariPage setariPage = new SetariPage(driver);
        loginPage.clickContButton();
        homePage.clickContSetariButton();
        setariPage.enterPrenume(prenume);
        setariPage.enterNume(nume);
    }
}
