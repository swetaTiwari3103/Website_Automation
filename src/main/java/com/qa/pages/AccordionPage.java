package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static com.qa.base.TestBase.driver;

public class AccordionPage extends TestBase {
WebDriverWait wait;
    @FindBy(xpath = "//ul/li/a[contains(text(), 'Accordion')]")
    WebElement accordionlink;
    @FindBy(xpath = "//div[@id='wrapper']/div/a")
    WebElement hemburgermenu;

    @FindBy(xpath = "//header[@id='header']/a")
    WebElement text;


    public AccordionPage() throws IOException {
        super();

        PageFactory.initElements(driver, this);

    }

    public void click(){

        accordionlink.click();
    }

    public String getBeforehoverColor(){
        String beforehover=text.getCssValue("color");
        return Color.fromString(beforehover).asHex();
    }
    public void hover() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(text));
        wait.until(ExpectedConditions.elementToBeClickable(text));
        Actions action = new Actions(driver);
        action.moveToElement(text).perform();
         Thread.sleep(1500);

    }
    public String getAfterHoverColor(){
        String afterHover=text.getCssValue("color");
        return Color.fromString(afterHover).asHex();
    }
}
