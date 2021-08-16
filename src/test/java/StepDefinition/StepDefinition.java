package StepDefinition;


import io.restassured.response.Response;

import net.serenitybdd.core.pages.PageObject;

import net.thucydides.core.annotations.Step;

import reUsables.ReUsableFunctions;
import reUsables.WebServices;




import AspirationUI.HomePage;
import AspirationUI.ProductPage;
import SwApi.SwApi;


public class StepDefinition extends PageObject {

	ReUsableFunctions reUse = new ReUsableFunctions();
	WebServices ws = new WebServices();



	Response rs = null;
	HomePage homePage=new HomePage();
	ProductPage productPage=new ProductPage();
	SwApi swApi=new SwApi();

	@Step("User is on the Aspiration home page")
	public void LaunchAspiration() throws Exception {
		homePage.launchAspiration();
	}
	
	@Step("User clicks on Spead and Save")
	public void Navigate_to_SpendAndSave() {
			homePage.navigate_to_SpendAndSave();
	}
	
	@Step("User should be able to see all products")
	public void ValidateProducts(String ProductList) {
		productPage.validateProducts(ProductList);
		}
	@Step("User clicks on Get Aspiration link")
	public void Navigate_to_Get_Asiparation() {
		productPage.navigate_to_Get_Asiparation();
		}
	@Step("User should be able to see Email signbox box")
	public void Email_Signup_Box() {
		productPage.email_Signup_Box();
		}
	@Step("User clicks on Get AspirationPlus link")
	public void Navigate_to_Get_AsiparationPlus() {
		productPage.navigate_to_Get_AsiparationPlus();
		}
	@Step("User should be able to see all Monthly and Yearly plan")
	public void Validate_Yearly_and_Monthly_plan(String MonthlyPlan, String YearlyPlan) {
		productPage.validate_Yearly_and_Monthly_plan(MonthlyPlan,YearlyPlan);
		}
	
	@Step("User sends get request to SWAPI people method")
	public void GetSwApiResponse() {
		swApi.getSwApiResponse();
		}
	
	@Step("User gets success response with Status code as \"(.*)\"")
	public void GetSwApiResponseStatusCodeCheck(String statusCode) {
		swApi.getSwApiResponseStatusCodeCheck(statusCode);
		}
	
	@Step("People having Height greater than 200")
	public void validateHeight(String PeopleCount) {
		swApi.validateHeight(PeopleCount);
		}
	
	@Step("Verify returned name")
	public void  ValidateReturPeopleName(String NameList) {
		swApi.validateReturPeopleName(NameList);
		}
	
	@Step("Verify Total number of people")
	public void ValidateTotalChekcedPeople(String PeopleCount) {
		swApi.validateTotalChekcedPeople(PeopleCount);
		}
	

}
