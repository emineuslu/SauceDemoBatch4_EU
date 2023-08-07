package com.sauce.pages;

import com.sauce.utilities.BrowserUtils;
import com.sauce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//h2[@class='complete-header']")
    public WebElement shoppingMessage;


    @FindBy(css = "[id='first-name']")
    public WebElement firstName;

    @FindBy(css = "[id='last-name']")
    public WebElement lastName;

    @FindBy(css = "[id='postal-code']")
    public WebElement postalCod;

    @FindBy(css = "[id='continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//span[.='Checkout: Overview']")
    public WebElement pageName;

    @FindBy(css = "[class='inventory_item_price']")
    public List<WebElement> priceOfProducts ;


    @FindBy(css ="[id='finish']")
    public WebElement finishButton;



    public void formFill(){
        firstName.sendKeys("Emine");
        lastName.sendKeys("Uslu");
        postalCod.sendKeys("035");
    }

   public void getContinueButtonclick(){
        BrowserUtils.clickWithJS(continueButton);
   }

    public List<String> priceOfProductsListActual(){
        List<String> actualList=new ArrayList<>();
        for (WebElement webElement : priceOfProducts) {
            actualList.add(webElement.getText());
        }

        return actualList;
    }

    public List<String> priceOfProductsListExpected(){
        List<String> expectedList=new ArrayList<>(Arrays.asList("$7.99","$29.99"));
        return expectedList;
    }

    public void getFinishButtonclick(){
        BrowserUtils.clickWithJS(finishButton);
    }
}