package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class CalculatorPage extends TestBase {

    @FindBy(xpath = "//a[text()='Calculator (JS)']")
    WebElement Calculator;
    @FindBy(xpath = "//tr/td/input[@type='button']")
    List<WebElement> buttons;

    public CalculatorPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public void clickbutton() {
        Calculator.click();
    }

    public void calculatortext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(buttons));

        System.out.println("The number of buttons is: " + buttons.size());
        for (WebElement button : buttons) {
            System.out.println(button.getAttribute("value"));

        }
    }
}
