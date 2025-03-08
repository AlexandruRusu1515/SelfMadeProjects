package net.serenitybdd.steps.serenity;

import net.serenitybdd.pages.EmagPage;
import net.thucydides.core.annotations.Step;


public class EmagSteps {

    EmagPage emagPage;

    // Prima functionalitate: Login

    @Step
    public void openEmagPage(){
        emagPage.open();
    }

    @Step
    public void apasatContulMeu(){
        emagPage.clickContulMeu();
    }

    @Step
    public void inserareEmail(String email){
        emagPage.inserareEmail(email);
    }

    @Step
    public void inserareParola(String parola){
        emagPage.inserareParola(parola);
    }

    @Step
    public void apasatContinueButton(){
        emagPage.clickContinueButton();
    }

    // A doua functionalitate: Search
    @Step
    public void cautareProdus(String produs){
        emagPage.inserareProdus(produs);
    }

    @Step
    public void pressSearchButton(){
        emagPage.clickSearchButton();
    }

    // A treia functionalitate: Adaugare cos

    @Step
    public void pressAdaugareProdus(){
        emagPage.clickadaugInCosButton();
    }

    @Step
    public void pressVeziCos(){
        emagPage.clickVeziCosButton();
    }

    // A patra functionalitate: Sterge cos

    @Step
    public void pressStergere(){
        emagPage.clickStergeButton();
    }
}