package com.sauce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YourCartPage extends BasePage {


    @FindBy(css = "[class='inventory_item_name'] ")
    public  List<WebElement> cartList;

    @FindBy(css = "[id='checkout']")
    public WebElement checkoutButton;


    public List<String> getYourCartListActual(){
        List<String> actualList=new ArrayList<>();
        for (WebElement webElement : cartList) {
            actualList.add(webElement.getText());
        }

        return actualList;
    }

   public List<String> getYourCartListExpected(){
       List<String> expectedList=new ArrayList<>(Arrays.asList("Sauce Labs Onesie","Sauce Labs Backpack"));
       return expectedList;
   }

   public void getCheckoutButton(){
        checkoutButton.click();
   }
}