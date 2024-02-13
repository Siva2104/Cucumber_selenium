package StepDefinition;




import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\1925566\\eclipse-workspace\\Prac_CucumberJava\\src\\test\\resources\\Features\\",
glue= {"tut_3_parametization"},monochrome=true, plugin = {"pretty","html:target/HtmlReports/"})
public class Testrunner {
	
	
	
	

}