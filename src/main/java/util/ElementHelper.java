package util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
        this.wait = new WebDriverWait(driver, 20);
        this.action = new Actions(driver);
    }

    /**
     * @param key
     * @return
     */
    public WebElement findElement(By key) {
        WebElement element = presenceElement(key);
        scrollToElement(element);
        return element;
    }

    /**
     * @param key
     * @return
     */
    public List<WebElement> findElements(By key) {
        List<WebElement> elements = presenceElements(key);
        scrollToElement(elements.get(0));
        return elements;
    }

    /**
     * @param key
     */
    public void click(By key) {
        //findElement(key).click();
        StaleElementHandleByClassName(key);
    }
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
        findElement(key).sendKeys(text);
    }

    /**
     * @param key
     * @return
     */
    public String getText(By key) {
        return findElement(key).getText();
    }

    /**
     * @param key
     * @param text
     * @return
     */
    public boolean checkElementText(By key, String text) {
        return wait.until(ExpectedConditions.textToBe(key, text));
    }

    /**
     * @param key
     */
    public void checkElementVisible(By key) {
        wait.until(ExpectedConditions.elementToBeClickable(findElement(key)));
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
        return findElement(key).getAttribute(attr);
    }

    /**
     * @param key
     * @param attr
     * @param text
     */
    public void checkAttribute(By key, String attr, String text) {
        Assert.assertEquals(getAttribute(key, attr), text);
    }

    /**
     * @param key
     * @param text
     */
    public void clickElementWithText(By key, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.click();
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    /**
     * @param key
     * @param text
     */
    public void checkElementWithText(By key, String text) {
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
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    /**
     *
     * @param key
     * @return
     */
    public void focusElement(By key) {
        new Actions(driver).moveToElement(findElement(key)).perform();
    }
    /**
     @param key
     @return
     */
    public WebElement findFirstElement(By key) {
        List<WebElement> elements = presenceElements(key);
        WebElement element = elements.get(0);
        return element;
    }
    /**
     * @param key
     * @return
     */
    public List<WebElement> presenceElements(By key) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));

    }

    /**
     * @param element
     */
    public void scrollToElement(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);

    }
}
