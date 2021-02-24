package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    By contButton = By.xpath("//*[@id='account-menu']/span/span");
    By autentificareButton = By.xpath("//*[@id='login']/span");
    By usernameField = By.xpath("//*[@id='username']");
    By passwordField = By.xpath("//*[@id='password']");
    By checkboxRemember = By.xpath("//*[@id='rememberMe']");
    By autentificareButtonDupaIntroducereDate = By.xpath("/html/body/ngb-modal-window/div/div/jhi-login-modal/div[2]/div/div[2]/form/button");
    By iesireButton = By.xpath("//*[@id='logout']");

    public void clickContButton() {

        driver.findElement(contButton).click();
    }

    public void clickAutentificareButton () {

        driver.findElement(autentificareButton).click();
    }

    public void enterUsername(String userName) {

        driver.findElement(usernameField).sendKeys(userName);
    }

    public void enterPassword(String userPassword) {

        driver.findElement(passwordField).sendKeys(userPassword);
    }

    public void clickCheckbox() {

        driver.findElement(checkboxRemember).click();
    }

    public void clickAutentificareButtonDupaIntroducereDate() {
        driver.findElement(autentificareButtonDupaIntroducereDate).click();
    }

    public void clickIesireButton() {
        driver.findElement(iesireButton).click();
    }

}
