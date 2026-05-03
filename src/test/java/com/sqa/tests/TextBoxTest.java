package com.sqa.tests;

import com.sqa.base.BaseTest;
import com.sqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions; // Add this import!
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextBoxTest extends BaseTest {

    @Test
    public void testTextBoxForm() {
     
        driver.get("https://demoqa.com/text-box");

        wait.until(ExpectedConditions.titleContains("DEMOQA"));

        TextBoxPage textBoxPage = new TextBoxPage(driver, wait);

        textBoxPage.fillForm(
                "Sarah Aied",
                "sarah@test.com",
                "Antalya",
                "Iraq");

        
        String submittedName = textBoxPage.getSubmittedName();
        assertTrue(submittedName.contains("Sarah Aied"), "Name not found in results!");
    }
}