package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaPage {

    public CarvanaPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".fSZhVx svg")
    public WebElement carvanaLogo;

    @FindBy(className = "kQizBt")
    public WebElement howItWorks;

    @FindBy(className = "eNcYVl")
    public WebElement aboutCarvana;

    @FindBy(className = "hAARzw")
    public WebElement supportContact;

    @FindBy(className = "fAUeCR")
    public WebElement signInButton;

    @FindBy(className = "foFKYF")
    public WebElement signInModal;

    @FindBy(id = "usernameField")
    public WebElement emailInput;

    @FindBy(id = "passwordField")
    public WebElement passwordInput;

    @FindBy(className = "eYzGHQ")
    public WebElement signInModalButton;

    @FindBy(className = "dhUWhc")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@data-cv-test='headerSearchLink']")
    public WebElement searchCarsLinks;

    @FindBy(xpath = "//div[@data-qa='menu-flex']/button")
    public List<WebElement> filterOptions;

    @FindBy(className = "react-autosuggest__input")
    public WebElement searchBar;

    @FindBy(className = "iPPBRN")
    public WebElement goButton;

    @FindBy(className = "//section[@id='results-section']/div\n")
    public List<WebElement> carInventory;

    //Tile Validation Elements
    @FindBy(css = ".vehicle-image>img")
    public List<WebElement> carImages;

    @FindBy(css = ".favorite-vehicle>svg")
    public List<WebElement> favoriteButtons;

    @FindBy(className = "inventory-type-variant")
    public List<WebElement> inventoryTypes;

    @FindBy(css = ".make-model>div")
    public List<WebElement> yearMakeModels;

    @FindBy(className = "trim-mileage")
    public List<WebElement> trimAndMileages;

    @FindBy(className = "price")
    public List<WebElement> prices;

    @FindBy(className = "monthly-payment")
    public List<WebElement> monthlyPayments;

    @FindBy(className = "down-payment")
    public List<WebElement> downPayments;

    @FindBy(className = "delivery-chip")
    public List<WebElement> deliveryChips;



}
