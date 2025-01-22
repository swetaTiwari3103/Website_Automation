package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.Menu;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;



public class MenuTest extends TestBase{
Menu mpage;
    public MenuTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setup() throws IOException {
        initialization();
        mpage=new Menu();
    }

    @Test(priority = 1)
    public void click() throws IOException, InterruptedException {
     mpage.clickMenu();
    }
    @AfterMethod
    public void teardown() {
        tearDown();
    }

        }

