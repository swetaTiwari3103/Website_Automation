package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.Hemburgermenu;
import com.qa.pages.Menu;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Link extends TestBase {
    Hemburgermenu hm;
    Menu menu;

    // Constructor should not throw or catch exceptions
    public Link() throws IOException {
        super();
        // Initialize objects in @BeforeClass or methods that can handle exceptions
    }

    @BeforeClass
    public void setUp() throws IOException {
        initialization();
        // Move exception handling here, as TestNG supports checked exceptions in lifecycle methods
        hm = new Hemburgermenu();
        menu = new Menu();
    }

    @Test
    public void clickalllink() throws InterruptedException {
       hm.getalllinks();
       hm.gotoHomePage();
        }
    @AfterMethod
    public void teardown() {
        tearDown();
    }
    }


