package testNGconcept.grouping;

import org.testng.annotations.Test;

public class CheckoutTests {

    @Test(groups = {"checkout","regression"})
    public void addItemToCart(){

    }
    @Test (groups = {"checkout","regression"})
    public void applyCouponCode(){

    }

    @Test (groups = {"smoke","regression","checkout"})
    public void completeCheckout(){


    }
}
