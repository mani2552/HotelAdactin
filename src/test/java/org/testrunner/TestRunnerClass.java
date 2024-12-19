package org.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags= "", features= {"src/test/resources/Features/HotelAdactin.feature"},
glue = "org.steps",
plugin = {"pretty","html:target/htmlreport.html"})
public class TestRunnerClass extends AbstractTestNGCucumberTests {

}
