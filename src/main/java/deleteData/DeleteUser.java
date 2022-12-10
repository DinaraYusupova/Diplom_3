package deleteData;

import dataGenerator.Credentials;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class DeleteUser {
    private static final String PATH_LOGIN = "/api/auth/login";
    private  static final String PATH_DELETE_AND_CHANGE = "/api/auth/user";

    @Step("Delete user")
    public void deleteUser() throws InterruptedException {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        Credentials credentials = Credentials.from();
        Thread.sleep(1000);
        ValidatableResponse responseLogin = login(credentials);
        Thread.sleep(1000);
        String accessToken = responseLogin.extract().path("accessToken");
        delete(accessToken);
    }


    public ValidatableResponse login(Credentials credentials){
        return given()
                .header("Content-type", "application/json")
                .log().all()
                .and()
                .body(credentials)
                .when()
                .post(PATH_LOGIN)
                .then()
                .log().all();
    }
    public ValidatableResponse delete(String accessToken){
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .log().all()
                .when()
                .delete(PATH_DELETE_AND_CHANGE)
                .then()
                .log().all();
    }
}
