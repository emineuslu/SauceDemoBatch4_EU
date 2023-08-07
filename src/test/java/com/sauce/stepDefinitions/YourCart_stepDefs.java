package com.sauce.stepDefinitions;

import com.sauce.pages.YourCartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class YourCart_stepDefs {

    YourCartPage yourCartPage=new YourCartPage();
    @Then("Verified that the correct products have been added to the cart")
    public void verified_that_the_correct_products_have_been_added_to_the_cart() {
        Assert.assertEquals(yourCartPage.getYourCartListExpected(),yourCartPage.getYourCartListActual());
    }
    @When("went to the payment page")
    public void went_to_the_payment_page() {
      yourCartPage.getCheckoutButton();
    }

}
