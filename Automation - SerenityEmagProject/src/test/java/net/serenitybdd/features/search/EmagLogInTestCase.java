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
public class EmagLogInTestCase {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    EmagSteps emagSteps;

    @Steps
    EmagResultSteps emagResultSteps;

    @Test
    public void loginPassScenario() throws InterruptedException {
        emagSteps.openEmagPage();
        webdriver.manage().window().maximize();
        emagSteps.apasatContulMeu();
        String email = "alex@yahoo.com";
        emagSteps.inserareEmail(email);
        emagSteps.apasatContinueButton();
        Thread.sleep(20000);
        String parola = "Parola";
        emagSteps.inserareParola(parola);
        emagSteps.apasatContinueButton();
        Thread.sleep(20000);
        emagResultSteps.verifyUserLoggedIn();
        Thread.sleep(10000);
        System.out.println("LoginPass scenario works fine!");
    }

    @Test
    public void loginFailScenario() throws InterruptedException {
        emagSteps.openEmagPage();
        webdriver.manage().window().maximize();
        emagSteps.apasatContulMeu();
        emagSteps.inserareEmail("fakemail");
        emagSteps.apasatContinueButton();
        Thread.sleep(10000);
        emagResultSteps.verifyLoginFailed();
        System.out.println("LoginFail scenario works fine!");
    }
}