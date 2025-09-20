package edu.wne.cs366;

/**
 * CS366: Programming Assignment 2 - Complexity & Recursion
 * 
 * This class implements three different approaches to calculating binomial coefficients
 * and provides methods for performance analysis and timing.
 * 
 * Students must implement the three binomial coefficient methods:
 * 1. binomialDefinition - using the direct factorial definition
 * 2. binomialCancellation - using factor cancellation optimization
 * 3. binomialRecursive - using Pascal's triangle recursion
 * 
 * @author [Student Name]
 * @date October 2025
 */
public class ComplexityRecursion {
    
    /**
     * Calculate binomial coefficient C(n,k) using the direct definition.
     * 
     * Formula: C(n,k) = n! / (k! * (n-k)!)
     * 
     * Implementation requirements:
     * - Calculate each factorial (n!, k!, (n-k)!) using separate for loops
     * - Use long arithmetic to handle large factorials
     * - Return -1 if input parameters are invalid (n < 0, k < 0, or k > n)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param n the total number of items (must be >= 0)
     * @param k the number of items to choose (must be >= 0 and <= n)
     * @return C(n,k) if valid inputs, -1 otherwise
     */
    public static long binomialDefinition(int n, int k) {
        // Validate inputs first
        if (n < 0 || k < 0 || k > n) {
            return -1;
        }
        
        // Handle base cases
        if (k == 0 || k == n) {
            return 1;
        }
        
        // Calculate n! using a loop
        long nFactorial = 1;
        for (int i = 1; i <= n; i++) {
            nFactorial *= i;
        }
        
        // Calculate k! using a loop
        long kFactorial = 1;
        for (int i = 1; i <= k; i++) {
            kFactorial *= i;
        }
        
        // Calculate (n-k)! using a loop
        long nMinusKFactorial = 1;
        for (int i = 1; i <= (n - k); i++) {
            nMinusKFactorial *= i;
        }
        
        // Return n! / (k! * (n-k)!)
        return nFactorial / (kFactorial * nMinusKFactorial);
    }
    
    /**
     * Calculate binomial coefficient C(n,k) using factor cancellation optimization.
     * 
     * This method reduces the number of multiplications by canceling common factors.
     * For example: C(10,3) = (10*9*8) / (3*2*1) instead of 10!/(3!*7!)
     * 
     * Implementation requirements:
     * - Optimize by computing only the necessary factors
     * - Use two for loops: one for numerator, one for denominator
     * - Perform division as you go to keep numbers smaller
     * - Return -1 if input parameters are invalid
     * 
     * Time Complexity: O(min(k, n-k))
     * Space Complexity: O(1)
     * 
     * @param n the total number of items (must be >= 0)
     * @param k the number of items to choose (must be >= 0 and <= n)
     * @return C(n,k) if valid inputs, -1 otherwise
     */
    public static long binomialCancellation(int n, int k) {
        // Validate inputs first
        if (n < 0 || k < 0 || k > n) {
            return -1;
        }
        
        // Handle base cases
        if (k == 0 || k == n) {
            return 1;
        }
        
        // Optimize by choosing smaller of k or (n-k)
        // This minimizes the number of operations needed
        if (k > n - k) {
            k = n - k;
        }
        
        // Use cancellation to compute C(n,k) = (n * (n-1) * ... * (n-k+1)) / (k * (k-1) * ... * 1)
        long result = 1;
        for (int i = 0; i < k; i++) {
            result = result * (n - i) / (i + 1);
        }
        
        return result;
    }
    
    /**
     * Calculate binomial coefficient C(n,k) using Pascal's triangle recursion.
     * 
     * Formula: C(n,k) = C(n-1,k-1) + C(n-1,k)
     * Base cases: C(n,0) = 1, C(n,n) = 1
     * 
     * Implementation requirements:
     * - Use pure recursion (no loops or multiplication)
     * - Implement the exact recursive formula above
     * - Handle base cases correctly
     * - Return -1 if input parameters are invalid
     * 
     * Time Complexity: O(2^n) - exponential due to repeated subproblems
     * Space Complexity: O(n) - recursion depth
     * 
     * @param n the total number of items (must be >= 0)
     * @param k the number of items to choose (must be >= 0 and <= n)
     * @return C(n,k) if valid inputs, -1 otherwise
     */
    public static long binomialRecursive(int n, int k) {
        // Validate inputs first
        if (n < 0 || k < 0 || k > n) {
            return -1;
        }
        
        // Handle base cases: C(n,0) = 1 and C(n,n) = 1
        if (k == 0 || k == n) {
            return 1;
        }
        
        // Recursive case: C(n,k) = C(n-1,k-1) + C(n-1,k)
        return binomialRecursive(n - 1, k - 1) + binomialRecursive(n - 1, k);
    }
    
    /**
     * Helper method to time the execution of a binomial coefficient calculation.
     * 
     * @param method the method name being tested
     * @param n the n parameter
     * @param k the k parameter
     * @param result the calculated result
     * @param startTime the start time in nanoseconds
     * @param endTime the end time in nanoseconds
     */
    public static void printTiming(String method, int n, int k, long result, long startTime, long endTime) {
        long duration = endTime - startTime;
        System.out.printf("%s(%d,%d) = %d, Time: %d ns (%.3f ms)%n", 
                         method, n, k, result, duration, duration / 1_000_000.0);
    }
    
    /**
     * Test the three binomial coefficient implementations with timing analysis.
     * 
     * This method demonstrates usage and allows students to observe
     * performance differences between the three approaches.
     */
    public static void main(String[] args) {
        System.out.println("CS366 PA2: Binomial Coefficient Implementation & Analysis\n");
        
        // Test cases with different sizes to observe performance differences
        int[][] testCases = {
            {5, 2},   // Small case
            {10, 3},  // Medium case  
            {15, 7},  // Larger case
            {20, 10}  // Large case (recursive may be slow!)
        };
        
        for (int[] testCase : testCases) {
            int n = testCase[0];
            int k = testCase[1];
            
            System.out.printf("Testing C(%d,%d):%n", n, k);
            
            // Test Method 1: Definition
            long startTime = System.nanoTime();
            long result1 = binomialDefinition(n, k);
            long endTime = System.nanoTime();
            printTiming("Definition", n, k, result1, startTime, endTime);
            
            // Test Method 2: Cancellation
            startTime = System.nanoTime();
            long result2 = binomialCancellation(n, k);
            endTime = System.nanoTime();
            printTiming("Cancellation", n, k, result2, startTime, endTime);
            
            // Test Method 3: Recursive (be careful with large inputs!)
            if (n <= 20) { // Limit recursive method to avoid excessive computation
                startTime = System.nanoTime();
                long result3 = binomialRecursive(n, k);
                endTime = System.nanoTime();
                printTiming("Recursive", n, k, result3, startTime, endTime);
            } else {
                System.out.println("Recursive method skipped for large inputs");
            }
            
            System.out.println();
        }
        
        System.out.println("Implementation complete! Run tests with: ./gradlew test");
        System.out.println("Complete your written analysis in ANALYSIS.md");
    }
}