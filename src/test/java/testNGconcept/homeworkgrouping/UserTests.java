package testNGconcept.homeworkgrouping;

import org.testng.annotations.Test;

public class UserTests {
    @Test (groups = {"smoke","user"})
    public void registerUser(){

    }
    @Test (groups = {"regression","user"})
    public void deleteUser(){

    }
    @Test(groups = "regression")
    public void updateUserProfile(){

    }
}
