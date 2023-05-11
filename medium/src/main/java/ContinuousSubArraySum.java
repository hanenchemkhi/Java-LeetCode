package main.java;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {

    /*
    Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
    A good subarray is a subarray where: its length is at least two, and the sum of the elements of the subarray is a multiple of k.
    Note that: A subarray is a contiguous part of the array.
    An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
     */

    public static void main(String[] args) {
        int [] nums = {23,2,6,4,7,0};
        int k = 13;

        System.out.println(Solution.checkSubarraySum(nums, k));
    }

    class Solution {
        public static boolean checkSubarraySum(int[] nums, int k) {
            if(nums.length <2){return false;}

            // int sum =0;
            // for(int i = 0; i < nums.length; i++){
            //     sum= nums[i];
            //     for(int j = i + 1 ; j< nums.length; j++){
            //         sum+= nums[j];
            //         if(sum%k == 0){return true;}
            //     }
            // }

            Map<Integer, Integer> map = new HashMap<>();

            int sum =0;
            map.put(sum%k,-1);

            for(int i = 0; i< nums.length; i++){
                sum+= nums[i];
                if( map.containsKey(sum%k) ){
                    if((i - map.get(sum%k)) >= 2){return true;}
                }else { map.put(sum%k, i);}
            }

            return false;
        }
    }
}
