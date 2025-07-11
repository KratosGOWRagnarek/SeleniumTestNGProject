package unitTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeUnitTesting {
    public static void main(String[] args) {
        System.out.println(replaceA("BanaNA"));
    }


    public static String replaceA(String str){
        if (str==null) {
            return null;
        }
        return str.replace('a','*').replace('A','*');


    }

    @Test
    public void test1(){
        Assert.assertEquals(replaceA("apple"), "*pple");
    }
}
