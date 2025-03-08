package net.serenitybdd.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.steps.serenity.EmagResultSteps;
import net.serenitybdd.steps.serenity.EmagSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class EmagSearchTestCase {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    EmagSteps emagSteps;

    @Steps
    EmagResultSteps emagResultSteps;

    private String produs = "ceas smartwatch";

    @Test
    public void searchScenario() throws InterruptedException {
        emagSteps.openEmagPage();
        webdriver.manage().window().maximize();
        emagSteps.cautareProdus(produs);
        emagSteps.pressSearchButton();
        emagResultSteps.verifyProductList();
        Thread.sleep(2000);
    }
}
