package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ContactFromTest extends TestBase {
    @FindBy(xpath = "//a[text()='Contact Us Form Test']")
    WebElement ContactUs;
    @FindBy(xpath = "//input[@name='first_name']")
    WebElement Firstname;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement Lastname;

    @FindBy(xpath = "//input[@name='email']")
    WebElement Email;

    @FindBy(xpath = "//textarea[@name='message']")
    WebElement Commentmessage;

    @FindBy(xpath = "//input[@value='RESET']")
    WebElement Resetbutton;

    @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement Submitbutton;
    @FindBy(xpath = "//div[@class='row']/child::div/form/input")
    WebElement fields;

    @FindBy(xpath = "//body")
    WebElement errormessage;

    public ContactFromTest() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public void clickbutton() {
        ContactUs.click();
    }

    public void Fname(String fname) {
        if (fname == null || fname.isEmpty()) {
            driver.get("https://automationtesting.co.uk/contact_us.php");
            System.out.println(errormessage.getText());
        } else {

            Firstname.sendKeys(fname);
        }
    }

    public void Lname(String lname) {
        if (lname == null || lname.isEmpty()) {
            System.out.println(errormessage.getText());
        } else {

            Lastname.sendKeys(lname);
        }
    }

    public void email(String Emailaddress) {
        if (!Emailaddress.matches("^[A-Za-z0-9_\\-\\.]+@[a-zA-z]+[\\.][a-zA-z]{2,3}") || Emailaddress.isEmpty()) {
            System.out.println(errormessage.getText());
        } else {

            Email.sendKeys(Emailaddress);
        }
    }


    public void comment(String messge) {
        if (messge == null || messge.isEmpty()) {
            System.out.println(errormessage.getText());
        } else {
            Commentmessage.sendKeys(messge);

        }
    }

    public void Submitbutton() {
        Submitbutton.click();
    }

    public void Resetbutton() {
        Resetbutton.click();
    }

   public void errormessage(String fname,String lname,String emai,String comment){
        if(fname==null ||fname.isEmpty()||lname==null||lname.isEmpty()||emai==null||emai.isEmpty()||comment==null||comment.isEmpty()){
            driver.switchTo().newWindow(WindowType.WINDOW);
         String url=   driver.getCurrentUrl();
            System.out.println("URL is:"+url);
        }
   }


}
