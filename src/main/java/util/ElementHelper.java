package util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ElementHelper {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.action = new Actions(driver);
    }

    /**
     * @param key
     * @return
     */
    public WebElement findElementEnable(By key) {
        Log4j.info("finding"+key.toString());
        List<WebElement> elements = presenceElements(key);
        WebElement elementHold = null;
        boolean find;
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                return element;
            }
        }
        return elementHold;
    }

    /**
     * @param key
     */
    public WebElement findElement(By key) {

        WebElement element = presenceElement(key);
        Log4j.info("finding"+key.toString());
        return element;
    }
    /**
     * @param key
     * @return
     */
    public List<WebElement> findElements(By key) {
        Log4j.info("finding"+key.toString());
        List<WebElement> elements = presenceElements(key);
        scrollToElement(elements.get(0));
        return elements;
    }

    /**
     * @param key
     */
    public void click(By key) {
        Log4j.info("clicking"+key.toString());
        StaleElementHandleByClassName(key);
    }

    /**
     * @param key
     */
    public void StaleElementHandleByClassName (By key)
    {
        int count = 0;
        boolean clicked = false;
        while (count < 4 && !clicked)
        {
            try
            {
                WebElement yourSlipperyElement= driver.findElement(key);
                yourSlipperyElement.click();
                clicked = true;
            }
            catch (StaleElementReferenceException e)
            {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count+1;
            }
        }
    }
    /**
     * @param key
     * @param text
     */
    public void sendKey(By key, String text) {
        Log4j.info("typing "+text+" into "+key.toString());
        findElement(key).sendKeys(text);
    }

    /**
     * @param key
     * @return
     */
    public String getText(By key) {
        Log4j.info("getting "+key.toString()+" text");
        return findElement(key).getText();
    }

    /**
     * @param key
     * @param text
     * @return
     */
    public boolean checkElementText(By key, String text) {
        Log4j.info("checking text of "+key.toString()+" element");
        return wait.until(ExpectedConditions.textToBe(key, text));
    }

    /**
     * @param key
     * @return
     */
    public boolean checkElementVisible(By key) {
        Log4j.info("checking visiblity of "+key.toString()+" element");
        wait.until(ExpectedConditions.presenceOfElementLocated(key));
        return true;
    }
    /**
     * @param key
     * @return
     */
    public boolean exist(By key){
        if(!driver.findElements(key).isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    /**
     *
     * @param key
     * @param value
     */
    public void selectValueOption(By key,String value) {
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(findElement(key))));
        dropdown.selectByValue(value);
    }

    /**
     * @param text
     * @return
     */
    public boolean checkTitle(String text) {
        return wait.until(ExpectedConditions.titleIs(text));
    }

    /**
     * @param key
     * @param attr
     * @return
     */
    public String getAttribute(By key, String attr) {
        Log4j.info("getting attribute of "+key.toString());
        return findElement(key).getAttribute(attr);
    }

    /**
     * @param key
     * @param attr
     * @param text
     */
    public void checkAttribute(By key, String attr, String text) {
        Log4j.info("checking attribute of "+key.toString());
        Assert.assertEquals(getAttribute(key, attr), text);
    }

    /**
     * @param key
     * @param text
     */
    public void clickElementWithText(By key, String text) {
        Log4j.info("clicking element "+key.toString()+"with "+text);
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.click();
                find = true;
                break;
            }
        }
        if(find==false){
            Log4j.error("element no found");
        }
        Assert.assertEquals(true, find);
    }

    /**
     * @param key
     * @param text
     */
    public void checkElementWithText(By key, String text) {
        Log4j.info("checking element "+key.toString()+"with "+text);
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                presenceElement(key);
                return;
            }
        }
    }

    /**
     *
     * @param key
     * @param text
     */
    public void focusElementWithText(By key, String text) {
        Log4j.info("focusing element "+key.toString()+"with "+text);
        boolean find=false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().equals(text)&&find==false) {
                presenceElement(key);
                action.moveToElement(element).build().perform();
                find=true;
                break;
            }
        }
        if(find==false){
            Log4j.error("element no found");
        }
        Assert.assertTrue(find);
    }

    /**
     * @param key
     * @param text
     * @param text2
     */
    public void sendKeyElementWithText(By key, String text, String text2) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.sendKeys(text2);
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    /**
     * @param key
     * @return
     */
    public WebElement presenceElement(By key) {
        Log4j.info("wait to presence element which "+key.toString());
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    /**
     *
     * @param key
     * @return
     */
    public void focusElement(By key) {
        Log4j.info("focusing element "+key.toString());
        new Actions(driver).moveToElement(findElement(key)).perform();
    }

    /**
     @param key
     @return
     */
    public WebElement findFirstElement(By key) {
        Log4j.info("finding first element of "+key.toString());
        List<WebElement> elements = presenceElements(key);
        WebElement element = elements.get(0);
        return element;
    }

    /**
     @param key
     @return
     */
    public WebElement findElementInElement(By key, String text,By secondKey) {
        Log4j.info("finding first element of "+key.toString());
        WebElement elementHold = null;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                elementHold=element;
                presenceElement(key);
                return element.findElement(secondKey);
            }
        }
        return elementHold;
    }

    /**
     * @param key
     * @return
     */
    public List<WebElement> presenceElements(By key) {
        Log4j.info("wait to presence elements list of "+key.toString());
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
    }

    /**
     * @param element
     */
    public void scrollToElement(WebElement element) {
        Log4j.info("Scroll to  "+element.getClass());
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);

    }
}
