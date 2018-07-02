package test;

import com.algorithms.recursion.Permutations;
import org.junit.jupiter.api.Test;

public class PermutationsTest {

    @Test
    public void test(){

        Permutations permutations = new Permutations();
        permutations.permute("abc");
    }
}
