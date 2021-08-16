package serenity.Serenity_Automation;

import StepDefinition.StepDefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.vavr.collection.HashMap;
import net.serenitybdd.core.pages.PageObject;

public class Test_Steps extends PageObject {

	StepDefinition userSteps;
	

	// =======================ServiceDelivery===============================
	
	
	@Given("User is on the Aspiration home page")
	public void i_am_on_the_Aspiration_home_page() throws Exception {
		userSteps.LaunchAspiration();
	}

	@When("User clicks on Spead and Save")
	public void User_clicks_on_Spead_and_Save() {
		userSteps.Navigate_to_SpendAndSave();
	}

	@Then("User should be able to see all products \"(.*)\"")
	public void User_should_be_able_to_see_all_products(String ProductList) {
		userSteps.ValidateProducts(ProductList);
	}

	@When("User clicks on Get Aspiration link")
	public void User_clicks_on_Get_Aspiration_link() {
		userSteps.Navigate_to_Get_Asiparation();
	}

	@Then("User should be able to see Email signbox box")
	public void User_should_be_able_to_see_Email_signbox_box() throws InterruptedException {
		userSteps.Email_Signup_Box();
		Thread.sleep(3000);
	}

	@When("User clicks on Get AspirationPlus link")
	public void User_clicks_on_Get_AspirationPlus_link() {
		userSteps.Navigate_to_Get_AsiparationPlus();
	}

	@Then("User should be able to see all Monthly \"(.*)\" and Yearly plan \"(.*)\"")
	public void User_should_be_able_to_see_all_Monthly_and_Yearly_plan(String MonthlyPlan, String YearlyPlan) {
		userSteps.Validate_Yearly_and_Monthly_plan(MonthlyPlan, YearlyPlan);
	}
	
	
	@Given("User sends get request to SWAPI people method")
	public void User_sends_get_request_to_SWAPI_people_method() {
		userSteps.GetSwApiResponse();
	}

	@Given("User gets success response with Status code as \"(.*)\"")
	public void User_gets_success_response(String statusCode) {
		userSteps.GetSwApiResponseStatusCodeCheck(statusCode);
	}

	@Given("People having Height greater than Two Hundereds is \"(.*)\"")
	public void People_having_Height_greater_than_200(String PeopleCount) {
		userSteps.validateHeight(PeopleCount);
	}

	@Given("Verify returned name conatins \"(.*)\"")
	public void Verify_returned_name(String NameList) {
		userSteps.ValidateReturPeopleName(NameList);
	}

	@Given("Verify Total number of people Count \"(.*)\"")
	public void Verify_Total_number_of_people(String PeopleCount) {
		userSteps.ValidateTotalChekcedPeople(PeopleCount);
	}


}
