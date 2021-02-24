package actions;
import org.openqa.selenium.WebDriver;
import pages.GestiuneUtilizatoriPage;
import pages.HomePage;

public class GestiuneUtilizatoriActions {
    public WebDriver driver;

    public GestiuneUtilizatoriActions(WebDriver driver) {
        this.driver = driver;
    }

    public void gestiuneUtilizatoriBar() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAdministrareButton();
        homePage.clickGestiuneUtilizatoriButton();
    }

    public void gestiuneUtilizatoriActivare() {
        GestiuneUtilizatoriPage gestiuneUtilizatoriPage = new GestiuneUtilizatoriPage(driver);
        gestiuneUtilizatoriPage.clickDezactivatButton();
    }

    public void gestiuneUtilizatoriEditare() {
        GestiuneUtilizatoriPage gestiuneUtilizatoriPage = new GestiuneUtilizatoriPage(driver);
        gestiuneUtilizatoriPage.setAdminRole();
    }

    public void gestiuneUtilizatoriStergereUser() {
        HomePage homePage = new HomePage(driver);
        GestiuneUtilizatoriPage gestiuneUtilizatoriPage = new GestiuneUtilizatoriPage(driver);
        homePage.clickAdministrareButton();
        homePage.clickGestiuneUtilizatoriButton();
        gestiuneUtilizatoriPage.deleteUser();

    }

}
