package com.sqa;

import com.sqa.base.BaseTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest extends BaseTest {

    @Test
    public void pilotTest() {
        // We use 'driver' from BaseTest
        driver.get("https://www.google.com");
        
        String title = driver.getTitle();
        System.out.println("The page title is: " + title);
        
        assertTrue(title.contains("Google"), "Title didn't match!");
    }
}