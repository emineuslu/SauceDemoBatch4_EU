package com.sauce.stepDefinitions;

import com.sauce.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Products_stepDefs {

    ProductsPage productsPage=new ProductsPage();
    @Then("The user should be able to see page title : {string}")
    public void the_user_should_be_able_to_see_page_title(String pageName) {
        String actualPageTitle = productsPage.getPageTitle(pageName);
        Assert.assertEquals(pageName,actualPageTitle);
    }

    @When("The user should be able to sort items with order type : {string}")
    public void the_user_should_be_able_to_sort_items_with_order_type(String orderType) {
        productsPage.orderItems(orderType);
    }

    @When("The user should be able to add items to cart with item name : {string}")
    public void the_user_should_be_able_to_add_items_to_cart_with_item_name(String itemName) {
        productsPage.addItem(itemName);
    }

    @Then("The number on the basket icon should show added item number")
    public void the_number_on_the_basket_icon_should_show_added_item_number() {
        int actualQuantity = productsPage.getQuantity();
        int expectedQuantity=ProductsPage.addedItemNumber;
        Assert.assertEquals(expectedQuantity,actualQuantity);
    }

    @When("Go to cart page")
    public void go_to_cart_page() {
        productsPage.clickShoppingCart();
    }


}
