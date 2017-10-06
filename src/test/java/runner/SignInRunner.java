package runner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features = {"classpath:featurefiles/SignIn.feature"}, glue = {
		"classpath:stepdefinations", "classpath:utils"})
public class SignInRunner {

}
