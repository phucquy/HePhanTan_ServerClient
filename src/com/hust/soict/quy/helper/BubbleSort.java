package com.hust.soict.quy.helper;

public class BubbleSort implements NumberSorter {

	@Override
	public void sort(int[] arr) {
		int n = arr.length;
		int tempSort;
		for (int i = 0; i < n - 1; i++) {
		       for (int j = n - 1; j >= 1; j--) {
		            if (arr[j] < arr[j - 1]) {
		                tempSort = arr[j];
		                arr[j] = arr[j-1];
		                arr[j-1] = tempSort;
		            }
		        }
		  }
	}

}
