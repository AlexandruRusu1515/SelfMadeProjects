package TECinternship;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DemoQATest {

    WebDriver driver = new EdgeDriver();

    @Test
    void testElementsButton() {

        driver.get("https://demoqa.com");

        driver.manage().window().maximize();

        WebElement elements = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"));
        elements.click();

        assertEquals("https://demoqa.com/elements", driver.getCurrentUrl());

        driver.quit();
    }

    @Test
    void testUploadAndDownloadPage() {

        driver.get("https://demoqa.com/elements");

        driver.manage().window().maximize();

        WebElement uploadElement = driver.findElement(By.xpath("//span[text()='Upload and Download']"));

        new Actions(driver)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException i) {
            i.printStackTrace();
        }

        uploadElement.click();

        assertEquals("https://demoqa.com/upload-download", driver.getCurrentUrl());

        driver.quit();
    }

    @Test
    void testFileUpload() {

        driver.get("https://demoqa.com/upload-download");

        driver.manage().window().maximize();

        WebElement chooseFile = driver.findElement(By.id("uploadFile"));
        String filePath = "C:\\Users\\alexx\\internship\\QAinternship\\src\\test\\resources\\files\\fisier.txt.txt";
        chooseFile.sendKeys(filePath);

        WebElement uploadedFileText = driver.findElement(By.id("uploadedFilePath"));
        assertTrue(uploadedFileText.getText().contains("fisier.txt"));

        driver.quit();
    }

    @Test
    void testPickDate() {
        driver.get("https://demoqa.com/date-picker");

        driver.manage().window().maximize();

        WebElement datePicker = driver.findElement(By.id("datePickerMonthYearInput"));

        String initialDate = datePicker.getAttribute("value");

        while (!datePicker.getAttribute("value").isEmpty()) {
            datePicker.sendKeys(Keys.BACK_SPACE);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException i) {
            i.printStackTrace();
        }

        datePicker.sendKeys("06/15/2025");

        String updatedDate = datePicker.getAttribute("value");

        assertNotEquals(initialDate, updatedDate, "Data nu s-a schimbat!");

        driver.quit();
    }
}
