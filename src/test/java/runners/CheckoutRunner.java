package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features",   
    glue = {"utils","steps"},                 
    plugin = {
        "pretty",                               
        "html:target/cucumber-reports.html",    
        "json:target/cucumber.json"             
    }              
)
public class CheckoutRunner extends AbstractTestNGCucumberTests {

}
