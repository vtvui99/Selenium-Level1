package Common;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestBase {
    @BeforeSuite
    @Parameters("browser")
    public void beforeSuite(@Optional("chrome") String browserName){
        Constant.BROWSER = browserName;
    }

    @BeforeMethod
    public void setUp() {
        WebDriverUtils.initDriver();
        WebDriverUtils.navigate(Constant.HOME_PAGE_URL);
    }

    @AfterMethod
    public void quit() { WebDriverUtils.quitBrowser(); }

    @DataProvider
    public Iterator<Object[]> getData() throws IOException, CsvValidationException {
        String path = "src/test/java/DataObjects/" + this.getClass().getSimpleName() + ".csv";
        Reader reader = new FileReader(path);
        CSVReader csvReader = new CSVReader(reader);
        List<Object[]> list = new ArrayList<>();
        String[] nextLine = csvReader.readNext();

        while (nextLine != null){
            Object[] objectLine = nextLine;
            list.add(objectLine);
            nextLine = csvReader.readNext();
        }

        Iterator<Object[]> data = list.listIterator();
        return data;
    }
}
