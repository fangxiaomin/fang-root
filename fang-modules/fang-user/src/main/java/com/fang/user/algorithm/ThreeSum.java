package com.fang.user.algorithm;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:fxm
 * @createTime:2021/12/21 14:40
 */
public class ThreeSum {

/**
 * @Description:  三个数之和等于 0  ===双指针法         时间复杂度  O（n^2）  空间复杂度 O（1）
 * 
 **/
    public List<List<Integer>> threeSum(int[] nums ) {
        int n =nums.length;
        List<List<Integer>> result =new ArrayList<>();

        //对数组进行排序
        Arrays.sort(nums);

        //循环取数据  遍历每一个元素，作为当前 三元数组中最小的那个（最矮个做核心）
        for (int i = 0; i < n; i++) {
            // 1.1如果当前大于0   说明没有满足的数据 退出
            if(nums[i] > 0 ) break;
            // 1.2 前后2个数据一样，说明已经出现过  直接跳过
            if(i > 0  && nums[i] == nums[i-1] )
                continue;

            //1.3  正常情况，以当前数据做最小数据，定义左右指针
            int lp = i + 1;
            int rp = n - 1;
            //只要左右指针不重叠，就继续移动指针
            while (lp < rp ){
                int sum = nums[i] + nums[lp] + nums[rp];

                //sum  与 0  进行大小对比
                if( sum == 0 ){
                    //说明已经是答案
                    result.add(Arrays.asList(nums[i] , nums[lp] , nums[rp]));
                    lp ++ ;
                    rp -- ;
                    //如果移动之后的数据相同，直接跳过
                    while ( lp < rp && nums[lp] == nums[lp-1] ) lp++ ;
                    while ( lp < rp && nums[rp] == nums[rp +1] ) rp-- ;

                }
                else if( sum < 0 )
                    lp ++ ;
                else
                    rp -- ;

            }
        }
           return result ;
    }

    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(input));

    }
}
