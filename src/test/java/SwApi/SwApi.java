package SwApi;

import static org.junit.Assert.assertTrue;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;

public class SwApi {
	
	Response response;


	public void getSwApiResponse() {
		RestAssured.baseURI = "https://swapi.dev/api";
		RequestSpecification httpRequest = RestAssured.given();
		response = httpRequest.get("/people");
	}

	
	public void getSwApiResponseStatusCodeCheck(String statusCode) {
		assertTrue(response.getStatusCode() == Integer.parseInt(statusCode));
	}

	
	public void validateHeight(String PeopleCount) {
		getSwApiResponse();
		JsonPath jsonPathEvaluator = response.jsonPath();
		List<String> allHeights = jsonPathEvaluator.getList("results.height");
		int noOfPeople = 0;
		for (int i = 0; i < allHeights.size(); i++) {
			if (Integer.parseInt(allHeights.get(i)) >= 200) {
				noOfPeople = noOfPeople + 1;
			}
		}
		assertTrue(noOfPeople == Integer.parseInt(PeopleCount));
	}

	
	public void validateReturPeopleName(String NameList) {
		getSwApiResponse();
		JsonPath jsonPathEvaluator = response.jsonPath();
		List<String> allNames = jsonPathEvaluator.getList("results.name");
		String[] allNamesEx = NameList.split(",");
		for (String var : allNamesEx) {
			assertTrue(allNames.contains(var));
		}
	}

	
	public void validateTotalChekcedPeople(String PeopleCount) {
		getSwApiResponse();
		String jsonString = response.asString();
		assertTrue(
				Integer.parseInt(JsonPath.from(jsonString).get("count").toString()) == Integer.parseInt(PeopleCount));
	}
}
