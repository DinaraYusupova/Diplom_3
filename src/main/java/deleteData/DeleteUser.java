package deleteData;
//import DefaultUserData;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;



public class DeleteUser {
    private static final String PATH_LOGIN = "/api/auth/login";

    private  static final String PATH_DELETE_AND_CHANGE = "/api/auth/user";


    public void deleteUser() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";

        String defaultJson = "{\n" +
                "\"email\": \"uilogintest@yandex.ru\",\n" +
                "\"password\": \"123456\"\n" +
                "}\n";

        ValidatableResponse responseLogin = given()
                .header("Content-type", "application/json")
                .log().all()
                .and()
                .body(defaultJson)
                .when()
                .post(PATH_LOGIN)
                .then()
                .log().all();
        String accessToken = responseLogin.extract().path("accessToken");
        given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .log().all()
                .when()
                .delete(PATH_DELETE_AND_CHANGE)
                .then()
                .log().all();

    }

//    @Step("Login user")
//    public ValidatableResponse login(String defaultJson){
//        return given()
//                .header("Content-type", "application/json")
//                .log().all()
//                .and()
//                .body(defaultJson)
//                .when()
//                .post(PATH_LOGIN)
//                .then()
//                .log().all();
//    }
//
//
//    @Step("Delete user")
//    public ValidatableResponse delete(String accessToken){
//        return given()
//                .header("Content-type", "application/json")
//                .header("Authorization", accessToken)
//                .log().all()
//                .when()
//                .delete(PATH_DELETE_AND_CHANGE)
//                .then()
//                .log().all();
//    }
}
