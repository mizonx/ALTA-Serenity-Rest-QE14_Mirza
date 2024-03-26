package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserTugasStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Create user with Valid json {string}")
    public void createUserWithValidJson(String json) {
        File jsonFileTugas = new File(Constants.REQ_BODY + json);
        reqresAPI.postCreateUser(jsonFileTugas);
    }

    @When("Send request Create new user")
    public void sendRequestCreateNewUser() {
        SerenityRest.when()
                .post(ReqresAPI.CREATE_USER);
    }

    @And("Response body name should be {} and {string}")
    public void responseBodyNameShouldBeAnd(String name1, String job1) {
        SerenityRest.and()
                .body(ReqresResponses.Name, equalTo(name1))
                .body(ReqresResponses.Job, equalTo(job1));
    }

    @And("Valida json schema {string}")
    public void validaJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA + json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


//    @And("Validate json schema {string}")
//    public void validateJsonSchema(String json) {
//        File jsonFile = new File(Constants.JSON_SCHEMA+ json);
//        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
//    }

}
