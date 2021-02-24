package pages;
import org.apache.poi.ss.usermodel.DataFormatter;
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

public class ProgramStudiuPage {
    public WebDriver driver;

    public ProgramStudiuPage(WebDriver driver) {
        this.driver = driver;
    }

    By creareProgramStudiuButton = By.xpath("//*[@id='jh-create-entity']");
    By numeProgramStudiuField = By.xpath("//*[@id='field_program']");
    By departamentDropdownField = By.xpath("//*[@id='field_departament']");
    By salvareProgramStudiuButton = By.xpath("//*[@id='save-entity']");
    By stergereButton = By.xpath("/html/body/jhi-main/div[2]/div/jhi-program-studiu/div/div/table/tbody/tr[1]/td[4]/div/button[3]");
    By confirmareStergereButton = By.xpath("//*[@id='jhi-confirm-delete-programStudiu']");
    By stergereAlert =  By.xpath("/html/body/jhi-main/div[2]/div/jhi-program-studiu/div/jhi-alert/div/div/ngb-alert");
    By noProgramStudiuMessage = By.xpath("/html/body/jhi-main/div[2]/div/jhi-program-studiu/div/div[1]");

    public void creareProgramStudiu() throws InterruptedException, IOException {
        ArrayList<String> numeProgramStudiu = readExcelData(0);
        ArrayList<String> numeDepartament = readExcelData(1);

        for(int i=0;i<numeProgramStudiu.size();i++) {
            Thread.sleep(200);
            driver.findElement(creareProgramStudiuButton).click();
            driver.findElement(numeProgramStudiuField).sendKeys(numeProgramStudiu.get(i));
            driver.findElement(departamentDropdownField).click();
            driver.findElement(departamentDropdownField).sendKeys(numeDepartament.get(i));
            driver.findElement(salvareProgramStudiuButton).click();
        }
    }

    public ArrayList<String> readExcelData(int colNo) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Licenta\\Excel_FSEGA.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet s = wb.getSheet("Program studiu");
        Iterator<Row> rowIterator = s.iterator();
        rowIterator.next();
        ArrayList<String> list = new ArrayList<String>();
        DataFormatter formatter = new DataFormatter();
        while(rowIterator.hasNext()) {
            String val = formatter.formatCellValue(rowIterator.next().getCell(colNo));
            list.add(val);
        }
        return list;
    }

    public void stergereProgramStudiu() {
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(noProgramStudiuMessage));

    }
}
