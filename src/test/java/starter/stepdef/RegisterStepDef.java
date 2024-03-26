package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class RegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Register user with valid json {string}")
    public void registerUserWithValidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        reqresAPI.postRegisterUser(jsonFile);
    }

    @When("Send request post login")
    public void sendRequestPostLogin() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @And("Response body name should be {int}")
    public void responseBodyNameShouldBe(int id) {
        SerenityRest.and()
                .body(ReqresResponses.ID, equalTo(id));
    }


    @Given("Register user with invalid json {string}")
    public void registerUserWithInvalidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        reqresAPI.postRegisterUser(jsonFile);
    }


}
