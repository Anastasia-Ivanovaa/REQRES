package tests;

import models.UpdateUserRq;
import models.UpdateUserRs;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static adapters.UsersAPI.updateUserName;

public class UpdateUserNameTest {

    @Test
    public void checkUpdateUserName() {
        SoftAssert softAssert = new SoftAssert();

        UpdateUserRq rq = UpdateUserRq.builder()
                .name("Sam")
                .job("zion resident")
                .build();

        UpdateUserRs rs = updateUserName(rq);

        softAssert.assertEquals(rs.getName(), "Sam", "Invalid name");
        softAssert.assertEquals(rs.getJob(), "zion resident", "Invalid job");
        softAssert.assertAll();
    }
}
