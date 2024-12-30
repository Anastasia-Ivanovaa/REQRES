package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.*;

import static io.restassured.RestAssured.given;

public class UsersAPI {

    public static String URL = "https://reqres.in/api/users";

    public static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static RequestSpecification spec =
                given()
                    .log().all()
                    .contentType(ContentType.JSON);

    public static UsersRs getUsers() {
        return
                given()
                        .spec(spec)
                .when()
                        .get(URL + "?page=2")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .body()
                        .as(UsersRs.class);
    }

    public static CreateUserRs createUser(CreateUserRq createUserRq) {
        return
                given()
                    .spec(spec)
                    .body(gson.toJson(createUserRq))
                .when()
                     .post(URL)
                     .then()
                     .log().all()
                     .statusCode(201)
                     .extract()
                     .as(CreateUserRs.class);
    }

    public static Response deleteUser() {
        return
                given()
                    .spec(spec)
                .when()
                    .delete(URL + "/2")
                    .then()
                    .log().all()
                    .extract().response();
    }

    public static UpdateUserRs updateUser(UpdateUserRq updateUserRq){
        return
                given()
                    .spec(spec)
                    .body(gson.toJson(updateUserRq))
                .when()
                    .put(URL + "/2")
                    .then()
                    .log().all()
                    .statusCode(200)
                    .extract().response()
                    .as(UpdateUserRs.class);
    }

    public static UpdateUserRs updateUserName(UpdateUserRq updateUserRq){
        return
                given()
                        .spec(spec)
                        .body(gson.toJson(updateUserRq))
                .when()
                        .patch(URL + "/2")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response()
                        .as(UpdateUserRs.class);
    }
}
