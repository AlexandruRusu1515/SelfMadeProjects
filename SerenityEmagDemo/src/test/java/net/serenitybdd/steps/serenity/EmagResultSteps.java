package net.serenitybdd.steps.serenity;

import net.serenitybdd.pages.EmagResultPage;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class EmagResultSteps {

    EmagResultPage emagResultPage;

    // Prima functionalitate: Login

    @Step
    public void verifyUserLoggedIn(){
        assertThat("User should be logged in" , emagResultPage.checkLoggedIn(), is(true));
    }

    @Step
    public void verifyLoginFailed(){
        assertThat("Error message should be displayed" , emagResultPage.checkInvalidEmail() , is(true));
    }

    // A doua functionalitate: Search

    @Step
    public void verifyProductList(){
        assertThat("Multiple products should be displayed" , emagResultPage.checkListaProduse(), is(true));
    }

    // A treia functionalitate: Add

    @Step
    public void verifyProductAddedToCart(){
        assertThat("Product should be added to cart" , emagResultPage.checkCosAdaugare() , is(true));
    }

    // A patra functionalitate: Delete

    @Step
    public void verifyProductDeletedFromCart(){
        assertThat("Product should be deleted from cart" , emagResultPage.checkCosStergere() , is(true));
    }
}
