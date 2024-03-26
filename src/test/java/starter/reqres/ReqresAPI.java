package starter.reqres;

import io.restassured.http.ContentType;
import jnr.constants.Constant;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.checkerframework.checker.units.qual.C;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {


    public static String LIST_USERS = Constants.BASE_URL + "/api/users?page={page} ";
    public static String CREATE_USER = Constants.BASE_URL + "/api/users";
    public static String UPDATE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL + "/api/users/{id}";

    public static String LOGIN_USER = Constants.BASE_URL + "/api/login";

    public static String REGISTER_USER = Constants.BASE_URL + "/api/register";

    public static String SINGLE_RESOURCE = Constants.BASE_URL + "/api/unknown/{id}";

    public static String SINGLE_USER = Constants.BASE_URL + "/api/users/{id}";

    @Step("Get list user with valid parameter page")
    public void getListUsers(int page) {
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Post create user with valid json")
    public void postCreateUser(File Json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(Json);
    }

    @Step("Update user with valid json and user id")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user with valid user id")
    public void deleteUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    // Tugas Login
    @Step("Login user with email and password")
    public void postLoginFeature(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    // Tugas Register
    @Step("Post Register")
    public void postRegisterUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    // Tugas Single Resource
    @Step("Single resource")
    public void getSingleUserResource(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }


    //Tugas Single User

    @Step("Get Single User")
    public void getSingleUser(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get Single User")
    public void getSingleUserWithInvalidId(String id) {
        SerenityRest.given().pathParam("id", id);
    }

    //Tugas Put User

    @Step("Update user with valid json and user id")
    public void putUpdateTugas(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}