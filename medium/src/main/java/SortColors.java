import java.sql.SQLOutput;

public class SortColors {
    /*Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

    You must solve this problem without using the library's sort function.

     */
    public static void main(String[] args){

        System.out.println("Input: nums = [2,0,2,1,1,0]");
        System.out.println("Expected output: [0,0,1,1,2,2]");
        int[] nums = {2,0,2,1,1,0};
        Solution.sortColors(nums);
        System.out.print("Output: [");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+",");

        }
        System.out.print("]");

    }
    class Solution {
        public static void sortColors(int[] nums) {
            int count0 = 0;
            int count1 = 0;
            int count2 = 0;

            for(int i=0; i< nums.length;i++){
                switch (nums[i]){
                    case 0:{
                        count0++;
                        break;
                    }
                    case 1:{
                        count1++;
                        break;
                    }
                    case 2:{
                        count2++;
                        break;
                    }
                }
            }
            int j = 0;
            while(count0 > 0){
                nums[j]= 0 ;
                j++;
                count0--;
            }

            while(count1 > 0){
                nums[j]= 1 ;
                j++;
                count1--;
            }

            while(count2 > 0){
                nums[j]= 2 ;
                j++;
                count2--;
            }
        }
    }
}
