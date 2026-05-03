package com.sqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BooksPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By searchBox = By.cssSelector("input[name='q']");

    private By searchButton = By.cssSelector("button[type='submit']");

    private By bookArticles = By.cssSelector("article.product_pod");

    private By bookTitleLinks = By.cssSelector("article.product_pod h3 a");

    private By bookDetailTitle = By.cssSelector("div.product_main h1");

    private By bookDetailPrice = By.cssSelector("div.product_main p.price_color");

    private By bookAvailability = By.cssSelector("div.product_main p.availability");

    private By mysteryCategory = By.linkText("Mystery");

    public BooksPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void typeInSearchBox(String searchTerm) {
        WebElement box = wait.until(
            ExpectedConditions.presenceOfElementLocated(searchBox)
        );
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView(true);", box
        );
        box.clear();
        box.sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        // Try button[type=submit] first, then input[type=submit]
        try {
            wait.until(
                ExpectedConditions.elementToBeClickable(searchButton)
            ).click();
        } catch (Exception e) {
            driver.findElement(By.cssSelector("input[type='submit']")).click();
        }
    }

    public void clickMysteryCategory() {
        wait.until(
            ExpectedConditions.elementToBeClickable(mysteryCategory)
        ).click();
    }

    public int getResultCount() {
        try {
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(bookArticles)
            );
            return driver.findElements(bookArticles).size();
        } catch (Exception e) {
            return 0;
        }
    }

    public void clickFirstBook() {
        List<WebElement> books = driver.findElements(bookTitleLinks);
        books.get(0).click();
    }

    public String getBookDetailTitle() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(bookDetailTitle)
        ).getText();
    }

    public String getBookDetailPrice() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(bookDetailPrice)
        ).getText();
    }

    public String getBookAvailability() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(bookAvailability)
        ).getText();
    }
}
