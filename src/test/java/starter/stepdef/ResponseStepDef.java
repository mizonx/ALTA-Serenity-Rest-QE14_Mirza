package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ResponseStepDef {


    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statuscode) {
        SerenityRest.then()
                .statusCode(statuscode);
    }

    @And("Response body page should be {string} and job is {string}")
    public void responseBodyPageShouldBeAndJobIs(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @And("Valide json schema {string}")
    public void valideJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA + json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


    //Tugas
    @Then("Status should be {int}")
    public void statusShouldBe(int statusShould) {
        SerenityRest.then().statusCode(statusShould);
    }


    @And("Validate json schema {string}")
    public void validateJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA + json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


}
