package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static adapters.UsersAPI.deleteUser;

public class DeleteUserTest {

    @Test
    public void checkDeleteUser() {
        Response response = deleteUser();
        Assert.assertEquals(response.getStatusCode(), 204, "Invalid status code");
    }
}
