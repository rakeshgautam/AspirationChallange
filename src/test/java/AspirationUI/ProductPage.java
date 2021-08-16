package AspirationUI;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;
import reUsables.ReUsableFunctions;
public class ProductPage extends PageObject{
    
    @FindBy(xpath ="//*[@class='plan-content']/h2[text()='Aspiration']")
    public WebElementFacade AspirationCard;
    
    @FindBy(xpath ="//*[@class='plan-content']/h2[text()='Aspiration Plus']")
    public WebElementFacade AspirationPlusCard;
    
    @FindBy(xpath ="//*[@ng-click=\"getAspirationOriginal()\"]" )
    public WebElementFacade GetAspiration;
    
    @FindBy(xpath ="//*[@ng-click=\"getAspirationPlus()\"]" )
    public WebElementFacade GetAspirationPlus;
    
    @FindBy(xpath ="//*[@id='join-waitlist-input']" )
    public WebElementFacade EmailField;
    
    @FindBy(xpath ="//*[@ng-class=\"{'selected': plan === 'yearly' }\"]//p/b" )
    public WebElementFacade YearlyPlanValue;
    
    @FindBy(xpath ="//*[@ng-class=\"{'selected': plan === 'monthly' }\"]//p/b" )
    public WebElementFacade MonthlyPlanValue;
    
    @FindBy(xpath ="//*[@class='close']" )
    public WebElementFacade Cancel;
    
	
	public void validateProducts(String ProductList) {
		String[] productList = ProductList.split(",");
		assertTrue(productList[0].contains(AspirationCard.getTextContent())
				& AspirationCard.isDisplayed());
		assertTrue(productList[1].contains(AspirationPlusCard.getTextContent())
				& AspirationPlusCard.isDisplayed());
	}

	
	public void navigate_to_Get_Asiparation() {
		GetAspiration.click();
	}

	
	public void email_Signup_Box() {
		assertTrue(EmailField.isDisplayed());
		Cancel.click();
	}

	
	public void navigate_to_Get_AsiparationPlus() {
		GetAspirationPlus.click();
	}


	public void validate_Yearly_and_Monthly_plan(String MonthlyPlan, String YearlyPlan) {
		assertTrue(YearlyPlanValue.getTextContent().equalsIgnoreCase(YearlyPlan)
				& (YearlyPlanValue).isDisplayed());
		assertTrue((MonthlyPlanValue).getTextContent().equalsIgnoreCase(MonthlyPlan)
				& (MonthlyPlanValue).isDisplayed());
	}
    
    
   	

 
}