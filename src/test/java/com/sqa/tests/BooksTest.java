package com.sqa.tests;

import com.sqa.base.BaseTest;
import com.sqa.pages.BooksPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BooksTest extends BaseTest {

    private static final String WEBSITE_URL = "https://books.toscrape.com";

    @Test
    public void testBookSearchScenario() {
        // Step 1: Navigation
        driver.get(WEBSITE_URL);

        // Step 2: Check Title (Stability check)
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("Books to Scrape"), "Title mismatch! Found: " + pageTitle);

        // Step 3: Initialize Page Object
        BooksPage page = new BooksPage(driver, wait);

        // Step 4: Category Navigation (More stable than search)
        page.clickMysteryCategory();

        // Step 5: Result Verification
        int resultCount = page.getResultCount();
        assertTrue(resultCount > 0, "No books found in Mystery category!");

        // Step 6: Detail Verification
        page.clickFirstBook();

        String bookTitle = page.getBookDetailTitle();
        String bookPrice = page.getBookDetailPrice();
        String availability = page.getBookAvailability();

        // Final Assertions
        assertAll("Book Details",
            () -> assertFalse(bookTitle.isEmpty(), "Title is empty"),
            () -> assertTrue(bookPrice.contains("£"), "Currency symbol missing"),
            () -> assertTrue(availability.contains("In stock"), "Out of stock")
        );
    }
}