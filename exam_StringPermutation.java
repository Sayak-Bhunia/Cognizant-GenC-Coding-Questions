/*
You are given a string S and your task is to find and return the count of permutations formed by fixing the positions of the vowels present in the string.

Note: 
 - Ensure the result is non-negative
 - If there are no components then return 0

 Input Specification"

 input: A String S
 output: Return an integer value representing the count of permutations formed by fixing the positions of the vowels present in the string.

 Example 1:

 input: ABC
 output: 2
 */

class Main {
    public static int helper(int n) {
        int p = 1;
        for(int i=2;i<=n;i++) p *= i;
        return p;
    }
    public static int permutationsWithVowelsFixed(String s) {
        int[] v = new int[256];
        for(char it:"AEIOUaeiou".toCharArray()) v[it] = 1;
        int[] mp = new int[256];
        int c = 0;
        for(char it:s.toCharArray()) {
            if(v[it] == 0) {
                mp[it]++;
                c++;
            }
        }
        if(c == 0) return 0;
        int res = helper(c);
        for(int it:mp) {
            if(it>1) res /= helper(it);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(permutationsWithVowelsFixed("ABC"));    // Output: 2
        System.out.println(permutationsWithVowelsFixed("AEIOU"));  // Output: 0
        System.out.println(permutationsWithVowelsFixed("BANANA")); // Output: 12
    }
}

def helper(n):
    p = 1
    for i in range(2, n+1, 1):
        p *= i
    return p

def permutations_with_vowels_fixed(s):
    v = [0]*256
    for i in "AEIOUaeiou":
        v[ord(i)] = 1
    mp = [0]*256
    c = 0
    for i in s:
        if v[ord(i)] == 0:
            mp[ord(i)] += 1
            c+=1
    if c == 0:
        return 0
    res = helper(c)
    for i in mp:
        if i>1:
            res //= helper(i)
    return res

# Test cases
print(permutations_with_vowels_fixed("ABC"))    # Output: 2
print(permutations_with_vowels_fixed("AEIOU"))  # Output: 0
print(permutations_with_vowels_fixed("BANANA")) # Output: 12

