package net.serenitybdd.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.steps.serenity.EmagResultSteps;
import net.serenitybdd.steps.serenity.EmagSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@RunWith(SerenityRunner.class)
public class EmagCartDeletedTestCase {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    EmagSteps emagSteps;

    @Steps
    EmagResultSteps emagResultSteps;

    private String produs = "ceas smartwatch";

    @Test
    public void cartAddedScenario() throws InterruptedException {
        emagSteps.openEmagPage();
        webdriver.manage().window().maximize();
        emagSteps.cautareProdus(produs);
        emagSteps.pressSearchButton();
        new Actions(webdriver)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .perform();
        emagSteps.pressAdaugareProdus();
        emagSteps.pressVeziCos();
        emagSteps.pressStergere();
        Thread.sleep(2000);
        emagResultSteps.verifyProductDeletedFromCart();
        Thread.sleep(2000);
    }
}
