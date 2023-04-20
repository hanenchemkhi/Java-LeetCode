public class AddBinary {

    public static void main(String[] args) {
        String a = "1111010";
        String b = "1011";

        System.out.println("Expected Output: \"10101\"");

        System.out.println("Your Output: " + Solution.addBinary(a,b));
    }
    class Solution{

        public static String addBinary(String a, String b){
            StringBuilder result = new StringBuilder();

            StringBuilder aReversed = new StringBuilder(a).reverse();
            StringBuilder bReversed = new StringBuilder(b).reverse();
            char carry = '0';

            int i = 0;
            while( i < aReversed.length() || i < bReversed.length()){
                if(i ==  aReversed.length()) { aReversed.append('0');}
                if(i ==  bReversed.length()) {bReversed.append('0');}


                if(aReversed.charAt(i)=='0' && bReversed.charAt(i) == '0'){
                    if(carry == '0'){result.append('0'); }
                    else {result.append('1'); carry = '0'; }

                }else if(aReversed.charAt(i)=='1' && bReversed.charAt(i) == '1'){ //0
                    if(carry == '0'){result.append('0'); carry = '1';}
                    else {result.append('1'); carry = '1';}

                }else if(aReversed.charAt(i)=='0' && bReversed.charAt(i) == '1'){ //1
                    if(carry == '0'){result.append('1'); carry = '0';}
                    else {result.append('0'); carry = '1';}
                }

                else if(aReversed.charAt(i)=='1' && bReversed.charAt(i) == '0'){ //1
                    if(carry == '0'){result.append('1'); carry = '0';}
                    else {result.append('0');carry = '1';}
                }
                i++;
            }


            if(carry == '1'){ result.append('1');}


            return result.reverse().toString();

        }

    }
}
