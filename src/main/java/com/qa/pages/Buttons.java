package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Buttons extends TestBase {

    @FindBy(xpath = "//a[text()='Buttons']")
    WebElement buttons;
    @FindBy(xpath = "//button[@id='btn_one']")
    WebElement buttonone;
    @FindBy(xpath = "//button[@id='btn_two']")
    WebElement buttontwo;
    @FindBy(xpath = "//button[@id='btn_three']")
    WebElement buttonthree;
@FindBy(xpath = "//button[text()='Button Four']")
WebElement buttonfour;
    public Buttons() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }
public void clickbuttons(){
        buttons.click();
    }
    public void buttone() {
       String beforeclick= buttonone.getText();
        System.out.println("before click:"+beforeclick);
        if (buttonone.isEnabled()) {
            buttonone.click();
        }
    }

public void butontwo() {
    String beforeclick= buttontwo.getText();
    System.out.println("before click:"+beforeclick);
    if (buttontwo.isEnabled()) {
        buttontwo.click();
    }
}
        public void butthree(){
            String beforeclick= buttonthree.getText();
            System.out.println("before click:"+beforeclick);
            if(buttonthree.isEnabled()){
                buttonthree.click();
            }
    }
    public void butfour(){
        String beforeclick= buttonfour.getText();
        System.out.println("before click:"+beforeclick);
        if(buttonfour.isEnabled()){
            buttonfour.click();
        }
        else {
            System.out.println("button is disabled");
        }
    }
    }

