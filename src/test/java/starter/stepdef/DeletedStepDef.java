package starter.stepdef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeletedStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete user with valid user id {int}")
    public void deleteUserWithValidUserId(int id) {
        reqresAPI.deleteUser(id);
    }
}
