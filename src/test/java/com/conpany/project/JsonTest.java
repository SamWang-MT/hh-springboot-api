package com.conpany.project;

import java.util.Arrays;

public class JsonTest {

	public static void main(String[] args) {
		int[] array_a = new int[] {4, 11,21,89,99};
		int[] array_b = new int[] {2,3,8,9};
		
		int[] array_result =  mergeArray(array_a,array_b);
		
		System.out.println(Arrays.toString(array_result));
		
	}

	private static int[] mergeArray(int[] array_a, int[] array_b) {
		int m = array_a.length;
		int n = array_b.length;
		int[] result = new int[m+n];
		
		int k = m+n-1;  //最后一个位置
        int i = m - 1, j = n - 1;
        //每次都挑最大的数出来
        while(i >= 0 || j >= 0){
        	if (i>=0 & j>=0) {
        		result[k--] = (array_a[i] > array_b[j]) ? array_a[i--] : array_b[j--];
			}else {
				result[k--] = i>=0? array_a[i--]:array_b[j--];
			}
        }				
		return result;
	}
}


