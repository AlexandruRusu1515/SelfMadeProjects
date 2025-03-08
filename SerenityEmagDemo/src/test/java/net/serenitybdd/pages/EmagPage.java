package net.serenitybdd.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.emag.ro/")
public class EmagPage extends PageObject {

    // Functionalitatea 1 - Login

    @FindBy(id = "my_account")
    private WebElementFacade contulMeu;

    @FindBy(id = "user_login_email")
    private WebElementFacade emailBox;

    @FindBy(id = "user_login_password")
    private WebElementFacade parolaBox;

    @FindBy(id = "user_login_continue")
    private WebElementFacade continueButton;

    public void clickContulMeu(){
        contulMeu.waitUntilVisible().click();
    }

    public void inserareEmail(String email){
        emailBox.waitUntilVisible().type(email);
    }

    public void inserareParola(String parola){
        parolaBox.waitUntilVisible().type(parola);
    }

    public void clickContinueButton(){
        continueButton.waitUntilVisible().click();
    }


    // Functionalitatea 2: Search

    @FindBy(id = "searchboxTrigger")
    private WebElementFacade searchBox;

    @FindBy(xpath = "//*[@id=\"masthead\"]/div/div/div[2]/div/form/div[1]/div[2]/button[2]")
    private WebElementFacade searchButton;

    public void inserareProdus(String produs){
        searchBox.waitUntilVisible().type(produs);
    }

    public void clickSearchButton(){
        searchButton.waitUntilVisible().click();
    }

    // Functionalitatea 3: Adaugare produs in cos

    @FindBy(css = "#card_grid button[type='submit']")
    private WebElementFacade adaugaInCosButton;

    @FindBy(css = ".product-purchased-modal .table-cell a")
    private WebElementFacade veziCosButton;

    public void clickadaugInCosButton(){
        adaugaInCosButton.waitUntilVisible().click();
    }

    public void clickVeziCosButton(){
        veziCosButton.waitUntilVisible().click();
    }

    // Functionalitatea 4: Stergere produs din cos

    @FindBy(xpath = "//*[@id=\"cart-products\"]/div/div[1]/div[6]/div/div[2]/div[2]/div[2]/button")
    private WebElementFacade stergeButton;

    public void clickStergeButton(){
        stergeButton.waitUntilVisible().click();
    }
}