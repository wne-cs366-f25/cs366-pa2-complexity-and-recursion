# Analysis

## Part A: Asymptotic Analysis

### Problem 1: Big Oh and Big Omega Proofs

**Function:** f(n) = 3n³ + 2n² - 6n + 3

#### (a) Show that f(n) = O(n³)

#### (b) Prove that f(n) = Ω(n³)

#### (c) Conclusion from parts (a) and (b)

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

**Ordered from fastest to slowest:**

1.
2.
3.
4.
5.
6.
7.

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

**Recurrence relation:** T(n) = ...

[Show your work: identify a, b, f(n), compare f(n) to n^(log_b a), determine which case applies, and provide the final result]

**Final answer:** T(n) = Θ(...)

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

**Recurrence relation:** T(n) = ...

[Explain whether Master Theorem applies or if you need to use iteration method]

[Show your complete solution steps]

**Final answer:** T(n) = Θ(...)

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

**Recurrence relation:** T(n) = ...

[Show your work: identify a, b, f(n), compare f(n) to n^(log_b a), determine which case applies, and provide the final result]

**Final answer:** T(n) = Θ(...)

### Direct Recurrence Solving

Solve the following recurrences using the Master Theorem.

#### (a) T(n) = 8T(n/2) + 6n³

**Solution:** T(n) = Θ(...)

#### (b) T(n) = 4T(n/3) + n³

**Solution:** T(n) = Θ(...)

---

## Part C: Programming Implementation Analysis

### Performance Comparison

After implementing the three binomial coefficient methods, provide your empirical analysis:

#### Timing Results

Record the execution times for your three methods with different input sizes:

| n   | k   | Definition (ms) | Cancellation (ms) | Recursive (ms) |
| --- | --- | --------------- | ----------------- | -------------- |
| 5   | 2   |                 |                   |                |
| 10  | 3   |                 |                   |                |
| 15  | 7   |                 |                   |                |
| 20  | 10  |                 |                   |                |

**Note:** You may need to skip larger cases for the recursive method due to exponential time complexity.

#### Theoretical vs Empirical Analysis

**Method 1 (Definition):**

- **Theoretical complexity:** O(n)
- **Empirical observations:** [Describe what you observed about performance scaling]
- **Analysis:** [Explain how empirical results match or differ from theory]

**Method 2 (Cancellation):**

- **Theoretical complexity:** O(min(k, n-k))
- **Empirical observations:** [Describe what you observed about performance scaling]
- **Analysis:** [Explain how empirical results match or differ from theory]

**Method 3 (Recursive):**

- **Theoretical complexity:** O(2ⁿ)
- **Empirical observations:** [Describe what you observed about performance scaling]
- **Analysis:** [Explain how empirical results match or differ from theory]

#### Implementation Challenges

**What was the most challenging part of each implementation?**

**Method 1:** [Your response]

**Method 2:** [Your response]

**Method 3:** [Your response]

#### Optimization Insights

**Which method would you choose for a production system and why?**
[Your analysis considering both time complexity and practical factors]

**For what types of inputs might each method be preferred?**
[Consider different scenarios: small n, large n, small k, large k, etc.]

---

## Summary

### Key Learning Outcomes

**Asymptotic Analysis:**
[Summarize what you learned about proving Big Oh/Omega relationships]

**Recurrence Relations:**  
[Summarize what you learned about solving recurrences and applying Master Theorem]

**Implementation Experience:**
[Summarize insights gained from implementing and comparing the three algorithmic approaches]

### Connecting Theory to Practice

**How did empirical results compare to theoretical predictions?**
[Your reflection on whether real performance matched asymptotic analysis]

**What insights did you gain about algorithm design trade-offs?**
[Your thoughts on balancing simplicity, efficiency, and maintainability]

---

_Analysis completed by [Your Name] for CS366 PA2_
