package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Hemburgermenu extends TestBase {
 WebDriverWait wait;
 @FindBy(xpath = "//ul/li/a")
 List<WebElement> sidelinks;
 @FindBy(xpath = "//a[text()='Homepage']")
 WebElement homepage;

 @FindBy(xpath = "//a[text()='Accordion']")
 WebElement accordion;
 @FindBy(xpath = "//a[text()='Actions']")
 WebElement actions;

 @FindBy(xpath = "//a[text()='Browser Tabs']")
 WebElement browsertabs;
 @FindBy(xpath = "//a[text()='Buttons']")
 WebElement buttons;
 @FindBy(xpath = "//a[text()='Calculator (JS)']")
 WebElement calculator;
 @FindBy(xpath = "//a[text()='Contact Us Form Test']")
 WebElement contact;
 @FindBy(xpath = "//a[text()='Date Picker']")
 WebElement datepicker;
 @FindBy(xpath = "//a[text()='DropDown Checkbox Radio']")
 WebElement Dropdown;
 @FindBy(xpath = "//a[text()='File Upload']")
 WebElement fileupload;
 @FindBy(xpath = "//a[text()='Hidden Elements']")
 WebElement hidden;
 @FindBy(xpath = "//a[text()='iFrames']")
 WebElement iframe;
 @FindBy(xpath = "//a[text()='Loader']")
 WebElement loader;
 @FindBy(xpath = "//a[text()='Loader Two']")
 WebElement loadertwo;
 @FindBy(xpath = "//a[text()='Login Portal Test']")
 WebElement loginportal;
 @FindBy(xpath = "//a[text()='Mouse Movement']")
 WebElement mousemovement;
 @FindBy(xpath = "//a[text()='Pop Ups & Alerts']")
 WebElement alerts;
 @FindBy(xpath = "//a[text()='Predictive Search']")
 WebElement predictivesearch;
 @FindBy(xpath = "//a[text()='Tables']")
 WebElement tables;
 @FindBy(xpath = "//a[text()='Test Store']")
 WebElement Test;
 @FindBy(xpath = "//a[text()='About Me']")
 WebElement About;

 public Hemburgermenu() throws IOException {

  PageFactory.initElements(driver, this);
  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 }

 public void Pageload() {
  WebDriverWait wd = new WebDriverWait(driver, Duration.ofSeconds(10));
  wd.until(ExpectedConditions.visibilityOfAllElements(sidelinks));
 }

 public void gotoHomePage() {
  driver.navigate().back();
 }

 public void getalllinks() {
  for (int i = 0; i < sidelinks.size(); i++) {
   if (i < sidelinks.size()) {
    String text = sidelinks.get(i).getText();
    System.out.println("The link text is " + text);
    WebElement link = sidelinks.get(i);
    // Scroll the element into view before clicking
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", link);


   }
  }
  }
 }




