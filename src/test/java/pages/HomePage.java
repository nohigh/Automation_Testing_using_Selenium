package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By textHomePage = By.xpath("//*[@id='home-logged-message']");
    By textPaginaDeStart = By.xpath("/html/body/jhi-main/div[2]/div/jhi-home/div/div[2]/div/div[2]/span");
    By inregistrareButton = By.xpath("//*[@id='navbarResponsive']/ul/li[2]/ul/li[2]/a/span");
    By administrareButton = By.xpath("//*[@id='admin-menu']/span/span");
    By tabeleButton = By.xpath("//*[@id='entity-menu']/span/span");
    By acasaButton = By.xpath("//*[@id='navbarResponsive']/ul/li[1]/a");
    By departamentTableButton = By.xpath("//*[@id='navbarResponsive']/ul/li[2]/ul/li[1]/a/span");
    By programStudiuTableButton = By.xpath("//*[@id='navbarResponsive']/ul/li[2]/ul/li[2]/a/span");
    By cadruDidacticTableButton = By.xpath("//*[@id='navbarResponsive']/ul/li[2]/ul/li[3]/a/span");
    By studentTableButton = By.xpath("//*[@id='navbarResponsive']/ul/li[2]/ul/li[4]/a/span");
    By gestiuneUtilizatoriButton = By.xpath("//*[@id='navbarResponsive']/ul/li[3]/ul/li[1]/a");
    By contSetariButton = By.xpath("//*[@id='navbarResponsive']/ul/li[4]/ul/li[1]/a/span");

    public String getTextHomePage(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(textHomePage));
        return driver.findElement(textHomePage).getText();
    }

    public String getTextPaginaDeStart() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(textPaginaDeStart));
        return driver.findElement(textPaginaDeStart).getText();
    }

    public void clickInregistrareButton(){
        driver.findElement(inregistrareButton).click();
    }

    public void clickAdministrareButton(){
        driver.findElement(administrareButton).click();
    }

    public void clickGestiuneUtilizatoriButton() {
        driver.findElement(gestiuneUtilizatoriButton).click();
    }

    public void clickTabeleButton() {
        driver.findElement(tabeleButton).click();
    }

    public void clickDepartmentTableButton() {
        driver.findElement(departamentTableButton).click();
    }
    public void clickProgramStudiuTableButton() {
        driver.findElement(programStudiuTableButton).click();
    }

    public void clickCadruDidacticTableButton() {
        driver.findElement(cadruDidacticTableButton).click();
    }

    public void clickStudentTableButton() {
        driver.findElement(studentTableButton).click();
    }

    public void clickContSetariButton() {
        driver.findElement(contSetariButton).click();
    }
    public void clickAcasaButton() {
        driver.findElement(acasaButton).click();
    }
}
