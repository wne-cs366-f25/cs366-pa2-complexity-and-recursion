# CS366 - PA2: Complexity & Recursion

This assignment combines theoretical complexity analysis with practical algorithm implementation. You will analyze asymptotic complexity, solve recurrence relations, and implement three different approaches to calculating binomial coefficients.

## Part A: Asymptotic Analysis

Complete the theoretical problems in `ANALYSIS.md`:

**Problem 1: Big Oh and Big Omega Proofs**

- Show 3n³ + 2n² - 6n + 3 = O(n³) using the formal definition
- Show 3n³ + 2n² - 6n + 3 = Ω(n³) using the formal definition
- Find specific constants c and n₀ as required by the definitions

**Problem 2: Function Growth Ordering**

- Order functions from fastest to slowest asymptotic growth

## Part B: Recurrence Relations

Complete the recurrence analysis problems in `ANALYSIS.md`:

**Algorithm Analysis**

- Write recurrence relations for three given algorithms
- Solve using the Master Theorem when applicable
- Use iteration method when Master Theorem doesn't apply
- Show all work including case identification and constant choices

**Direct Recurrence Solving**

- Apply Master Theorem to given recurrences
- Identify which case applies and justify your reasoning

## Part C: Programming Implementation

Implement three methods for calculating binomial coefficients C(n,k):

### Method 1: `binomialDefinition(int n, int k)`

Implement using the direct factorial definition: C(n,k) = n! / (k! × (n-k)!)

**Requirements:**

- Calculate each factorial separately using for loops
- Use long arithmetic for large numbers
- Return -1 for invalid inputs (n < 0, k < 0, k > n)
- Time complexity: O(n)

### Method 2: `binomialCancellation(int n, int k)`

Implement using factor cancellation optimization to reduce computations.

**Requirements:**

- Cancel common factors before multiplication/division
- Use only necessary factors (not full factorials)
- Optimize by choosing min(k, n-k)
- Time complexity: O(min(k, n-k))

### Method 3: `binomialRecursive(int n, int k)`

Implement using Pascal's triangle recursion: C(n,k) = C(n-1,k-1) + C(n-1,k)

**Requirements:**

- Pure recursion (no loops or multiplication)
- Handle base cases: C(n,0) = 1, C(n,n) = 1
- Follow the recursive formula exactly
- Time complexity: O(2ⁿ) - exponential!

### Getting Started

#### Step 1: Run the Test Suite

Test your implementations as you develop:

```bash
./gradlew test
```

The comprehensive test suite will verify:

- Correctness with known binomial coefficient values
- Proper error handling for invalid inputs
- Consistency between all three methods
- Mathematical properties (symmetry, Pascal's triangle)

#### Step 2: Test Individual Cases

Use the main method for experimentation:

```bash
./gradlew run
```

The main method includes timing analysis to observe performance differences between the three approaches.

#### Step 3: Complete Your Analysis

Fill out `ANALYSIS.md` with:

- Step-by-step mathematical proofs and derivations
- Recurrence relation solutions with detailed work
- Performance analysis comparing the three implementations
- Observations about theoretical vs empirical complexity

### Testing Your Implementation

#### Verify Correctness

```bash
# Run all tests
./gradlew test

# Run with detailed output
./gradlew test --info
```

#### Observe Performance

```bash
# Run the main method to see timing comparisons
./gradlew run
```

#### Known Test Values

Your implementations should produce these results:

- C(5,2) = 10
- C(10,3) = 120
- C(15,7) = 6435
- C(20,10) = 184756

# Submission Requirements

## Files to Submit

Your completed assignment should include:

1. **ComplexityRecursion.java** - Your implemented methods
2. **ANALYSIS.md** - Complete theoretical analysis with mathematical work
3. All original files (build.gradle, tests, etc.)

## Submission Process

### Method 1: DevContainer (Recommended)

```bash
tar -czf pa2-YOURNAME.zip /workspace
```

Then download the file from the container and upload it to Kodiak. Note that only `tar` is able to decompress this file.

### Method 2: Local Development

Right-click the assignment folder and compress to zip and upload that compressed file to Kodiak.

## Evaluation

**Programming Component:**

- All three methods correctly implemented
- Proper input validation and error handling
- Clean, readable code with appropriate comments
- All unit tests passing

**Theoretical Component:**

- Informal mathematical 'proofs' with theorem usage
- Complete recurrence relation solutions
- Clear explanations and step-by-step work

## Grading Criteria

- **Submission (33.3%):** Complete submission with all required files and components
- **Completeness (33.3%):** All problems attempted in both programming and theoretical components
- **Correctness (33.3%):** Accurate implementations and mathematical analysis

## Getting Help

- **Office Hours**: Tuesday & Wednesday 12:30-1:30 PM (Herman 207)
- **Syllabot**: Use the course AI assistant for conceptual questions
- **Discussion**: Collaborate on approaches but write your own code and analysis

## Academic Integrity

This is an **individual assignment**. You may:

- Discuss algorithmic approaches and mathematical concepts
- Use course materials, textbook, and lecture notes
- Ask questions during office hours
- Collaborate on understanding the theory

You may **NOT**:

- Copy code from other students or online sources
- Share your completed implementations
- Use AI tools to generate your solutions
- Submit work you don't fully understand

The goal is to develop your skills in both theoretical analysis and practical algorithm implementation.

**Due Date:** October 2 by 11:59 PM

**Late Policy:** 10% per day, maximum 5 days late

---

_Course content developed by Declan Gray-Mullen for WNEU with Claude_
