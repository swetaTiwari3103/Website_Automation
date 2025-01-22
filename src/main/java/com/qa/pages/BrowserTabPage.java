package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BrowserTabPage extends TestBase {
    @FindBy(xpath = "//a[text()='Browser Tabs']")
    WebElement Browsertabs;
    @FindBy(xpath = "//input[@type='submit' and @value='Open Tab']")
    WebElement Opentab;
    public BrowserTabPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }
    public void clickbrowsertab(){
        Browsertabs.click();
    }
    public void opentab(){
        WebElement opentab=Opentab;
        if(Opentab.isEnabled()){
            Opentab.click();
        }
    }

}
