package com.qa.pages;

import com.qa.base.TestBase;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Dropdowncheckbox extends TestBase {

    @FindBy(xpath = "//a[text()='DropDown Checkbox Radio']")
    WebElement dropdown;

    @FindBy(xpath = "//input[@type='radio']/following-sibling::label")
    List<WebElement> radiotext;
    @FindBy(xpath = "//div/p[text()='Pick a number:']")
    WebElement text;
    @FindBy(xpath = "//input[@type='checkbox']/following-sibling::label")
    List<WebElement> checkboxes;

    @FindBy(className = "current-menu-item")
    List<WebElement> menu;

    public Dropdowncheckbox() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public void clickdropdown() {
        dropdown.click();
    }

    public void radiobuttonclick(String value) {
        for (WebElement ele : radiotext) {
            System.out.println("The text is of radiobutton " + ele.getText());
            if (ele.isEnabled() && ele.getText().equals(value)) {
                ele.click();
                System.out.println(ele.getText() + "is selected");

            }


        }
    }

    public WebElement checkbox(String chbox) {
        for (WebElement check : checkboxes) {
            String attributename = check.getAttribute("checked");
            System.out.println("The" + check.getText() + "with checked attribute" + attributename);
            if (check.getText().equals(chbox)) {
                // If the checkbox is not already checked
                if (attributename == null || !"true".equals(attributename)) {
                    check.click();
                    System.out.println(check.getText() + " is now selected");
                    return check;
                } else {
                    System.out.println(check.getText() + " is already selected");
                }
            }
        }
        return null;
    }

    public void navigation(){
      int size=  menu.size();
        System.out.println("The menu size is"+size);

        
    }
}











