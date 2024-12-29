package tests;

import models.UsersRs;
import org.testng.Assert;
import org.testng.annotations.Test;

import static adapters.UsersAPI.getUsers;

public class ListUsersTest {

    @Test
    public void checkListOfUsers() {
        UsersRs rs = getUsers();
        Assert.assertEquals(rs.getPerPage(), 6, "Invalid page number");
        Assert.assertEquals(rs.getTotal(), 12, "Invalid total number");
    }
}
