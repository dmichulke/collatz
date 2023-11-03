### Representation - p

We use a different, multiplicative number system for representing numbers where each number x is represented as the product of its prime factors.

Assume $p$to be the ordered sequence of prime numbers beginning with the smallest $p=(p_0, p_1, p_2, p_3,...) = (2, 3, 5, 7, ...)$.

Now we can represent any positive number x greater than 1 as string $q=(q_0, q_1, q_2, q_3, ...)$ such that
x= \prod_i p_i^{q_i} 

Examples: 

- $50 = 5^2 * 3^1 * 2^1 = 201_p$

- $252 = 7^1 * 5^0 * 3^2 * 2^2 = 1022_p$


### Collatz conjecture

For any given number >= 1 set $x_0=x$ and apply

- if $x_i$ is odd, $x_(i+1) = 3x_i+1$
- if $x_i$ is even, $x_(i+1) = x_i / 2$

The conjecture states that some $x_j$ will be one.

### Examples of the Collatz conjecture:

Start with

$x_0    =  7           =    1000_p$ 
$x_1    = 22 = 11*2    =   10001_p$
$x_2    = 11           =   10000_p$
$x_3    = 34 = 17*2    = 1000001_p$
$x_4    = 17           = 1000000_p$
$x_5    = 52 = 13*2*2  =  100002_p$
$x_6    = 26 = 13*2    =  100001_p$
$x_7    = 13           =  100000_p$
$x_8    = 40 = 5*2*2*2 =     103_p$
$x_9    = 20 = 5*2*2   =     102_p$
$x_{10} = 10 = 5*2     =     101_p$
$x_{11} =  5 = 5       =     100_p$
$x_{12} = 16 = 2*2*2*2 =       4_p$
...
$x_{16} =  1           =       0_p$


### Shortcuts 1 - p3

Now note how the following subsequences have almost the same prime representation with the exception of the final "pigit" p_0.

- $x_1$ and $x_2$ 
- $x_3$ and $x_4$ 
- $x_5$ to $x_7$ 
- $x_8$ to $x_11$ 
- $x_12$ to $x_16$ 

This is a natural consequence of the "division by two" step of the conjecture and we can use it to shorten the sequences by using a prime representation starting with prime 3, which well denote via a $p3$ subscript.

$x_0 =  7 =    100_{p3}$
$x_1 = 11 =   1000_{p3}$
$x_2 = 17 = 100000_{p3}$
$x_3 = 13 =  10000_{p3}$
$x_4 =  5 =     10_{p3}$
$x_5 =  1 =      0_{p3}$

### Shortcuts 2 - p5

Note also how the final digit of the p3 representation is always zero except possibly for the starting number x_0.

This is a natural consequence of the "times 3 plus 1" step of the conjecture and we can use it to reduce the representation to p5, that is, the prime representation starting with the prime 5.

For this to work we have to add the following rule: If the starting number $x_0$ is divisible by 3, apply all possible "divide by 2" steps and one "times 3 plus 1" step.

For starting number 7:

$x_0 =  7 =    10_{p5}$
$x_1 = 11 =   100_{p5}$
$x_2 = 17 = 10000_{p5}$
$x_3 = 13 =  1000_{p5}$
$x_4 =  5 =     1_{p5}$
$x_5 =  1 =     0_{p5}$


For starting number 6 without a representation in p5, we set x_{0a} = 3 (applying "divide by 2") and x_1 = 10 (applying "times 3 plus 1")

$x_0 =  6 =    NA_{p5}$
$x_1 = 10 =     1_{p5}$
$x_5 =  1 =     0_{p5}$

### Preliminary thoughts

- The p5 representation captures all numbers that we need to deal with to solve the conjecture

- Trivially, primes in p5 representation always contain exactly one 1 and the rest zeros.   

- The are observable patterns in the representation:

  - A prime x in step $i$ leads to a higher prime y in step $i+1$ due to y=0.5+1.5*x, effectively lengthening the p5 representation. This is a consequence of applying one "times 3 plus 1" and then one "divide by 2" step. A nice sequence here is 7, 11, 17. The question is whether this is the only way to avoid shortening the p5 representation. 

  -
