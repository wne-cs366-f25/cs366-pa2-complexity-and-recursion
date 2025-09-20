# Analysis

## Part A: Asymptotic Analysis

### Problem 1: Big Oh and Big Omega Proofs

**Function:** f(n) = 3n³ + 2n² - 6n + 3

#### (a) Show that f(n) = O(n³)

To prove f(n) = O(n³), we need to find constants c > 0 and n₀ ≥ 0 such that:
f(n) ≤ c·n³ for all n ≥ n₀

Given: f(n) = 3n³ + 2n² - 6n + 3

For large n, the dominant term is 3n³. We need:
3n³ + 2n² - 6n + 3 ≤ c·n³

For n ≥ 1, we have n² ≤ n³, n ≤ n³, and 1 ≤ n³, so:
3n³ + 2n² - 6n + 3 ≤ 3n³ + 2n³ + 6n³ + 3n³ = 14n³

Therefore, c = 14 and n₀ = 1 work.

**Proof:** For n ≥ 1, f(n) = 3n³ + 2n² - 6n + 3 ≤ 14n³, so f(n) = O(n³).

#### (b) Prove that f(n) = Ω(n³)

To prove f(n) = Ω(n³), we need to find constants c > 0 and n₀ ≥ 0 such that:
f(n) ≥ c·n³ for all n ≥ n₀

Given: f(n) = 3n³ + 2n² - 6n + 3

For large n, the lower-order terms become negligible compared to 3n³.
We need: 3n³ + 2n² - 6n + 3 ≥ c·n³

For sufficiently large n, we can bound: 2n² - 6n + 3 ≥ -n³ (since the negative terms become small relative to n³)
Therefore: f(n) ≥ 3n³ - n³ = 2n³

Let's verify this works for n ≥ 2:

- When n = 2: f(2) = 3(8) + 2(4) - 6(2) + 3 = 24 + 8 - 12 + 3 = 23, and 2(8) = 16 ✓
- For larger n, the ratio approaches 3

Therefore, c = 2 and n₀ = 2 work.

**Proof:** For n ≥ 2, f(n) = 3n³ + 2n² - 6n + 3 ≥ 2n³, so f(n) = Ω(n³).

#### (c) Conclusion from parts (a) and (b)

Since f(n) = O(n³) and f(n) = Ω(n³), we conclude that **f(n) = Θ(n³)**.

### Problem 2: Function Growth Ordering

Determine the tight bound (Θ notation) for each function, then order them from fastest (1) to slowest (7) asymptotic growth.

**Functions:**

- 10n² lg n + 8n³
- n! + 2ⁿ
- 20n² log₁₆ n
- 100n + 5 log(n!)
- 16n + 2ⁿ
- 15 lg(2n) + 30
- 1000n + 10n²

**Analysis of each function:**

- 10n² lg n + 8n³ = Θ(n³) (dominant term: 8n³)
- n! + 2ⁿ = Θ(n!) (n! grows much faster than 2ⁿ)
- 20n² log₁₆ n = Θ(n² log n) (using change of base: log₁₆ n = log n / log 16)
- 100n + 5 log(n!) = Θ(n log n) (since log(n!) = Θ(n log n))
- 16n + 2ⁿ = Θ(2ⁿ) (exponential dominates linear)
- 15 lg(2n) + 30 = Θ(log n) (since lg(2n) = lg 2 + lg n = 1 + lg n)
- 1000n + 10n² = Θ(n²) (dominant term: 10n²)

**Ordered from fastest to slowest:**

1. 15 lg(2n) + 30 [Θ(log n)]
2. 100n + 5 log(n!) [Θ(n log n)]
3. 1000n + 10n² [Θ(n²)]
4. 20n² log₁₆ n [Θ(n² log n)]
5. 10n² lg n + 8n³ [Θ(n³)]
6. 16n + 2ⁿ [Θ(2ⁿ)]
7. n! + 2ⁿ [Θ(n!)]

---

## Part B: Recurrence Relations

### Algorithm Analysis

For each algorithm, write the recurrence relation T(n) and solve it to find Θ(T(n)).

#### Algorithm 1: exp(a, n)

```
exp(a, n) // calculates a^n for n ≥ 1
{
    if (n == 1)
        return a
    power = exp(a, n/2)
    power = power * power
    if (n %2 == 0)
        return power
    else
        return (power * a)
}
```

**Recurrence relation:** T(n) = T(n/2) + Θ(1)

**Analysis using Master Theorem:**

- a = 1 (one recursive call)
- b = 2 (problem size divided by 2)
- f(n) = Θ(1) (constant work outside recursion: one multiplication and conditional check)
- n^(log_b a) = n^(log₂ 1) = n^0 = 1

Since f(n) = Θ(1) = Θ(n^(log_b a)), we have **Case 2** of the Master Theorem.

**Final answer:** T(n) = Θ(log n)

#### Algorithm 2: weirdSum(A, n)

