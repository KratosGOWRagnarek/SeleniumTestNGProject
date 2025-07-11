package testNGconcept.parallelTesting;

import org.testng.annotations.Test;

public class SingUpTests {
@Test
    public void signUpWithEmail() throws InterruptedException {
      Thread.sleep(2000);
    }
@Test
    public void signUpWithMobile() throws InterruptedException {
        Thread.sleep(2000);
    }
@Test
    public void invalidSignUp() throws InterruptedException {

        Thread.sleep(2000);
    }
}
