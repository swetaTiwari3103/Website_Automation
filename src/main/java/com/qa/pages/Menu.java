package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Menu extends TestBase {

    @FindBy(xpath = "//div[@id='sidebar']/descendant::a[@class='toggle']")
    WebElement link;

    public Menu() throws IOException {
        if(TestBase.driver==null){
            throw new IllegalStateException("Webdriver has not been initialized");
        }
        PageFactory.initElements(TestBase.driver, this);
    }

    public void clickMenu() throws InterruptedException {
        Thread.sleep(5000);
        link.click();
        Thread.sleep(5000);

    }
}


