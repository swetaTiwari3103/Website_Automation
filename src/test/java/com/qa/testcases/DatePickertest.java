package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.DatePicker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class DatePickertest extends TestBase {
    DatePicker dp;

    public DatePickertest() throws IOException {
        super();
    }

    @BeforeMethod()
    public void setup() throws IOException {
        initialization();
         dp=new DatePicker();
    }
    @Test
    public  void clickDatepicker(){
        dp.datepicker();
      String actual=  driver.getCurrentUrl();
        System.out.println("The actual url is :"+actual);
      String expected="https://automationtesting.co.uk/datepicker.html";
        Assert.assertEquals(actual,expected,"Actual and Expected is same");

    }

    @Test
    public  void gettext() throws InterruptedException {
     dp.datepicker();
     dp.getplaceholdertext();
    }

    @Test
    public void basicdatetime(){
        dp.datepicker();
      //  dp.getdays("15");
        dp.calendar("15","February","2021");
    }
    @AfterMethod
    public void teardown(){
        tearDown();
    }
}
