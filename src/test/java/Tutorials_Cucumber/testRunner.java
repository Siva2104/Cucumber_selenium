package Tutorials_Cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\1925566\\eclipse-workspace\\Prac_CucumberJava\\src\\test\\resources\\Features",
glue= {"Tutorials_Cucumber"},monochrome=true, plugin = {"pretty","html:target/HtmlReports/"})
public class testRunner {

}
