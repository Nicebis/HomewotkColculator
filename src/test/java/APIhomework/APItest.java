package APIhomework;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class APItest {
    private static final String Base_URL = "https://gorest.co.in/public-api";
    private static final String Users = Base_URL + "/users";
    private static final String Post = Base_URL + "/posts";
    private static final String Comments = Base_URL + "/comments";

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeSuite
    public void beforeSuite() {

        requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setContentType(ContentType.JSON)
                .build()
                .header(new Header("Authorization",
                        "Bearer cb6f89467475aa6aacf1ff422f0bc147098caef74fc6e1651300580f299fb9d1"));

        responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();

        RestAssured.baseURI = Base_URL;
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }

    @Test
    void getUsersAllTest() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(Users)
                .then()
                .statusCode(200)
                .body("code", Matchers.equalTo(200))
                .body("meta.pagination.page", Matchers.equalTo(1))
                .body("meta.pagination.limit", Matchers.equalTo(10))
                .body("data.id", Matchers.not(Matchers.emptyOrNullString()))
                .body("data.name", Matchers.not(Matchers.emptyOrNullString()))
                .body("data.email", Matchers.not(Matchers.emptyOrNullString()))
                .body("data.gender", Matchers.not(Matchers.emptyOrNullString()))
                .body("data.status", Matchers.not(Matchers.emptyOrNullString()));
    }

    @Test
    void CreateUserTest() {
        var faker = new Faker();
        var newName = faker.name().fullName();
        var newGender = faker.demographic().sex();
        var newEmail = faker.internet().emailAddress();
        var random = new SecureRandom();
        var statusList = Arrays.asList("active", "inactive");
        var newRandomStatus = statusList.get(random.nextInt(statusList.size()));
        //var personRequest = Create.builder()
                //.name(newName)
               // .gender(newGender)
                //.email(newEmail)
                //.status(newRandomStatus)
                //.build();
        given()
                .when()
                .post(Users)
                .then()
                .statusCode(200)
                .body("data.id", Matchers.not(Matchers.emptyOrNullString()))
                .body("data.name", Matchers.equalTo(newName))
                .body("data.email", Matchers.equalTo(newEmail))
                .body("data.gender", Matchers.equalTo(newGender))
                .body("data.status", Matchers.equalTo(newRandomStatus));
    }
    @Test
    void GetRandomUserTest(){
        var randomId = new Random().nextInt(3800);
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(Users+"/"+randomId)
                .then()
                .statusCode(200)
                .body("data.id",Matchers.equalTo(randomId))
                .body("data.name", Matchers.not(Matchers.emptyOrNullString()))
                .body("data.email", Matchers.not(Matchers.emptyOrNullString()))
                .body("data.gender", Matchers.not(Matchers.emptyOrNullString()))
                .body("data.status", Matchers.not(Matchers.emptyOrNullString()));
    }
    @Test
    void DeleteRandomUser(){
        var randomId = new Random().nextInt(3800);
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete(Users+"/"+randomId)
                .then()
                .statusCode(200)
                .body("code", Matchers.equalTo(204))
                .body("meta", Matchers.equalTo(null))
                .body("data", Matchers.equalTo(null));
    }
    @Test
    void GetAllPostTest(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(Post)
                .then()
                .statusCode(200)
                .body("code", Matchers.equalTo(200))
                .body("meta.pagination.page", Matchers.equalTo(1))
                .body("meta.pagination.limit", Matchers.equalTo(10))
                .body("data.id", Matchers.not(Matchers.emptyOrNullString()))
                .body("data.name", Matchers.not(Matchers.emptyOrNullString()))
                .body("data.email", Matchers.not(Matchers.emptyOrNullString()))
                .body("data.gender", Matchers.not(Matchers.emptyOrNullString()))
                .body("data.status", Matchers.not(Matchers.emptyOrNullString()));
    }
}
