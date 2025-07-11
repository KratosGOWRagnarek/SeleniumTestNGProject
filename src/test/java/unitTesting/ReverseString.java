package unitTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseString("cat"));
        System.out.println(reverseString("AAPple"));
        System.out.println(reverseString("c35u200"));
        System.out.println(reverseString(null));

    }

@Test
    public void test1(){
        Assert.assertEquals("tac",reverseString("cat"));
    }

    @Test
    public void test2(){
        Assert.assertEquals("",reverseString(null));
    }

    @Test
    public void test3(){
        Assert.assertEquals("12345",reverseString("54321"));
    }




    public static String reverseString(String str){

        if(str == null){
            return "";
        }

        StringBuilder reversed = new StringBuilder();
        for(int i = str.length()-1; i >=0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();

    }


}