```
weirdSum(A, n) // calculates a weird sum for an array of size n
{
    if (n > 0)
    {
        sum = 0
        for i = 1 to n
            sum = sum + A[i]
        return (sum + weirdSum(A, n-1))
    }
    else return 0
}
```

**Recurrence relation:** T(n) = T(n-1) + Θ(n)

**Analysis:** Master Theorem doesn't apply here because the problem size decreases by 1 (not a constant fraction). We'll use the iteration method.

**Iteration method:**

- T(n) = T(n-1) + n
- T(n-1) = T(n-2) + (n-1)
- T(n-2) = T(n-3) + (n-2)
- ...
- T(1) = T(0) + 1

Expanding:
T(n) = T(0) + 1 + 2 + 3 + ... + n = T(0) + Σ(i=1 to n) i = T(0) + n(n+1)/2

Since T(0) = Θ(1) and n(n+1)/2 = Θ(n²):

**Final answer:** T(n) = Θ(n²)

#### Algorithm 3: something(n)

```
something(n) // does something for a positive integer n
{
    if (n ≤ 1) then
        return
    for j = 1 to sqrt(n)
        x = x+1
    for i = 1 to 10
        something(n/3)
}
```

**Recurrence relation:** T(n) = 10T(n/3) + Θ(√n)

**Analysis using Master Theorem:**

- a = 10 (ten recursive calls)
- b = 3 (problem size divided by 3)
- f(n) = Θ(√n) (work outside recursion: √n iterations in the first loop)
- n^(log_b a) = n^(log₃ 10) ≈ n^2.1 (since log₃ 10 ≈ 2.1)

Since f(n) = Θ(√n) = Θ(n^0.5) and n^(log_b a) = Θ(n^2.1):
f(n) = O(n^(log_b a - ε)) for ε = 1.6, so we have **Case 1** of the Master Theorem.

**Final answer:** T(n) = Θ(n^(log₃ 10)) = Θ(n^2.1)

### Direct Recurrence Solving

Solve the following recurrences using the Master Theorem.

#### (a) T(n) = 8T(n/2) + 6n³

**Master Theorem Analysis:**

- a = 8, b = 2, f(n) = 6n³
- n^(log_b a) = n^(log₂ 8) = n³
- f(n) = 6n³ = Θ(n³) = Θ(n^(log_b a))

Since f(n) = Θ(n^(log_b a)), this is **Case 2** of the Master Theorem.

**Solution:** T(n) = Θ(n³ log n)

#### (b) T(n) = 4T(n/3) + n³

**Master Theorem Analysis:**

- a = 4, b = 3, f(n) = n³
- n^(log_b a) = n^(log₃ 4) ≈ n^1.26
- f(n) = n³ and n^(log_b a) ≈ n^1.26

Since f(n) = n³ = Ω(n^(log_b a + ε)) for ε = 1.74, and n³ satisfies the regularity condition (af(n/b) = 4(n/3)³ = 4n³/27 ≤ cn³ for c = 4/27 < 1), this is **Case 3** of the Master Theorem.

**Solution:** T(n) = Θ(n³)

---

## Part C: Programming Implementation Analysis

### Performance Comparison

After implementing the three binomial coefficient methods, provide your empirical analysis:

#### Timing Results

Record the execution times for your three methods with different input sizes:

| n   | k   | Definition (ms) | Cancellation (ms) | Recursive (ms) |
| --- | --- | --------------- | ----------------- | -------------- |
| 5   | 2   | 0.005           | 0.013             | 0.003          |
| 10  | 3   | 0.001           | 0.001             | 0.078          |
| 15  | 7   | 0.001           | 0.001             | 0.133          |
| 20  | 10  | 0.002           | 0.001             | 0.514          |

**Note:** You may need to skip larger cases for the recursive method due to exponential time complexity.

#### Theoretical vs Empirical Analysis

**Method 1 (Definition):**

- **Theoretical complexity:** O(n)
- **Empirical observations:** Execution time remains consistently low (0.001-0.005 ms) across all test cases, with slight variation due to system noise.
- **Analysis:** The linear complexity is reflected in the consistently fast performance. Since we're computing three factorials (n!, k!, (n-k)!), the dominant work is computing n!, which requires n multiplications.

**Method 2 (Cancellation):**

- **Theoretical complexity:** O(min(k, n-k))
- **Empirical observations:** Consistently fastest method with execution times around 0.001 ms. Performance is excellent because it only does min(k, n-k) operations.
- **Analysis:** The optimization of using only necessary factors makes this extremely efficient. For our test cases, k ≤ 10, so this method performs at most 10 operations regardless of n, explaining the consistent fast performance.

**Method 3 (Recursive):**

- **Theoretical complexity:** O(2ⁿ)
- **Empirical observations:** Shows exponential growth: 0.003 ms (n=5) → 0.078 ms (n=10) → 0.133 ms (n=15) → 0.514 ms (n=20). Each increase in n causes significant performance degradation.
- **Analysis:** The exponential time complexity is clearly visible in the timing results. The recursive method explores the entire Pascal's triangle structure, leading to massive computational overhead for larger values.
