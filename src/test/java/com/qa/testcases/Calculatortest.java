package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Calculatortest extends TestBase {
    CalculatorPage cpg;
    public Calculatortest() throws IOException {
        super();
    }
    @BeforeMethod
    public void setup() throws IOException {
        initialization();
        cpg=new CalculatorPage();
    }
    @Test
    public void clickcalculator()  {
        cpg.clickbutton();
     String actual=   driver.getCurrentUrl();
     String expected="https://automationtesting.co.uk/calculator.html";
        Assert.assertEquals(actual,expected,"The URL is same");

    }
    @Test
    public void calculatortext() throws InterruptedException {
        cpg.clickbutton();
        Thread.sleep(1500);
      cpg.calculatortext();
    }
    @AfterMethod
    public void teardown(){
tearDown();
    }
}
