package com.sauce.pages;

import com.sauce.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage{

    public static int addedItemNumber=0;
    @FindBy(css = "[class='product_sort_container']")
    public WebElement selectDropDown;

    public void orderItems(String orderType){
        Select select=new Select(selectDropDown);
        select.selectByVisibleText(orderType);
        // select.getFirstSelectedOption().click();
    }

    public void addItem(String itemName){
        Driver.get().findElement(By.
                xpath("//*[text()='"+itemName+"']/ancestor::*[@class='inventory_item_description']//button")).click();
        addedItemNumber++;
    }
}
