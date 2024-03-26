package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class PostLoginStepDef {
    @Steps
    ReqresAPI reqresAPI;


    @Given(": Login user with invalid {string}")
    public void loginUserWithInvalid(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        reqresAPI.postLoginFeature(jsonFile);
    }

    @Given("Login user with email and password with valid json {string}")
    public void loginUserWithEmailAndPasswordWithValidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        reqresAPI.postLoginFeature(jsonFile);
    }
}


//    @Then("Status should be {int}")
//    public void statusShouldBe(int statusShould) {
//        SerenityRest.then().statusCode(statusShould);
//    }
//
//
//    @And("Validate json schema {string}")
//    public void validateJsonSchema(String json) {
//        File jsonFile = new File(Constants.JSON_SCHEMA+ json);
//        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
//    }



