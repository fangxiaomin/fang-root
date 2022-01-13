package com.fang.user.algorithm;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.Arrays;

/**
 * @author:fxm 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * @createTime:2021/12/21 16:13
 */
public class NextPermutation {

    public void nextPermutation(int[] nums){
        int k = nums.length -2 ;
        while ( k >= 0 && nums[k] >= nums[k+1] )
            k--;
        // 如果全部降序，以最小序列输出
        if( k < 0 ){
            Arrays.sort(nums);
            return;
        }

        int i = k + 2;
        while ( i < nums.length && nums[i] > nums[k] )
            i++ ;

        // 交换nums[k] 和找到的 nums[i-1]
        int tem = nums[k] ;
        nums[k] = nums[i-1] ;
        nums[i-1] = tem;

        // k以后剩余的部分反转成升序
        int start = k + 1;
        int end = nums.length -1;
        while (start < end ){
            int retemp = nums[start];
            nums[start] = nums[end];
            nums[end] = retemp;
            start++ ;
            end--;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,8,7,6,2,10,3,19};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + "\t");
        }

    }
}
