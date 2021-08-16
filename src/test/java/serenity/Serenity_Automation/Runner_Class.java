package serenity.Serenity_Automation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "Resources/Features", tags ="@AspirationTest")
public class Runner_Class {

}
