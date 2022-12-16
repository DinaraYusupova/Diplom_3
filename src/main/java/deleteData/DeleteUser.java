package deleteData;

import dataGenerator.Credentials;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class DeleteUser extends Client {
    private static final String PATH_LOGIN = "/api/auth/login";
    private  static final String PATH_DELETE_AND_CHANGE = "/api/auth/user";

    @Step("Delete user")
    public void deleteUser() {
        Credentials credentials = Credentials.from();
        ValidatableResponse responseLogin = login(credentials);
        String accessToken = responseLogin.extract().path("accessToken");
        delete(accessToken);
    }


    private ValidatableResponse login(Credentials credentials){
        return given()
                .spec(getSpec())
                .log().all()
                .and()
                .body(credentials)
                .when()
                .post(PATH_LOGIN)
                .then()
                .log().all();
    }
    private ValidatableResponse delete(String accessToken){
        return given()
                .spec(getSpec())
                .header("Authorization", accessToken)
                .log().all()
                .when()
                .delete(PATH_DELETE_AND_CHANGE)
                .then()
                .log().all();
    }
}
