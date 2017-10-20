package runner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features = {"classpath:"}, glue = {
		"classpath:stepdefinations", "classpath:utils", "classpath:resources"})
public class SignInRunner {

}
