package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.ContactFromTest;
import com.qa.util.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Contactus extends TestBase {

    ExcelReader ex;
    ContactFromTest cft;


    public Contactus() throws IOException {
        super();
    }


    @BeforeMethod()
    public  void setup() throws IOException {
        initialization();
        cft=new ContactFromTest();
    }

    @Test
    public void clickcontactus(){
        cft.clickbutton();
      String actualurl=  driver.getCurrentUrl();
      String expectedurl="https://automationtesting.co.uk/contactForm.html";
        Assert.assertEquals(actualurl,expectedurl,"URL is same");
    }

    @Test(dataProvider = "ContactUsFromTest")
    public void ContactUS(String FirstName,String LastName,String Email,String Comment) throws InterruptedException {
    cft.clickbutton();
    cft.Fname(FirstName);
    cft.Lname(LastName);
    cft.email(Email);
    cft.comment(Comment);
    cft.Submitbutton();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @DataProvider(name="ContactUsFromTest")
    public Object[][] getData() throws IOException {
        try {
            return ExcelReader.readExcelData("src//main//java//com//qa//util//ContactUs.xlsx","Contactus");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void teardown(){
        tearDown();
    }
}



