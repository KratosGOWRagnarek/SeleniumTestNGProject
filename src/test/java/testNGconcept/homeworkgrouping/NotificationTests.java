package testNGconcept.homeworkgrouping;

import org.testng.annotations.Test;

public class NotificationTests {
    @Test(groups = "notification")
    public void sendEmailNotification(){

    }
    @Test(groups = {"notification","smoke"})
    public void sendSMSNotification(){

    }


}
