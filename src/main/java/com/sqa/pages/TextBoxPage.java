package com.sqa.pages; // Make sure this matches the folder name exactly

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public TextBoxPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    By fullName = By.id("userName");
    By email = By.id("userEmail");
    By currentAddress = By.id("currentAddress");
    By permanentAddress = By.id("permanentAddress");
    By submitButton = By.id("submit");
    By outputName = By.id("name");

    public void fillForm(String name, String mail, String currAddr, String permAddr) {
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullName)).sendKeys(name);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(currentAddress).sendKeys(currAddr);
        driver.findElement(permanentAddress).sendKeys(currAddr);
        
       
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String getSubmittedName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(outputName)).getText();
    }
}