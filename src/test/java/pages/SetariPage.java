package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetariPage {
    public WebDriver driver;

    public SetariPage(WebDriver driver) {
        this.driver = driver;
    }

    By prenumeField = By.xpath("//*[@id='firstName']");
    By numeField = By.xpath("//*[@id='lastName']");
    By saveButton = By.xpath("/html/body/jhi-main/div[2]/div/jhi-settings/div/div/div/form/button");
    By setariSalvateAlert = By.xpath("/html/body/jhi-main/div[2]/div/jhi-settings/div/div/div/div");

    public void enterPrenume(String prenume) {

        driver.findElement(prenumeField).sendKeys(prenume);
    }
    public void enterNume(String nume) {
        driver.findElement(numeField).sendKeys(nume);
        driver.findElement(saveButton).click();
    }

    public String getSetariSalvateAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(setariSalvateAlert));
        return driver.findElement(setariSalvateAlert).getText();
    }

}
