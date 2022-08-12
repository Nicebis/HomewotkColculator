package APIhomework;

import com.github.javafaker.Faker;
import com.google.common.collect.ImmutableBiMap;
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
import java.util.Locale;
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
        var newGender = "female";
        var newEmail = faker.internet().emailAddress();
        var random = new SecureRandom();
        var statusList = Arrays.asList("active", "inactive");
        var newRandomStatus = statusList.get(random.nextInt(statusList.size()));
        var personRequest = CreateUsersRequestData.builder()
                .name(newName)
                .gender(newGender)
                .email(newEmail)
                .status(newRandomStatus)
                .build();
        given()
                .body(personRequest)
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
    void UpdateUserTest(){
        var randomId = new Random().nextInt(3800);
        var faker = new Faker();
        var updateName = faker.name().fullName();
        var updateEmail=faker.internet().emailAddress();
        var updateGender = faker.demographic().sex().toLowerCase(Locale.ROOT);
        var Random = new SecureRandom();
        var statusList = Arrays.asList("active", "inactive");
        var UpdateRandomStatus = statusList.get(Random.nextInt(statusList.size()));
        var person = CreateUsersRequestData.builder()
                .name(updateName)
                .gender(updateGender)
                .status(UpdateRandomStatus)
                .email(updateEmail)
                .build();
        given()
                .body(person)
                .when()
                .put(Users+"/"+randomId)
                .then()
                .statusCode(200)
                .body("data.name",Matchers.equalTo(updateName))
                .body("data.email",Matchers.equalTo(updateEmail))
                .body("data.gender",Matchers.equalTo(updateGender))
                .body("data.id",Matchers.equalTo(randomId))
                .body("data.status",Matchers.equalTo(UpdateRandomStatus));
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
    @Test
    void GetPostRandom(){
        var randomId = new Random().nextInt(1800);
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(Post+"/"+randomId)
                .then()
                .statusCode(200)
                .body("data.id",Matchers.equalTo(randomId))
                .body("data.user_id",Matchers.not(Matchers.emptyOrNullString()))
                .body("data.title",Matchers.not(Matchers.emptyOrNullString()))
                .body("data.body",Matchers.not(Matchers.emptyOrNullString()));
    }
    @Test
    void DeleteRandomPost(){
        var randomId = new Random().nextInt(900);
        given()
                .when()
                .delete(Post+"/"+randomId)
                .then()
                .statusCode(200)
                .body("code", Matchers.equalTo(204))
                .body("meta", Matchers.equalTo(null))
                .body("data", Matchers.equalTo(null));
    }
    @Test
    void UpdateRandomPostTest(){
        var randomUserId = new Random().nextInt(1800);
        var faker = new Faker();
        var newUserId = new Random().nextInt(3800);
        var updateTitle = faker.book().title();
        var updateBody = faker.harryPotter().quote();
        var updatePostRequest = CreatePostsRequestData.builder()
                        .body(updateBody)
                        .title(updateTitle)
                        .userId(newUserId)
                        .build();
        given()
                .body(updatePostRequest)
                .when()
                .put(Post+"/"+randomUserId)
                .then()
                .statusCode(200)
                .body("data.id",Matchers.equalTo(randomUserId))
                .body("data.user_id",Matchers.equalTo(newUserId))
                .body("data.title",Matchers.equalTo(updateTitle))
                .body("data.body",Matchers.equalTo(updateBody));

    }


}
