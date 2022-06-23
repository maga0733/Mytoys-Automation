package de.mytoys.stepdefinitions;



import de.mytoys.pages.SearchPage;
import de.mytoys.utilities.BrowserUtils;
import de.mytoys.utilities.ConfigurationReader;
import de.mytoys.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class SearhStepDefs {
    SearchPage searchPage = new SearchPage();


//get the url
    @Given("the customer is on Homepage")
    public void the_customer_is_on_Homepage() {

        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.verifyElementDisplayed(searchPage.searchBox, 3);




    }
    // searh for item
    @When("the customer serach for {string}")
    public void the_customer_serach_for(String itemName) {

        searchPage.searchBox.sendKeys(itemName);
    }


    @Then("the customer clicks search button")
    public void theCustomerClicksSearchButton() {

        //click search button
        searchPage.clickSearchBtn();




    }

    @And("the customer sorts by {string}")

    //sort product by..
    public void theCustomerSortsBy(String sortType) {

        searchPage.searchBy(sortType);

    }

    @When("the customer clicks preis dropdown")
    public void the_customer_clicks_preis_dropdown() {

        BrowserUtils.waitFor(3);
        // click price dropdown
        searchPage.preisDDown.click();

    }



    @And("the customer set the price between {string} and {string}")
    public void theCustomerSetThePriceBetweenAnd(String fromP, String toP) {

        //send required price from-to
        searchPage.setPrice(fromP,toP);
        BrowserUtils.waitFor(4);
        searchPage.setPriceArrow.click();


    }



    @Then("the customer selects {string} product")
    public void the_customer_selects_product(String string) {




    }





    @Then("the search result should contain {string}")
    public void theSearchResultShouldContain(String expTxt) {

        //verify result contains expected text
      String actSearchResult = searchPage.searcResult.getText();
      Assert.assertTrue("verify result word",actSearchResult.contains(expTxt));


    }

}
