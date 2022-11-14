package com.wasniowski.selenium;

import com.wasniowski.selenium.util.MantineSelect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GalaxyShop extends ASeleniumTest {

    @Test
    void welcomeButtonRedirect() {

        driver.get(baseUrl(""));
        driver.findElement(By.linkText("Zaczynamy")).click();

        //WebElement element = driver.findElement(By.cssSelector("[data-test=product-lists]"));

        Assertions.assertEquals(baseUrl("#/products"), driver.getCurrentUrl());


    }

    @Test
    void buyAndPayFirstProduct() {
        driver.get(baseUrl("#/products"));
        driver.findElement(By.cssSelector("[data-test^=buy-and-pay]")).click();

       driver.findElement(By.name("taxId")).sendKeys("4974331110");
       driver.findElement(By.name("address.street")).sendKeys("Krakowska");
       driver.findElement(By.name("address.streetNumber")).sendKeys("12");
       driver.findElement(By.name("address.postCode")).sendKeys("00-324");
       driver.findElement(By.name("address.place")).sendKeys("Kielce");

        WebElement rootSelect = driver.findElement(By.cssSelector(".mantine-Select-root:has([name='address.country'])"));

        MantineSelect countrySelectComponent = new MantineSelect(driver, rootSelect);
        countrySelectComponent.selectByVisibleText("Czechy");
    }

    private String baseUrl(String s) {
        return "https://du87v0wytat2i.cloudfront.net/galaxy-shop/index.html" + s;
    }
}
