package edu.wne.cs366;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive test suite for the ComplexityRecursion class.
 * 
 * This test suite validates all three binomial coefficient implementations:
 * - binomialDefinition (factorial approach)
 * - binomialCancellation (optimized approach)  
 * - binomialRecursive (Pascal's triangle approach)
 * 
 * Tests cover correctness, edge cases, and error handling.
 */
class ComplexityRecursionTest {

    // Known binomial coefficient values for testing
    // C(n,k) test cases: n, k, expected_result
    
    @ParameterizedTest
    @DisplayName("Test binomialDefinition with valid inputs")
    @CsvSource({
        "0, 0, 1",      // C(0,0) = 1
        "1, 0, 1",      // C(1,0) = 1  
        "1, 1, 1",      // C(1,1) = 1
        "2, 0, 1",      // C(2,0) = 1
        "2, 1, 2",      // C(2,1) = 2
        "2, 2, 1",      // C(2,2) = 1
        "3, 0, 1",      // C(3,0) = 1
        "3, 1, 3",      // C(3,1) = 3
        "3, 2, 3",      // C(3,2) = 3
        "3, 3, 1",      // C(3,3) = 1
        "4, 2, 6",      // C(4,2) = 6
        "5, 2, 10",     // C(5,2) = 10
        "6, 3, 20",     // C(6,3) = 20
        "7, 3, 35",     // C(7,3) = 35
        "8, 4, 70",     // C(8,4) = 70
        "10, 2, 45",    // C(10,2) = 45
        "10, 3, 120",   // C(10,3) = 120
        "10, 5, 252",   // C(10,5) = 252
        "15, 7, 6435",  // C(15,7) = 6435
        "20, 10, 184756" // C(20,10) = 184756
    })
    void testBinomialDefinition(int n, int k, long expected) {
        assertEquals(expected, ComplexityRecursion.binomialDefinition(n, k),
                    () -> String.format("C(%d,%d) should equal %d", n, k, expected));
    }
    
    @ParameterizedTest
    @DisplayName("Test binomialCancellation with valid inputs")
    @CsvSource({
        "0, 0, 1",      // C(0,0) = 1
        "1, 0, 1",      // C(1,0) = 1  
        "1, 1, 1",      // C(1,1) = 1
        "2, 0, 1",      // C(2,0) = 1
        "2, 1, 2",      // C(2,1) = 2
        "2, 2, 1",      // C(2,2) = 1
        "3, 0, 1",      // C(3,0) = 1
        "3, 1, 3",      // C(3,1) = 3
        "3, 2, 3",      // C(3,2) = 3
        "3, 3, 1",      // C(3,3) = 1
        "4, 2, 6",      // C(4,2) = 6
        "5, 2, 10",     // C(5,2) = 10
        "6, 3, 20",     // C(6,3) = 20
        "7, 3, 35",     // C(7,3) = 35
        "8, 4, 70",     // C(8,4) = 70
        "10, 2, 45",    // C(10,2) = 45
        "10, 3, 120",   // C(10,3) = 120
        "10, 5, 252",   // C(10,5) = 252
        "15, 7, 6435",  // C(15,7) = 6435
        "20, 10, 184756" // C(20,10) = 184756
    })
    void testBinomialCancellation(int n, int k, long expected) {
        assertEquals(expected, ComplexityRecursion.binomialCancellation(n, k),
                    () -> String.format("C(%d,%d) should equal %d", n, k, expected));
    }
    
    @ParameterizedTest
    @DisplayName("Test binomialRecursive with valid inputs (smaller cases)")
    @CsvSource({
        "0, 0, 1",      // C(0,0) = 1
        "1, 0, 1",      // C(1,0) = 1  
        "1, 1, 1",      // C(1,1) = 1
        "2, 0, 1",      // C(2,0) = 1
        "2, 1, 2",      // C(2,1) = 2
        "2, 2, 1",      // C(2,2) = 1
        "3, 0, 1",      // C(3,0) = 1
        "3, 1, 3",      // C(3,1) = 3
        "3, 2, 3",      // C(3,2) = 3
        "3, 3, 1",      // C(3,3) = 1
        "4, 2, 6",      // C(4,2) = 6
        "5, 2, 10",     // C(5,2) = 10
        "6, 3, 20",     // C(6,3) = 20
        "7, 3, 35",     // C(7,3) = 35
        "8, 4, 70",     // C(8,4) = 70
        "10, 2, 45",    // C(10,2) = 45
        "10, 3, 120",   // C(10,3) = 120
        "10, 5, 252"    // C(10,5) = 252
        // Note: Larger cases omitted for recursive method due to exponential time complexity
    })
    void testBinomialRecursive(int n, int k, long expected) {
        assertEquals(expected, ComplexityRecursion.binomialRecursive(n, k),
                    () -> String.format("C(%d,%d) should equal %d", n, k, expected));
    }
    
    // Test invalid inputs - all methods should return -1
    
    @Test
    @DisplayName("Test binomialDefinition with invalid inputs")
    void testBinomialDefinitionInvalidInputs() {
        assertEquals(-1, ComplexityRecursion.binomialDefinition(-1, 0), "Negative n should return -1");
        assertEquals(-1, ComplexityRecursion.binomialDefinition(5, -1), "Negative k should return -1");
        assertEquals(-1, ComplexityRecursion.binomialDefinition(3, 5), "k > n should return -1");
        assertEquals(-1, ComplexityRecursion.binomialDefinition(-2, -1), "Both negative should return -1");
    }
    
    @Test
    @DisplayName("Test binomialCancellation with invalid inputs")
    void testBinomialCancellationInvalidInputs() {
        assertEquals(-1, ComplexityRecursion.binomialCancellation(-1, 0), "Negative n should return -1");
        assertEquals(-1, ComplexityRecursion.binomialCancellation(5, -1), "Negative k should return -1");
        assertEquals(-1, ComplexityRecursion.binomialCancellation(3, 5), "k > n should return -1");
        assertEquals(-1, ComplexityRecursion.binomialCancellation(-2, -1), "Both negative should return -1");
    }
    
    @Test
    @DisplayName("Test binomialRecursive with invalid inputs")
    void testBinomialRecursiveInvalidInputs() {
        assertEquals(-1, ComplexityRecursion.binomialRecursive(-1, 0), "Negative n should return -1");
        assertEquals(-1, ComplexityRecursion.binomialRecursive(5, -1), "Negative k should return -1");
        assertEquals(-1, ComplexityRecursion.binomialRecursive(3, 5), "k > n should return -1");
        assertEquals(-1, ComplexityRecursion.binomialRecursive(-2, -1), "Both negative should return -1");
    }
    
    // Test that all three methods produce the same results for valid inputs
    
    @ParameterizedTest
    @DisplayName("Test that all three methods agree on results")
    @CsvSource({
        "0, 0", "1, 0", "1, 1", "2, 1", "3, 2", "4, 2", "5, 2", 
        "6, 3", "7, 3", "8, 4", "10, 5"
    })
    void testMethodsAgree(int n, int k) {
        long result1 = ComplexityRecursion.binomialDefinition(n, k);
        long result2 = ComplexityRecursion.binomialCancellation(n, k);
        long result3 = ComplexityRecursion.binomialRecursive(n, k);
        
        assertEquals(result1, result2, 
                    () -> String.format("Definition and Cancellation methods disagree for C(%d,%d)", n, k));
        assertEquals(result1, result3,
                    () -> String.format("Definition and Recursive methods disagree for C(%d,%d)", n, k));
        assertEquals(result2, result3,
                    () -> String.format("Cancellation and Recursive methods disagree for C(%d,%d)", n, k));
    }
    
    // Edge case testing
    
    @Test
    @DisplayName("Test edge cases for all methods")
    void testEdgeCases() {
        // Test C(n,0) = 1 for various n
        for (int n = 0; n <= 10; n++) {
            final int finalN = n;
            assertEquals(1, ComplexityRecursion.binomialDefinition(n, 0),
                        () -> String.format("C(%d,0) should be 1", finalN));
            assertEquals(1, ComplexityRecursion.binomialCancellation(n, 0),
                        () -> String.format("C(%d,0) should be 1", finalN));
            assertEquals(1, ComplexityRecursion.binomialRecursive(n, 0),
                        () -> String.format("C(%d,0) should be 1", finalN));
        }
        
        // Test C(n,n) = 1 for various n
        for (int n = 0; n <= 10; n++) {
            final int finalN = n;
            assertEquals(1, ComplexityRecursion.binomialDefinition(n, n),
                        () -> String.format("C(%d,%d) should be 1", finalN, finalN));
            assertEquals(1, ComplexityRecursion.binomialCancellation(n, n),
                        () -> String.format("C(%d,%d) should be 1", finalN, finalN));
            assertEquals(1, ComplexityRecursion.binomialRecursive(n, n),
                        () -> String.format("C(%d,%d) should be 1", finalN, finalN));
        }
        
        // Test C(n,1) = n for various n
        for (int n = 1; n <= 10; n++) {
            final int finalN = n;
            assertEquals(n, ComplexityRecursion.binomialDefinition(n, 1),
                        () -> String.format("C(%d,1) should be %d", finalN, finalN));
            assertEquals(n, ComplexityRecursion.binomialCancellation(n, 1),
                        () -> String.format("C(%d,1) should be %d", finalN, finalN));
            assertEquals(n, ComplexityRecursion.binomialRecursive(n, 1),
                        () -> String.format("C(%d,1) should be %d", finalN, finalN));
        }
    }
    
    // Symmetry property testing: C(n,k) = C(n,n-k)
    
    @ParameterizedTest
    @DisplayName("Test symmetry property C(n,k) = C(n,n-k)")
    @CsvSource({
        "5, 2", "6, 2", "7, 3", "8, 3", "10, 4", "12, 5"
    })
    void testSymmetryProperty(int n, int k) {
        long result1 = ComplexityRecursion.binomialDefinition(n, k);
        long result2 = ComplexityRecursion.binomialDefinition(n, n - k);
        assertEquals(result1, result2,
                    () -> String.format("Symmetry failed: C(%d,%d) != C(%d,%d)", n, k, n, n-k));
        
        result1 = ComplexityRecursion.binomialCancellation(n, k);
        result2 = ComplexityRecursion.binomialCancellation(n, n - k);
        assertEquals(result1, result2,
                    () -> String.format("Symmetry failed: C(%d,%d) != C(%d,%d)", n, k, n, n-k));
        
        result1 = ComplexityRecursion.binomialRecursive(n, k);
        result2 = ComplexityRecursion.binomialRecursive(n, n - k);
        assertEquals(result1, result2,
                    () -> String.format("Symmetry failed: C(%d,%d) != C(%d,%d)", n, k, n, n-k));
    }
    
    // Pascal's triangle property testing: C(n,k) = C(n-1,k-1) + C(n-1,k)
    
    @ParameterizedTest
    @DisplayName("Test Pascal's triangle property")
    @CsvSource({
        "2, 1", "3, 1", "3, 2", "4, 1", "4, 2", "4, 3", 
        "5, 1", "5, 2", "5, 3", "5, 4", "6, 2", "6, 3", "6, 4"
    })
    void testPascalsTriangleProperty(int n, int k) {
        if (n > 0 && k > 0 && k < n) {
            long current = ComplexityRecursion.binomialDefinition(n, k);
            long left = ComplexityRecursion.binomialDefinition(n - 1, k - 1);
            long right = ComplexityRecursion.binomialDefinition(n - 1, k);
            long sum = left + right;
            
            assertEquals(current, sum,
                        () -> String.format("Pascal's property failed: C(%d,%d) != C(%d,%d) + C(%d,%d)", 
                                          n, k, n-1, k-1, n-1, k));
        }
    }
}