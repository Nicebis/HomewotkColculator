package APIhomework;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PeopleClient {
    private static final String Base_URL = "https://gorest.co.in/public-api";
    private static final String Users = Base_URL + "/users";
    private static final String Post = Base_URL + "/posts";
    private static final String Comments = Base_URL + "/comments";
    public Response getPeople(Map<String,Object> queryParams){
        return given()
                .queryParams(queryParams)
                .when()
                .get(Users)
                .thenReturn();
    }
    public Response CreateUser(CreateUsersRequestData requestUser){
        return given()
                .body(requestUser)
                .when()
                .post(Users)
                .thenReturn();
    }
    public Response GetAllUsers(){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(Users)
                .thenReturn();
    }
    public Response GetRandomUser(Integer randomId){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(Users+"/"+randomId)
                .thenReturn();
    }
    public Response DeleteRandomUser(Integer randomId){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .delete(Users+"/"+randomId)
                .thenReturn();
    }
    public Response UpdateUser(Integer randomId,Map<String,Object> persona){
        return given()
                .body(persona)
                .when()
                .put(Users+"/"+randomId)
                .thenReturn();
    }
}
