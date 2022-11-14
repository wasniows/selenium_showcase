package com.wasniowski.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FirstTest extends ASeleniumTest {

    @Test
    void contactFormTest() {

        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        driver.findElement(By.id("et_pb_contact_name_0")).sendKeys("TEST");
        driver.findElement(By.id("et_pb_contact_email_0")).sendKeys("email");
        //driver.findElement(By.name("et_builder_submit_button")).click();
        driver.findElement(By.className("et_pb_contact_form")).submit();

    }

    @Test
    void firstTestOpenBrowser() {

        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        driver.findElement(By.cssSelector("[name=gender][value=female]")).click();
        driver.findElement(By.cssSelector("[name=vehicle][value=Car]")).click();


        WebElement select = driver.findElement(By.tagName("select"));
        Select selectComponent = new Select(select);
        selectComponent.selectByVisibleText("Audi");
        selectComponent.selectByValue("saab");
        selectComponent.selectByIndex(2);

    }
}
