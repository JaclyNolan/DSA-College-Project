package algorithm_speed_testing;

public class AlgorithmMemoryTesting {

	public static void main(String[] args) {
		// Test input
        int n = 10;

        // Record memory usage of recursive factorial
        long beforeRecursive = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long recursiveFactorial = factorialRecursive(n);
        long afterRecursive = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Record memory usage of iterative factorial
        long beforeIterative = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long iterativeFactorial = factorialIterative(n);
        long afterIterative = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Print results
        System.out.println("Recursive factorial of " + n + ": " + recursiveFactorial);
        System.out.println("Memory used by recursive factorial: " + (afterRecursive - beforeRecursive) + " bytes");
        System.out.println();
        System.out.println("Iterative factorial of " + n + ": " + iterativeFactorial);
        System.out.println("Memory used by iterative factorial: " + (afterIterative - beforeIterative) + " bytes");
	}
	
	static long factorialRecursive(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorialRecursive(n - 1);
        }
    }
	
	static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
