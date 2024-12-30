package tests;

import models.UsersRs;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static adapters.UsersAPI.getUsers;

public class ListUsersTest {

    @Test
    public void checkListOfUsers() {
        SoftAssert softAssert = new SoftAssert();
        UsersRs rs = getUsers();
        softAssert.assertEquals(rs.getPerPage(), 6, "Invalid page number");
        softAssert.assertEquals(rs.getTotal(), 12, "Invalid total number");
        softAssert.assertAll();
    }
}
