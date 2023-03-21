public class PalindromeNumber {

    public static void main(String[] args) {
        /*Given an integer x, return true if x is a palindrome, and false otherwise.*/

        int x = 36544563;
        System.out.println(Solution.isPalindrome(x));
    }
    class Solution {
        public static boolean isPalindrome(int x) {

            char[] number = String.valueOf(x).toCharArray();
            int n = number.length;

            for (int i = 0; i < n / 2; i++) {
                if (number[i] != number[n - i - 1]) {
                    return false;
                }
            }
            return true;

        }
    }

}
