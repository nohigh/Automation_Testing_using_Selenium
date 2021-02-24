package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    public WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    By inregistrareTitlu = By.xpath("/html/body/jhi-main/div[2]/div/jhi-register/div/div[1]/div/h1");
    By utilizatorField = By.name("login");
    By emailField = By.xpath("//*[@id='email']");
    By parolaField = By.xpath("//*[@id='password']");
    By confirmareParolaField = By.xpath("//*[@id='confirmPassword']");
    By inregistrareButton = By.xpath("/html/body/jhi-main/div[2]/div/jhi-register/div/div[2]/div/form/button");
    By inregistrareSalvataText = By.xpath("/html/body/jhi-main/div[2]/div/jhi-register/div/div[1]/div/div");

    public String getInregistrareTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(inregistrareTitlu));
        return driver.findElement(inregistrareTitlu).getText();
    }

    public void enterUtilizator(String utilizator) {
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(utilizatorField));
        driver.findElement(utilizatorField).sendKeys(utilizator);

    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterParola(String parola) {
        driver.findElement(parolaField).sendKeys(parola);
    }
    public void enterConfirmareParola(String confirmareParola){
        driver.findElement(confirmareParolaField).sendKeys(confirmareParola);
    }

    public void clickInregistrareButton(){
        driver.findElement(inregistrareButton).click();
    }

    public String getInregistrareSalvataText() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(inregistrareSalvataText));
        return driver.findElement(inregistrareSalvataText).getText();
    }
}
