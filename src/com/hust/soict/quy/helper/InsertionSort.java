package com.hust.soict.quy.helper;

public class InsertionSort implements NumberSorter {

	@Override
	public void sort(int[] arr) {
		int n = arr.length;
		int i, key, j;
		 for (i = 1; i < n; i++)
		   {
		       key = arr[i];
		       j = i-1;
		 
		       while (j >= 0 && arr[j] > key)
		       {
		           arr[j+1] = arr[j];
		           j = j-1;
		       }
		       arr[j+1] = key;
		  }
		
	}

}
