package tests;

import models.UpdateUserRq;
import models.UpdateUserRs;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static adapters.UsersAPI.updateUser;

public class UpdateUserTest {

    @Test
    public void checkUpdateUser() {
        SoftAssert softAssert = new SoftAssert();

        UpdateUserRq rq = UpdateUserRq.builder()
                .name("morpheus")
                .job("zion resident")
                .build();

        UpdateUserRs rs = updateUser(rq);

        softAssert.assertEquals(rs.getName(), "morpheus", "Invalid name");
        softAssert.assertEquals(rs.getJob(), "zion resident", "Invalid job");
        softAssert.assertAll();
    }
}
