package testNGconcept;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersLogic {


    @Parameters("firstName")

    @Test
    public void person(String name){
        System.out.println("My name is " + name);
    }


    @Parameters({"brand", "color", "zipCode"})
    @Test
    public void order(String brand, String color, String zipCode){
        System.out.println(brand + color+ zipCode);
    }



}
