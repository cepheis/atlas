import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class IsSubsetTest {

    /*
     Is subset?

     Input:
       "Television"
       "even"
     Output:
       True

       Implementations:
       - O (n * log (n) ) /w binary search
       - O (N)            /w hashset
     */

    @Test
    public void isSubset_with_HashSet_Test() {
        boolean result = false;
        String s1 = "Television";
        String s2 = "even";

        HashSet<Character> map = new HashSet<>(s1.length());

        // O(n)
        for (int i = 0; i < s1.length(); i++) {
            map.add(s1.charAt(i));
        }

        // O(m)
        for (int i = 0; i < s2.length(); i++) {
            //contains O(1)
            result = map.contains(s2.charAt(i));
        }

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void isSubset_with_binarySearch_Test() {
        boolean result = false;
        String s1 = "Television";
        String s2 = "even";

        char[] s1Array = s1.toCharArray();

        Arrays.sort(s1Array);

        //O( n*log(n) )

        for (int i = 0; i < s2.length(); i++) {
            result = Arrays.binarySearch(s1Array, s2.charAt(i)) > 0;
        }

        assertThat(result).isEqualTo(true);
    }

}
