package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class TestCases extends Base{

/*
Test Case 1:
Test name = Validate Carvana home page title and url
Test priority = 1
Given user is on "https://www.carvana.com/"
Then validate title equals to "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
And validate url equals to "https://www.carvana.com/"

 */

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void testHomePageTitleAndURL(){

        driver.get("https://www.carvana.com/");

        String s = "Carvana | Buy & Finance Used Cars Online | At Home Delivery";

        Assert.assertEquals(driver.getTitle(), s);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");


    }

    /*
    Test Case 2:
Test name = Validate the Carvana logo
Test priority = 2
Given user is on "https://www.carvana.com/"
Then validate the logo of the “Carvana” is displayed

     */

    @Test(priority = 2, description = "Validate the Carvana logo")
    public void testLogo(){

        driver.get("https://www.carvana.com/");
        Assert.assertTrue(carvanaPage.carvanaLogo.isDisplayed());

    }

    /*
    Test Case 3:
Test name = Validate the main navigation section items
Test priority = 3
Given user is on "https://www.carvana.com/"
Then validate the navigation section items below are displayed
|HOW IT WORKS     	|
|ABOUT CARVANA    	|
|SUPPORT & CONTACT	|

     */

    @Test(priority = 3, description = "Validate the main navigation section items")
    public void testSectionItems(){

        driver.get("https://www.carvana.com/");
        Assert.assertTrue(carvanaPage.howItWorks.isDisplayed());
        Assert.assertTrue(carvanaPage.aboutCarvana.isDisplayed());
        Assert.assertTrue(carvanaPage.supportContact.isDisplayed());

    }


    @Test(priority = 4, description = "Validate the sign in error message")
    public void testSignInErrorMessage(){

        driver.get("https://www.carvana.com/");
        carvanaPage.signInButton.click();
        carvanaPage.signInModal.isDisplayed();
        carvanaPage.emailInput.sendKeys("johndoe@gmail.com");
        carvanaPage.passwordInput.sendKeys("abcd1234");
        carvanaPage.signInModalButton.click();
        Waiter.pause(2);
        Assert.assertEquals(carvanaPage.errorMessage.getText(), "Email address and/or password combination is incorrect\n" +
                "Please try again or reset your password.");



    }


    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void testSearchFilter(){

        driver.get("https://www.carvana.com/");

        Waiter.pause(2);

        carvanaPage.searchCarsLinks.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        String[] filterOptions = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE",
                "FEATURES", "MORE FILTERS"};

        for(int i = 0; i < filterOptions.length; i++){

            Assert.assertEquals(filterOptions[i], carvanaPage.filterOptions.get(i).getText());


        }

    }

    /*
Make sure each result tile is displayed with below information
1. an image
2. add to favorite button
3. tile body
ALSO VALIDATE EACH TILE BODY:
Make sure each tile body has below information
1. Inventory type - text should be displayed and should not be null
2. Year-Make-Model information - text should be displayed and should not be null
3. Trim-Mileage information - text should be displayed and should not be null
4. Price - Make sure that each price is more than zero
5. Monthly Payment information - text should be displayed and should not be null
6. Down Payment information - text should be displayed and should not be null
7. Delivery chip must be displayed as “Free Shipping”

     */

    @Test(priority = 6, description = "Validate the search result tiles")
    public void testSearchResult(){

        driver.get("https://www.carvana.com/");
        Waiter.pause(3);

        carvanaPage.searchCarsLinks.click();

        Waiter.pause(2);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        carvanaPage.searchBar.sendKeys("mercedes-benz");

        carvanaPage.goButton.click();

        Waiter.pause(2);

        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));

        for (WebElement carImage : carvanaPage.carImages) {
            Assert.assertTrue(carImage.isDisplayed());
            Assert.assertNotNull(carImage);
        }
        for (WebElement favoriteButton : carvanaPage.favoriteButtons) {
            Assert.assertTrue(favoriteButton.isDisplayed());
            Assert.assertNotNull(favoriteButton);
        }
        for (WebElement inventoryType : carvanaPage.inventoryTypes) {
            Assert.assertTrue(inventoryType.isDisplayed());
            Assert.assertNotNull(inventoryType);
        }
        for (WebElement yearMakeModel : carvanaPage.yearMakeModels) {
            Assert.assertTrue(yearMakeModel.isDisplayed());
            Assert.assertNotNull(yearMakeModel);
        }
        for (WebElement trimAndMileage : carvanaPage.trimAndMileages) {
            Assert.assertTrue(trimAndMileage.isDisplayed());
            Assert.assertNotNull(trimAndMileage);
        }
        for (WebElement price : carvanaPage.prices) {
            Assert.assertTrue(price.isDisplayed());
            Assert.assertTrue(Integer.parseInt(price.getText().replaceAll("\\D", "")) > 0);
        }
        for (WebElement monthlyPayment : carvanaPage.monthlyPayments) {
            Assert.assertTrue(monthlyPayment.isDisplayed());
            Assert.assertNotNull(monthlyPayment);
        }
        for (WebElement downPayment : carvanaPage.downPayments) {
            Assert.assertTrue(downPayment.isDisplayed());
            Assert.assertNotNull(downPayment);
        }
        for (WebElement deliveryChip : carvanaPage.deliveryChips) {
            Assert.assertTrue(deliveryChip.isDisplayed());
            Assert.assertNotNull(deliveryChip);
        }



    }




}
