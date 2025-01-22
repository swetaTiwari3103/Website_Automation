package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class DatePicker extends TestBase {

    @FindBy(xpath = "//a[text()='Date Picker']")
    WebElement datepicker;

    @FindBy(xpath = "//input[@id='basicDate']")
    WebElement basicdatetime;

    @FindBy(xpath = "//input[@id='rangeDate']")
    WebElement rangedatetime;

    @FindBy(xpath = "//input[@placeholder='Select Date..']")
    WebElement weeknumber;

    @FindBy(xpath = "//input[@id='timePicker']")
    WebElement timepicker;

    @FindBy(className = "flatpickr-calendar hasTime animate open arrowBottom")
    WebElement calendar;
    @FindBy(className = "flatpickr-month")
    WebElement monthyear;
    @FindBy(className = "flatpickr-prev-month")
    WebElement previous;
    @FindBy(className = "flatpickr-next-month")
    WebElement next;
    @FindBy(xpath = "//div[@class='dayContainer']/span")
    List<WebElement> days;

    WebDriverWait wait;

    public DatePicker() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }


    public void datepicker() {
        datepicker.click();
    }

    public void basictime() {
        basicdatetime.click();
        System.out.println("The placeholder text for basicdatetime is :" + basicdatetime.getAttribute("placeholder"));
    }

    public void rangedatetime() {

        System.out.println("The placeholder text for rangedatetime :" + rangedatetime.getAttribute("placeholder"));
        //rangedatetime.click();
    }

    public void weeknumer() {
        System.out.println("The  placeholder text for Week number :" + weeknumber.getAttribute("placeholder"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(1500));
        wait.until(ExpectedConditions.elementToBeClickable(weeknumber));
        //   weeknumber.click();

    }



    public void timepicker() {
        System.out.println("The  placeholder text for Time picker :" + timepicker.getAttribute("placeholder"));
        // timepicker.click();

    }

    public void getplaceholdertext() {
        System.out.println("The placeholder text for basicdatetime :" + basicdatetime.getAttribute("placeholder"));
        System.out.println("The placeholder text for rangedatetime :" + rangedatetime.getAttribute("placeholder"));
        System.out.println("The placeholder text for weeknumber :" + weeknumber.getAttribute("placeholder"));
        System.out.println("The placeholder text for timepicker:" + timepicker.getAttribute("placeholder"));
    }

    public void closecalendar() {
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ESCAPE).perform();
    }

    public void calendar(String date, String month, String year) {
        calendar.click();
        if (month.equals("February") && Integer.parseInt(date) > 29) {
            System.out.println("Wrong date");

        }
        if (Integer.parseInt(date) > 31) {
            System.out.println("Wrong date the number is greater than 31");
        }

    }

    public void Selectdate(String date) {
       WebElement Date= driver.findElement(By.xpath("//span[text()='+date']"));
        System.out.println("The text is "+Date.getText());
       Date.click();
    }
}
















