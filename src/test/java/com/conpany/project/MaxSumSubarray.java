package com.conpany.project;

import org.springframework.web.bind.annotation.InitBinder;

public class MaxSumSubarray {
	public static int maxSubArray3(int[] nums) {
		int maxSum = nums[0];
		int sum = 0;
		int minSum = 0;
		for (int num : nums) {
			// prefix Sum
			sum += num;
			// update maxSum
			maxSum = Math.max(maxSum, sum - minSum);
			// update minSum
			minSum = Math.min(minSum, sum);
		}
		return maxSum;
	}

	public static void main(String[] args) {

		int[] nums = { 100, -1, 5, -8, -3, -4, -5 };
//		int maxSubArray3 = maxSubArray3(nums);

//		System.out.println(maxSubArray3);
		getSumArry(nums);
//		
	}

	public static void getSumArry(int[] nums) {

		int sum = 0;
		int max = nums[0];
		int min = 0;

		for (int i = 0; i < nums.length; i++) {

			sum = sum + nums[i];

			max = Math.max(max, sum - min);

			min = Math.min(min, sum);

			/*
			 * System.out.println(String.format("k: %d -->  sum: %d", i, sum)); if (max <
			 * sum) { max_index = i; max = sum; System.out.println("MAX-SET:" + i +
			 * "=value:"+ max); } if (min > sum ) { min = sum; min_index = i;
			 * System.out.println("Min-SET:" + i + "=value:"+ min); }
			 * 
			 * System.out.println(String.format(
			 * "%d: [max_index=%d  max= %d],[min_index=%d   min= %d ",i,max_index,max
			 * ,min_index , min ));
			 */
			/*
			 * if ( min_index < max_index) { result = Math.max(result, max - min ); }
			 * System.out.println("Result:" + result);
			 */

		}
		System.out.println(String.format("MAX :%d ", max));

	}

}
