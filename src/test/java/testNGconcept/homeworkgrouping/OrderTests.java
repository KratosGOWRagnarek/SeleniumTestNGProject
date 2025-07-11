package testNGconcept.homeworkgrouping;

import org.testng.annotations.Test;

public class OrderTests {
    @Test(groups = {"smoke","order"})
    public void createOrder(){

    }
    @Test (groups = {"regression","order"})
    public void cancelOrder(){

    }
    @Test(groups = "order")
    public void trackOrder(){

    }

}
