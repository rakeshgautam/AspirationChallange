package AspirationUI;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;
import reUsables.ReUsableFunctions;
public class HomePage extends PageObject{
    
    @FindBy(xpath = "//*[@id=\"__next\"]/div/header/ul[1]/li[1]/a")
    public WebElementFacade SpendAndSave;
    
    
    ReUsableFunctions reUse = new ReUsableFunctions();
    HashMap<String, String> hm = new HashMap<String, String>();
    
    public void launchAspiration() throws  Exception {
        getDriver().manage().window().maximize();
        getDriver().navigate().to(reUse.loadURLUsernamePassword(reUse.readPomProperty("app.env")+"_AspirationUI"));
    }
    
	public void navigate_to_SpendAndSave() {
		SpendAndSave.click();
	}
    
    
   	

 
}