package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.security.Key;
import java.time.Duration;

public class ActionPage extends TestBase {

    @FindBy(xpath = "//a[text()='Actions']")
    WebElement actionlink;

    @FindBy(xpath = "//div[@class='droptarget'][1]")
    WebElement Dragme;

    @FindBy(xpath = "//div[@class='droptarget'][2]")
    WebElement Drop;

    @FindBy(xpath = "//div[@id='click-box']")
    WebElement clickhold;

    @FindBy(xpath = "//p[text()='Double-click this area below to trigger a function:']/following::div[@id='doubleClickArea'and @ondblclick='myFunction()']")
    WebElement doubleclick;
    @FindBy(xpath = "//p[text()='Click the button below while holding the shift key:']/following::div[@id='doubleClickArea']")
    WebElement holdshift;
    public ActionPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public void clickaction() {
        actionlink.click();
    }

    public void dragme() throws InterruptedException {
        Actions action = new Actions(driver);
        action.dragAndDrop(Dragme, Drop).perform();
        Thread.sleep(15000);
    }

    public String getTargetElementText() {
return Drop.getText();
    }
    public Point getDraggableElementText(){
        return Dragme.getLocation();
    }
    public String DraggableElementtext(){
        return Dragme.getText();
    }

    public void clickandhold(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(clickhold));
        Actions act=new Actions(driver);
        act.clickAndHold(clickhold).perform();


    }
    public void releasemouse() throws InterruptedException {
        Actions release=new Actions(driver);
        release.clickAndHold(clickhold).release(clickhold).perform();
        Thread.sleep(15000);
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
    public String clickholdmessage(){
     return clickhold.getText();
    }

    public void doubleclickaction(){
        Actions actions=new Actions(driver);
        actions.doubleClick(doubleclick).release().perform();
    }
    public String doubleclickmessage(){
        return doubleclick.getText();
    }
public void holdshift(){
        Actions act=new Actions(driver);
        act.keyDown(Keys.SHIFT)
                .click(holdshift)
                .keyUp(Keys.SHIFT)
                .perform();

}

public String shiftmessage(){
        return  holdshift.getText();
}
    }





