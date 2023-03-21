public class Palindrome {
    public static void main(String[] args) {
        String s = "poiu" +
                "cdabadckjloi";
        System.out.println("Is "+ s + " palindrome: " + Solution.isPalindrome(s));
        System.out.println("Longest palindrome in "+s+": " +Solution.longestPalindrome(s));
    }

    class Solution {
        public static boolean isPalindrome(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;

            for (int i = 0; i < n / 2; i++) {
                if (chars[i] != chars[n - i - 1]) {
                    return false;
                }
            }
            return true;
        }
        public static String longestPalindrome(String s) {

                int n= s.length();
                if (n==1){return s;}
                int low;
                int high;
                int start=0;
                int length=1;
                int maxLength=1;

                for(int i=0; i<n; i++){
                    low=i-1;
                    high=i+1;
                    while(high<n && s.charAt(i)==s.charAt(high)){
                        high++;
                    }
                    while(low>=0 && s.charAt(i)==s.charAt(low)){
                        low--;
                    }
                    while(low>=0 && high< n && s.charAt(low)==s.charAt(high)){
                        low--;
                        high++;
                    }
                    length = high-low-1;

                    if(maxLength<length){
                        maxLength=length;
                        start= low+1;
                    }

                }


                return s.substring(start, start+maxLength);

            }

    }
}


