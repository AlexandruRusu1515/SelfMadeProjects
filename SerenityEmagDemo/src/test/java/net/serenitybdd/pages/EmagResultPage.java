package net.serenitybdd.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;

public class EmagResultPage extends PageObject {

    @FindBy(css = "#my_account img")
    private WebElementFacade imgContulMeu;

    public boolean checkLoggedIn() {
       return imgContulMeu.waitUntilVisible().isPresent();
    }

    @FindBy(css = ".form-group.has-error .help-block")
    private WebElementFacade emailInvalidError;

    public boolean checkInvalidEmail(){
        return emailInvalidError.waitUntilVisible().isPresent();
    }

    @FindBy(css = "#card_grid .card-item")
    private List<WebElementFacade> listaProduseSearch;

    public boolean checkListaProduse(){
        return !listaProduseSearch.isEmpty();
    }

    @FindBy(css = "#cart-products > div > div.col-md-8.col-lg-9.main-cart-container-left > div.placeholder.vendors-container > div")
    private List<WebElementFacade> produseCos;

    public boolean checkCosAdaugare(){
        return !produseCos.isEmpty();
    }

    public boolean checkCosStergere(){
        waitABit(2000);
        return produseCos.isEmpty();
    }


}
