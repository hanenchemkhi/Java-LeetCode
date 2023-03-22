import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {
    public static void main(String[] args){
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        char c = '7';
//        int i = c - '0';
//        System.out.println(i);

        System.out.println(Solution.reverse(-214748364));


    }
    class Solution {
        public static int reverse(int x) {

//            Long result = 0L;
//
//            boolean positive;
//            List<Integer> reversedX = new ArrayList<>();
//
//            if (x >=0){
//                positive= true;
//            }else{
//                positive = false;
//                x= -x;
//            }
//
//            //convert x to array of integers
//
//            int i=0;
//            while( x != 0){
//                reversedX.add(x % 10);
//                x = x/10;
//                i++;
//            }
//            //1534236469
//            for (int j = 0; j < reversedX.size(); j++) {
//                    result = result*10 + reversedX.get(j);
//            }
//            if (!positive){
//                result = -result;
//                if(result<Integer.MIN_VALUE){return 0;}
//            }
//            if(result> Integer.MAX_VALUE) {
//                return 0;
//            }
//            return result.intValue();
//

            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
                if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
                rev = rev * 10 + pop;
            }
            return rev;



        }
    }

}
