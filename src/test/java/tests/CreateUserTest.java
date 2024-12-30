package tests;

import models.CreateUserRq;
import models.CreateUserRs;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static adapters.UsersAPI.createUser;

public class CreateUserTest {

    @Test
    public void checkCreateUser() {
        SoftAssert softAssert = new SoftAssert();

        CreateUserRq rq = CreateUserRq.builder()
                .name("morpheus")
                .job("leader")
                .build();

        CreateUserRs rs = createUser(rq);
        softAssert.assertEquals(rs.getName(), "morpheus", "Invalid name");
        softAssert.assertEquals(rs.getJob(), "leader", "Invalid job");
        softAssert.assertAll();
    }
}
