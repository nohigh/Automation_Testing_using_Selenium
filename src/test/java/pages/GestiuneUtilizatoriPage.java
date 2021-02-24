package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GestiuneUtilizatoriPage {
    public WebDriver driver;

    public GestiuneUtilizatoriPage(WebDriver driver) {
        this.driver = driver;
    }

    By utilizatoriText = By.xpath("//*[@id='user-management-page-heading']");
    By dezactivatButton = By.xpath("(/html/body/jhi-main/div[2]/div/jhi-user-mgmt/div/div[1]/table/tbody/tr)[last()]/td[4]/button");
    //By dezactivatButton = By.xpath("/html/body/jhi-main/div[2]/div/jhi-user-mgmt/div/div[1]/table/tbody/tr[4]/td[4]/button");
    By activatButton = By.xpath("(/html/body/jhi-main/div[2]/div/jhi-user-mgmt/div/div[1]/table/tbody/tr)[last()]/td[4]/button");
    //By activatButton = By.xpath("/html/body/jhi-main/div[2]/div/jhi-user-mgmt/div/div[1]/table/tbody/tr[4]/td[4]/button");
    By editareButton = By.xpath("/html/body/jhi-main/div[2]/div/jhi-user-mgmt/div/div[1]/table/tbody/tr[4]/td[10]/div/button[2]");
    By roleAdminOption = By.xpath("/html/body/jhi-main/div[2]/div/jhi-user-mgmt-update/div/div/form/div[1]/div[8]/select");
    By salvareButton = By.xpath("/html/body/jhi-main/div[2]/div/jhi-user-mgmt-update/div/div/form/div[2]/button[2]/span");
    By profilRoleAdminText = By.xpath("/html/body/jhi-main/div[2]/div/jhi-user-mgmt/div/div[1]/table/tbody/tr[4]/td[6]/div[2]/span");
    By stergereUserButton = By.xpath("/html/body/jhi-main/div[2]/div/jhi-user-mgmt/div/div[1]/table/tbody/tr[4]/td[10]/div/button[3]");
    By confirmareStergereUserButton = By.xpath("/html/body/ngb-modal-window/div/div/jhi-user-mgmt-delete-dialog/form/div[3]/button[2]");



    public String getUtilizatoriText(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(utilizatoriText));
        return driver.findElement(utilizatoriText).getText();
    }

    public void clickDezactivatButton() {

        driver.findElement(dezactivatButton).click();
    }
    public String getActivatButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(activatButton));
        return driver.findElement(activatButton).getText();
    }

    public void setAdminRole() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        driver.findElement(editareButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(roleAdminOption));
        Select roleAdmin = new Select(driver.findElement(roleAdminOption));
        roleAdmin.selectByIndex(0);
        driver.findElement(salvareButton).click();

    }

    public String getRoleAdminText() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(profilRoleAdminText));
        return driver.findElement(profilRoleAdminText).getText();
    }

    public void deleteUser() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        driver.findElement(stergereUserButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmareStergereUserButton));
        driver.findElement(confirmareStergereUserButton).click();
    }
}
