package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class GetSingleUser {
    @Steps
    ReqresAPI reqresAPI;

    //    Positive
    @Given("Get single user with valid id {int}")
    public void getSingleUserWithValidId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(reqresAPI.SINGLE_USER);
    }

    //      Negative
    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidId(String id) {
        reqresAPI.getSingleUserWithInvalidId(id);
    }

}
