import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ArrayForm {
    public static void main(String[] args) {

        /**
         * The array-form of an integer num is an array representing its digits in left to right order.
         *
         * For example, for num = 1321, the array form is [1,3,2,1].
         * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
         *
         *
         *
         * Example 1:
         *
         * Input: num = [1,2,0,0], k = 34
         * Output: [1,2,3,4]
         * Explanation: 1200 + 34 = 1234
         */

        int[] num = new int[]{ 2,7,4 };
        int k = 181;
        int carry = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = num.length-1; i>=0; i--){

            stack.push((k%10+ num[i]+carry)%10);
            carry= (k%10+ num[i]%10+carry)/10;
            k=k/10;

        }
        while(k!=0){
            stack.push(k%10);
            k=k/10;
        }
        List<Integer> stackToList = new ArrayList(stack);
        Collections.reverse(stackToList);
        System.out.println(stackToList);
    }
}
