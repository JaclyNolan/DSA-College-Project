package algorithm_speed_testing;

public class AlgorithmSpeedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr1 = new int[50000], arr2 = new int[50000];
		 
        // Initialize array with random values
        for (int i = 0; i < arr1.length; i++) {
        	int number = (int) (Math.random() * 100);
            arr1[i] = number;
            arr2[i] = number;
        }

        // Measure the speed of the algorithm
        long startTime = System.currentTimeMillis();
        mergeSort(arr2, 0, arr2.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for merge sort: " + (endTime - startTime) + "ms");
        
        // Measure the speed of the algorithm
        startTime = System.currentTimeMillis();
        bubbleSort(arr1);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for bubble sort: " + (endTime - startTime) + "ms");
        

	}
	
	static void bubbleSort(int[] arr) {
		int n = arr.length;
	    for (int i = 0; i < n-1; i++) {
	        for (int j = 0; j < n-i-1; j++) {
	            if (arr[j] > arr[j+1]) {
	                // swap arr[j] and arr[j+1]
	                int temp = arr[j];
	                arr[j] = arr[j+1];
	                arr[j+1] = temp;
	            }
	        }
	    }
	}
	
	static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
	
	static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }
    }

}
