package tests;

import models.CreateUserRq;
import models.CreateUserRs;
import org.testng.Assert;
import org.testng.annotations.Test;

import static adapters.UsersAPI.createUser;

public class CreateUserTest {

    @Test
    public void checkCreateUser() {

        CreateUserRq rq = CreateUserRq.builder()
                .name("morpheus")
                .job("leader")
                .build();

        CreateUserRs rs = createUser(rq);

        Assert.assertEquals(rs.getName(),"morpheus","Invalid name");
        Assert.assertEquals(rs.getJob(),"leader", "Invalid job");
    }
}
