package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.Buttons;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ButtonsTest extends TestBase {
    Buttons bt;

    public ButtonsTest() throws IOException {

        super();

    }

    @BeforeMethod()
    public void setup() throws IOException {
        initialization();
     bt=new Buttons();
       // Bt=new ButtonsTest();
    }
    @Test
    public void clickButton(){
bt.clickbuttons();
        String currenturl= driver.getCurrentUrl();
        String expected="https://automationtesting.co.uk/buttons.html";
        Assert.assertEquals(currenturl,expected,"URL is same");

    }
    @Test
    public void buttonfirst(){
        bt.clickbuttons();
      bt.buttone();
        Alert alt=driver.switchTo().alert();
      String alttext=  alt.getText();
        System.out.println("The alt text is :"+alttext);
        alt.accept();
        String Expectedmessage="You clicked the first button!";
Assert.assertEquals(alttext,"You clicked the first button!","Axpected andActual is same");
    }
    @Test
    public void buttonsecond(){
        bt.clickbuttons();
      bt.butontwo();
        Alert alt=driver.switchTo().alert();
        String secondtext= alt.getText();
        System.out.println("The alt text is :"+secondtext);
        alt.accept();
        String Expectedmessage="You clicked the second button!";
        Assert.assertEquals(secondtext,"You clicked the second button!","Actual and Expected for second alet box is same");

    }
    @Test
    public void buttonthird(){
        bt.clickbuttons();
        bt.butthree();
        Alert alt=driver.switchTo().alert();
        String thirdtext= alt.getText();
        System.out.println("The alt text is :"+thirdtext);
        alt.accept();
        String Expectedmessage="You clicked the second button!";
        Assert.assertEquals(thirdtext,"You clicked the third button!","Actual and Expected for third alet box is same");

    }
    @Test
    public  void buttonfour(){

      bt.butfour();



    }

}
