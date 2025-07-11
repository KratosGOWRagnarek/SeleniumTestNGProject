package testNGconcept;

import org.testng.annotations.DataProvider;

public class DataForTest {
    @DataProvider(name = "pairs")
    public Object[][] getData(){

        return new Object[][]{
                {"Ahmet", "Aiza"},
                {"Rose","Jack"},
                {"Begimai","Brad"},
                {"Aigerim","Renat"}
        };
    }
}
