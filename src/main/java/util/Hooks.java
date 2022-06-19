package util;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import java.util.Properties;

public class Hooks {

    WebDriver driver;
    Properties properties;
    @Before
    public void before() {
        Log4j.startLog();
       /* String browser="";
        try{*/
          String  browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");

        /*}catch (Exception e){
        }
        if(browser==null){
            browser="Chrome";
        }*/

        properties = ConfigReader.initialize_Properties();
        driver = DriverFactory.initialize_Driver(browser);
    }
    @BeforeStep
    public void beforeStep() {
    }

    @AfterStep
    public void afterStep() {
    }

    @After
    public void after() {
        Log4j.endLog();
        driver.quit();
    }
}
