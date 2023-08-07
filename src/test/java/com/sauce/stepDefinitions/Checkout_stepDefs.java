package com.sauce.stepDefinitions;

import com.sauce.pages.CheckoutPage;
import com.sauce.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Checkout_stepDefs {

    CheckoutPage checkoutPage = new CheckoutPage();

    @When("form filled and continue button pressed")
    public void form_filled_and_continue_button_pressed() {
        checkoutPage.formFill();
        checkoutPage.getContinueButtonclick();

    }

    @When("Verified to go to payment overview page")
    public void Verified_to_go_to_payment_overview_page() {
        String expected = "Checkout: Overview";
        String actual = checkoutPage.pageName.getText();
        Assert.assertEquals(expected, actual);

    }

    @Then("price of products verified")
    public void price_of_products_verified() {
        Assert.assertEquals(checkoutPage.priceOfProductsListExpected(),
                checkoutPage.priceOfProductsListActual());

    }

    @When("finish has been")
    public void finish_has_been() {
        checkoutPage.getFinishButtonclick();

    }


    @Then("successful shopping message confirmed")
    public void successful_shopping_message_confirmed() {
        String expected = "Thank you for your order!";
        String actual = checkoutPage.shoppingMessage.getText();
        Assert.assertEquals(expected, actual);
    }
}