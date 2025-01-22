package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.ActionPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

 public class ActionTest extends TestBase {
     ActionPage acp;

     public ActionTest() throws IOException {
         super();
     }

     @BeforeMethod
     public void setup() throws IOException {
         initialization();
         acp = new ActionPage();
     }

     @Test
     public void clickaction() throws IOException, InterruptedException {
         acp.clickaction();
         String ExpectedUrl = "https://automationtesting.co.uk/actions.html";
         String actualURl = driver.getCurrentUrl();
         Assert.assertEquals(actualURl, ExpectedUrl);
     }

     @Test
     public void testDragandDrop() throws InterruptedException {
         acp.clickaction();
         acp.dragme();
         Point point = acp.getDraggableElementText();
         System.out.println("The Draggable Element point" + point);
         Assert.assertTrue(point.getX() > 0 && point.getY() > 0, "Draggable element is in unexpected position");
     }

     @Test
     public void testDraggableElemttext() throws InterruptedException {
         acp.clickaction();
         acp.dragme();
         String Draggabletext = acp.DraggableElementtext();
         System.out.println("The Draggable text " + Draggabletext);
         Assert.assertEquals(Draggabletext, "", "Draggable element doesn't match");


     }

     @Test
     public void verifymessage() {
         acp.clickaction();
         String actual = acp.clickholdmessage();
         System.out.println("The Actual " + actual);
         String expected = "Click and Hold!";
         Assert.assertEquals(actual, expected, "The message is same");
     }

     @Test
     public void clickandhold() throws InterruptedException {
         acp.clickaction();
         acp.clickandhold();
         Thread.sleep(5000);
         String expected = "Keep holding down!";
         String actual = acp.clickholdmessage();
         System.out.println("The Actual message is :" + actual);
         Assert.assertEquals(actual, expected, "The message is same");
     }

     @Test
     public void refreshverifymessage() throws InterruptedException {
         acp.clickaction();
         acp.clickandhold();
         Thread.sleep(5000);
         acp.releasemouse();
         String message = acp.clickholdmessage();
         System.out.println("The message is :" + message);
         acp.refreshPage();
         String messagerefresh = acp.clickholdmessage();
         System.out.println("The message is :" + messagerefresh);
         Assert.assertNotEquals(message, messagerefresh, "the message is not same");

     }
     @Test
     public void doubleclick() throws InterruptedException {
         acp.clickaction();
         String beforeclick = acp.doubleclickmessage();
         System.out.println("Th before click :" + beforeclick);
         acp.doubleclickaction();
         Thread.sleep(15000);
         String afterclick = acp.doubleclickmessage();
         System.out.println("After click :" + afterclick);
         Assert.assertNotEquals(beforeclick, afterclick, "Message is not same");

     }
     @Test
     public void shifthold() throws InterruptedException {
         acp.clickaction();
       String shiftmessage=  acp.shiftmessage();
         System.out.println("The shift message is :"+shiftmessage);
         acp.holdshift();
       String text=  driver.switchTo().alert().getText();
         System.out.println("The text is :"+text);
        Alert alert= driver.switchTo().alert();
               alert .accept();
         Thread.sleep(15000);

     }

     @AfterMethod
     public void teardown(){

         tearDown();
     }
 }

