package de.mytoys.pages;

import de.mytoys.utilities.BrowserUtils;
import de.mytoys.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
    public SearchPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    //define necessary locators for search Page

    @FindBy(xpath = "//div/label//following-sibling::input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath = "(//div/button[@type='submit'])[1]")
    public static  WebElement searchBtn;

    @FindBy(xpath = "//button[.='Zustimmen']")
    public WebElement zustimmenBtn;
    @FindBy(xpath = "(//div/select[@name='select'])[1]")
    public WebElement sortDown;

    @FindBy(xpath = "//span[contains(.,'Preis')]")
    public WebElement preisDDown;
    @FindBy(xpath = "(//div/input[@type='tel'])[1]")
    public WebElement priceFromBox;

    @FindBy(xpath = "(//div/input[@type='tel'])[2]")
    public WebElement priceToBox;

    @FindBy(xpath = "")
    public WebElement setPriceArrow;

    @FindBy(xpath = "(//span[contains(.,'Sport & Garten')])[5]")
    public WebElement categoryName;

    @FindBy(xpath = "//div/h1")
    public WebElement searcResult;




    //method to click search button
    public void clickSearchBtn(){
        BrowserUtils.waitFor(3);

        searchBtn.click();
        zustimmenBtn.click();
    }


     //method for search result sorting

    public void searchBy(String searchWord){

        Select select = new Select(sortDown);
        select.selectByVisibleText(searchWord);
    }



    //set price with accepting price
    public void setPrice(String from,String to){
        BrowserUtils.verifyElementDisplayed(priceToBox,3);
        priceFromBox.click();
        BrowserUtils.waitFor(2);
        priceFromBox.sendKeys(from);
        priceToBox.click();
        BrowserUtils.waitFor(2);
        priceToBox.sendKeys(to);



}
}