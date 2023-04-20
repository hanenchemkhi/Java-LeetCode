public class FirstIndexOfSubString {
    //Find the Index of the First Occurrence in a String

    public static void main(String[] args){
        String haystack = "hello";
        String needle ="ll";
        System.out.println(Solution.strStr(haystack, needle));
    }

    class Solution {
        public static int strStr(String haystack, String needle) {

            if(needle.length()>haystack.length()){return -1;}
            if(!haystack.contains(needle)){return -1;}
            if(haystack.equals(needle)){return 0;}

            //brute force
            for(int i = 0; i<=haystack.length()-needle.length(); i++){
                if(haystack.substring(i,i+needle.length()).equals(needle)){
                    return i;
                }
            }
            return -1;
        }
    }
}
