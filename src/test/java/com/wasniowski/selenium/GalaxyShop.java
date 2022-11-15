package com.wasniowski.selenium;

import com.wasniowski.selenium.util.Hooks;
import com.wasniowski.selenium.util.MantineSelect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GalaxyShop extends ASeleniumTest {

    public static final By BUTTON_BUY_AND_PAY_LOCATOR = By.cssSelector("[data-test^=buy-and-pay]");
    public static final By INTUP_TAX_ID_LOCATOR = By.name("taxId");
    public static final By INPUT_ADDRESS_STREET = By.name("address.street");
    public static final By INPUT_ADDRESS_STREET_NUMBER = By.name("address.streetNumber");
    public static final By INPUT_POST_CODE = By.name("address.postCode");
    public static final By INPUT_ADDRESS_PLACE = By.name("address.place");
    public static final By SUB_HEADER_LOCATOR = By.cssSelector("[data-test=sub-header]");

    @Test
    void welcomeButtonRedirect() {

        driver.get(Hooks.baseUrl(""));
        driver.findElement(By.linkText("Zaczynamy")).click();

        //WebElement element = driver.findElement(By.cssSelector("[data-test=product-lists]"));

        Assertions.assertEquals(Hooks.baseUrl("#/products"), driver.getCurrentUrl());

    }

    @Test
    void buyAndPayFirstProduct() {
        driver.get(Hooks.baseUrl("#/products"));
        driver.findElement(BUTTON_BUY_AND_PAY_LOCATOR).click();

        driver.findElement(INTUP_TAX_ID_LOCATOR).sendKeys("4974331110");
        driver.findElement(INPUT_ADDRESS_STREET).sendKeys("Krakowska");
        driver.findElement(INPUT_ADDRESS_STREET_NUMBER).sendKeys("12");
        driver.findElement(INPUT_POST_CODE).sendKeys("00-324");
        driver.findElement(INPUT_ADDRESS_PLACE).sendKeys("Kielce");


        //WebElement rootSelect = driver.findElement(By.cssSelector(".mantine-Select-root:has([name='address.country'])"));

        MantineSelect countrySelectComponent = new MantineSelect(driver, "[name='address.country']");
        countrySelectComponent.selectByVisibleText("Czechy");

        driver.findElement(By.name("delivery-form")).submit();

        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.textToBePresentInElementLocated(SUB_HEADER_LOCATOR, "Metody płatności"));

        Assertions.assertEquals("Metody płatności", driver.findElement(SUB_HEADER_LOCATOR).getText());

    }


}
