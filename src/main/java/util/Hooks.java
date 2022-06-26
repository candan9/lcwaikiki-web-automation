package util;

import io.cucumber.java.*;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import java.util.Properties;


public class Hooks {

    WebDriver driver;
    Properties properties;
    @Before
    public void before() {
        Log4j.startLog();
        String browser="";
        try{
            browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        }catch (Exception e){
        }
        if(browser==null){
            browser="Chrome";
        }

        properties = ConfigReader.initialize_Properties();
        driver = DriverFactory.initialize_Driver(browser);
    }
    @BeforeStep
    public void beforeStep() {
    }

    @SneakyThrows
    @AfterStep
    public void afterStep(){
        Thread.sleep(1000);
    }

    @After
    public void after() {
        Log4j.endLog();
        driver.quit();
    }
}
