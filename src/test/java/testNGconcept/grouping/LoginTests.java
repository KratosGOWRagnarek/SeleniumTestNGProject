package testNGconcept.grouping;

import org.testng.annotations.Test;

public class LoginTests {

    @Test (groups = {"regression","smoke"})
    public void validLogin(){

    }

    @Test(groups = {"login","regression"})
    public void invalidLogin(){


    }

    @Test(groups = {"login","regression"})
    public void forgotPassword(){


    }
}
