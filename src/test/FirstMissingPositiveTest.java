package test;

import com.algorithms.arrays.FirstMissingPositive;
import org.junit.jupiter.api.Test;

public class FirstMissingPositiveTest {

    @Test
    public void test(){

        FirstMissingPositive fmp = new FirstMissingPositive();
        Integer val = fmp.find(new Integer[]{2,3,1});
    }
}
