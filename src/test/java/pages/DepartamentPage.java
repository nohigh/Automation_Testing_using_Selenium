package pages;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DepartamentPage {
    public WebDriver driver;

    public DepartamentPage(WebDriver driver) {
        this.driver = driver;
    }

    By creareDepartamentButton = By.xpath("//*[@id='jh-create-entity']");
    By numeDepartamentField = By.xpath("//*[@id='field_numeDepartament']");
    By salvareDepartamentButton = By.xpath("//*[@id='save-entity']");
    By stergereButton = By.xpath("/html/body/jhi-main/div[2]/div/jhi-departament/div/div[1]/table/tbody/tr[1]/td[3]/div/button[3]");
    By confirmareStergereButton = By.xpath("//*[@id='jhi-confirm-delete-departament']");
    By stergereAlert =  By.xpath("/html/body/jhi-main/div[2]/div/jhi-departament/div/jhi-alert/div/div/ngb-alert");
    By noDepartamentMessage = By.xpath("/html/body/jhi-main/div[2]/div/jhi-departament/div/div[1]");


    public void creareDepartament() throws InterruptedException, IOException {
        ArrayList<String> numeDepartament = readExcelData(0);

        for(int i=0;i<numeDepartament.size();i++) {
            Thread.sleep(200);
            driver.findElement(creareDepartamentButton).click();
            driver.findElement(numeDepartamentField).sendKeys(numeDepartament.get(i));
            driver.findElement(salvareDepartamentButton).click();
        }
    }

    public ArrayList<String> readExcelData(int colNo) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Licenta\\Excel_FSEGA.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet s = wb.getSheet("Departament");
        Iterator<Row> rowIterator = s.iterator();
        rowIterator.next();
        ArrayList<String> list = new ArrayList<String>();
        while(rowIterator.hasNext()) {
            list.add(rowIterator.next().getCell(colNo).getStringCellValue());
        }
        return list;
    }

    public void stergereDepartament() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        boolean verificator = driver.findElement(stergereButton) .isDisplayed();

        while(verificator){

            try {
                driver.findElement(stergereButton).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(confirmareStergereButton));
                driver.findElement(confirmareStergereButton).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(stergereAlert));
            }catch(Exception e) {
                verificator = false;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(noDepartamentMessage));

    }
}
