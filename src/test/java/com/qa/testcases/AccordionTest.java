package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.AccordionPage;
import com.qa.pages.Hemburgermenu;
import com.qa.pages.Menu;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AccordionTest extends TestBase {
    Hemburgermenu hm;
    Menu menu;
    AccordionPage ap;

    public AccordionTest() throws IOException {
        super();
        // Initialize objects in @BeforeClass or methods that can handle exceptions
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        ap = new AccordionPage();
    }

    @Test
    public void accordion() throws InterruptedException {
        ap.click();
       String beforeHover= ap.getBeforehoverColor();
        System.out.println("Before Hover Color: " + beforeHover);
        ap.hover();
        String afterHover=ap.getAfterHoverColor();
        System.out.println("After Hover Color: " + afterHover);
        Assert.assertNotEquals(beforeHover,afterHover,"Color did not change after hover");
    }
    @AfterMethod
    public void teardown() {

        tearDown();
    }
}

