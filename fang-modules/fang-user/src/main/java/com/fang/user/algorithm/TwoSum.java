package com.fang.user.algorithm;

import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:fxm
 * @createTime:2021/12/21 10:11
 */
public class TwoSum {

    //方法1  暴力法 穷举所有两数组和
    public int[] twoSum1(int[] nums ,int target) {
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1 ;j < nums.length; j++){
                if(nums[i] + nums[j] == target ){
                    return new int[]{i,j};
                }
            }
        }
        throw  new IllegalArgumentException("No two sum solution");
    }



    /**   两遍哈希表
     * @Description: 	空间复杂度：O(N)  	时间复杂度：O(N)   用空间换时间
     *
     **/
    public int[] twoSum2(int[] nums ,int target) {
        int n = nums.length;
        Map<Integer,Integer> map =new HashMap<>();
        // 遍历数组，全部保存到 hashmap中
        for (int i = 0; i < n; i++) {
            map.put(nums[i],i);
        }
        // 遍历数组，挨个查找对应的“那个数”在不在map中
        for (int i = 0; i < n; i++) {
            int thatNum = target - nums[i];
            if(map.containsKey(thatNum) &&  thatNum != i){
                return new int[]{i,map.get(thatNum)};
            }
        }
        throw  new IllegalArgumentException("No two sum solution");
    }


    // 一遍哈希表
    public int[] twoSum(int[] nums ,int target) {
        int n = nums.length;
        Map<Integer,Integer> map =new HashMap<>();
        // 遍历数组，挨个查找对应的“那个数”在不在map中
        for (int i = 0; i < n; i++) {
            int thatNum = target - nums[i];
            if(map.containsKey(thatNum) &&  thatNum != i){
                return new int[]{map.get(thatNum),i};
            }
            map.put(nums[i],i);
        }
        throw  new IllegalArgumentException("No two sum solution");
    }



    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        int[] input1 = {3,3};
        int target = 9;
        int target1 = 6;
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(input1, target1);
        for (int anInt : ints) {
            System.out.print(anInt + "\t");
        }
    }


}
