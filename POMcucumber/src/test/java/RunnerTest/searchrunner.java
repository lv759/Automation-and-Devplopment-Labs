package RunnerTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="D://EclipseWorkspace1//selfpractice//POMcucumber//src//main//java//Feature_POM//search.feature",glue= {"Pages_POM/SearchPage.java"})
public class searchrunner {

}
