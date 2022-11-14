package com.wasniowski.selenium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;

import java.util.List;

public class MantineSelect implements ISelect {

    private final WebDriver driver;
    private final WebElement selectWebElement;

    public MantineSelect(WebDriver driver, WebElement rootSelect) {
        this.driver = driver;
        this.selectWebElement = rootSelect;
    }

    @Override
    public boolean isMultiple() {
        return false;
    }

    @Override
    public List<WebElement> getOptions() {
        return null;
    }

    @Override
    public List<WebElement> getAllSelectedOptions() {
        return null;
    }

    @Override
    public WebElement getFirstSelectedOption() {
        return null;
    }

    @Override
    public void selectByVisibleText(String text) {

        selectWebElement.click();
        driver.findElements(By.cssSelector(".mantine-Select-item"))
                .stream().filter(a->text.contains(a.getText())).findFirst().get()
                .click();


//        selectWebElement.click();
//        driver.findElement(By.cssSelector(".mantine-Select-item"))
//                .stream().filter(a->text.contains(a.getText())).findFirst().get()
//                .click();
    }

    @Override
    public void selectByIndex(int index) {

    }

    @Override
    public void selectByValue(String value) {

    }

    @Override
    public void deselectAll() {

    }

    @Override
    public void deselectByValue(String value) {

    }

    @Override
    public void deselectByIndex(int index) {

    }

    @Override
    public void deselectByVisibleText(String text) {

    }
}
