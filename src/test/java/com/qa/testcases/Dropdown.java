package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.Dropdowncheckbox;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Dropdown extends TestBase {
 Dropdowncheckbox dpc;

    public Dropdown() throws IOException {
        super();
    }

        @BeforeMethod
                public  void setup() throws IOException {
            initialization();
            dpc=new Dropdowncheckbox();
        }
        @Test
    public void clickDropdown(){
        dpc.clickdropdown();
      String url=  driver.getCurrentUrl();
            System.out.println("The url is :"+url);
          String  Expectedurl="https://automationtesting.co.uk/dropdown.html";
            Assert.assertEquals(url,Expectedurl,"The Message is same");
    }
    @Test
    public void radiobutton() throws InterruptedException {
        dpc.clickdropdown();
        Thread.sleep(1500);
        dpc.radiobuttonclick("Two");
       dpc.checkbox("Green");
       Thread.sleep(1500);
        // dpc.gettext();
    }
    @Test
    public void navigation(){
        dpc.clickdropdown();
        dpc.navigation();
    }







    }

