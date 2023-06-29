import java.util.Arrays;
import java.util.Scanner;  
// Jonathan Fulford

public class Lab02 {

	public static String linearSearch(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if(array[i] == key) {
				return "Using Linear Search: \nSearch key FOUND at index " + i; }
		}
		return "Search key NOT FOUND"; 
	}
	
	public static String interpolationSearchIterative(int[] array, int low, int high, int key) {
		while (low <= high) {
			int mid = low + ((key - array[low]) * (high - low)) / (array[high] - array[low]);
			if(key < array[mid]) {
				high = mid - 1;}
			else if(array[mid] < key) {
				low = mid + 1; }
			else {
				return  "Using Interpolation Search: \nSearch key FOUND at index " + mid; }
		}
		return "Search key NOT FOUND";
	}

	// Q3 method.
	public static String newLinearSearch(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if(array[i] == key) {
				return "Using NEW Linear Search: \nSearch key FOUND at index " + i; }
			else if (array[i+1] == key) {
				return "Using NEW Linear Search: \nSearch key FOUND at index " + (i+1); }
			}
		return "Search key NOT FOUND"; 
	}
	
	
	public static void main(String[] args) {
		
		int size;  
		Scanner sc = new Scanner(System.in);  
		System.out.print("Q1: Enter the number of elements in the array: ");  
		size = sc.nextInt();  
		int[] array = new int[size];  
		System.out.println("Enter the elements of the array: ");  
		for(int i=0; i < size; i++)  
		{  
		array[i]=sc.nextInt();  
		}  
		System.out.println("Enter the search key: ");
		int key = sc.nextInt();
		System.out.println();

		
		int low = 0;
		int high = array.length - 1;
		Arrays.sort(array); // Sort the array before searching.
		
		//Time of Linear Search
		long startTime1 = System.nanoTime();
		System.out.println(linearSearch(array, key));
		long duration1 = System.nanoTime() - startTime1;
		
		System.out.println();
		
		//Time of Interpolation Search
		long startTime2 = System.nanoTime();
		System.out.println(interpolationSearchIterative(array, low, high, key));
		long duration2 = System.nanoTime() - startTime2;
		
		System.out.println();

		// Q2
		System.out.println("Q2: Interpolation performed better than linear almost consistently due to the average complexity of each method. Linear has an average complexity of O(n) and interpolation has an average complexity of O(log log n)");
		System.out.println("Runtime(ns) for linear search: " + duration1);
		System.out.println("Runtime(ns) for interpolation search: " + duration2);
		System.out.println();

		// Q3
		System.out.println("Q3: ");
		long startTime3 = System.nanoTime();
		System.out.println(newLinearSearch(array, key));
		long duration3 = System.nanoTime() - startTime3;
		System.out.println("Runtime(ns) for NEW linear search: " + duration3);
		System.out.println("Reduction from original linear search: " + ((double) duration3 / duration1) * 100 + "%");
		System.out.println("Explanation: by adding another else if and looking at the next item in the array for each iteration, it shortens the for loop execution which is dependent on input size.");

	}

}
