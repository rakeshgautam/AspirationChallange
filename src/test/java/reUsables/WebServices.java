package reUsables;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.configuration.ConfigurationException;

import com.google.common.io.Files;
import com.thoughtworks.xstream.io.path.Path;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class WebServices {
	ReUsableFunctions reUse = new ReUsableFunctions();
	
	public Response PostSOAPExecution(String URL, String payload, String path) throws IOException, ConfigurationException {
		
		if((path!=null)){
		Response rs = SerenityRest.given().body(readFile(path)).when().post(URL);
		return rs;
		} else {
			Response rs = SerenityRest.given().contentType("text/xml;charset=UTF-8").body(payload).when().post(URL);
			return rs;
		}
	}
	
	public Response PostRestExecution(String URL, String payload, Headers headersList) {
		Response rs=null;
		if(headersList!=null) {
			if(payload != null) {
				rs = SerenityRest.given().headers(headersList).body(payload).when().post(URL);
				
				} else
				{
					rs = SerenityRest.given().headers(headersList).when().post(URL);
					
				}
				return rs;
			} else {
				if(payload != null) {
					rs = SerenityRest.given().body(payload).when().post(URL);
					
					} else
					{
						rs = SerenityRest.given().when().post(URL);
					}
					return rs;
			}
	}
	
	public Response PatchRestExecution(String URL, String payload, Headers headersList) {
		Response rs=null;
		if(headersList!=null) {
			if(payload != null) {
				rs = SerenityRest.given().headers(headersList).body(payload).when().patch(URL);
				
				} else
				{
					rs = SerenityRest.given().headers(headersList).when().patch(URL);
					
				}
				return rs;
			} else {
				if(payload != null) {
					rs = SerenityRest.given().body(payload).when().patch(URL);
					
					} else
					{
						rs = SerenityRest.given().when().patch(URL);
					}
					return rs;
			}
	}
	
	public Response GetRestExecution(String URL, String payload, Headers headersList) {
		
//		System.out.println(URL);
//		System.out.println(payload);
		//System.out.println(headersList);
		
		Response rs=null;
			if(headersList!=null) {
				if(payload != null) {
					rs = SerenityRest.given().headers(headersList).body(payload).when().get(URL);
				
				} else
				{
					rs = SerenityRest.given().headers(headersList).when().get(URL);
				}
				return rs;
			} else {
				if(payload != null) {
					rs = SerenityRest.given().body(payload).when().get(URL);
					} else
					{
							rs = SerenityRest.given().when().get(URL);
					}
					return rs;
			}
	}
	public String readFile(String path) throws IOException{
        StringBuilder sb = new StringBuilder();
        String sCurrentLine;
        try (BufferedReader br = new BufferedReader(new FileReader(path))){

    while ((sCurrentLine = br.readLine()) != null) {
        sb.append(sCurrentLine);
    	}

      }

      return sb.toString();
	}
	
	public Response DeleteRestExecution(String URL, String payload, Headers headersList) {
		Response rs=null;
		if(headersList!=null) {
			if(payload != null) {
				rs = SerenityRest.given().headers(headersList).body(payload).when().delete(URL);
				
				} else
				{
					rs = SerenityRest.given().headers(headersList).when().delete(URL);
					
				}
				return rs;
			} else {
				if(payload != null) {
					rs = SerenityRest.given().body(payload).when().delete(URL);
					
					} else
					{
						rs = SerenityRest.given().when().delete(URL);
					}
					return rs;
			}
	}

	public void extractTN(Response rs) throws IOException, ConfigurationException {
		XmlPath xml = new XmlPath(rs.asString());
		String TN= xml.getString("Envelope.Body.VOIPTNAssignmentResponse.TNCollection.TN");
		reUse.setData("TN", TN);
	}
	
	public String extractValueJson(Response rs, String path) {
		JsonPath json = new JsonPath(rs.asString());
		String output = json.getString(path);
		return output;
	}
}
