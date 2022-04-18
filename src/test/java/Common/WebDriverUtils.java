package Common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverUtils {
//    init webdriver
    public static void initDriver(){
        switch (Constant.BROWSER.toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "Executables/driver/chromedriver.exe");
                Constant.DRIVER = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "Executables/driver/geckodriver.exe");
                Constant.DRIVER = new FirefoxDriver();
                break;
        }
        Constant.DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Constant.DRIVER.manage().window().maximize();
    }

//    navigate to 'URL'
    public static void navigate(String URL){
        Constant.DRIVER.get(URL);
    }

//    exit
    public static void quitBrowser(){
        Constant.DRIVER.quit();
    }
}
