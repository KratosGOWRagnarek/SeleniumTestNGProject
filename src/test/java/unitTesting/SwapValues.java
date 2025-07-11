package unitTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SwapValues {


/*
array{4, 7}

return{7, 4}

if array=null, return null
 */

    public static int[] swapValues(int[] array){
        if (array == null) {
            return null;
        }
        int current = array[0];
        array[0] = array[1];
        array[1] = current;
        return array;

    }

    @Test
    public void test1(){
        Assert.assertEquals(swapValues(new int[]{100, 5}), new int[] {5,100});
    }

    @Test
    public void test2(){
        Assert.assertEquals(swapValues(new int[]{10, -7}), new int[] {-7,10});
    }

    @Test
    public void test3(){
        Assert.assertEquals(swapValues(new int[]{-1, -3}), new int[] {-3,-1});
    }

    @Test
    public void test4(){
        Assert.assertEquals(swapValues(null), null);
    }





}


