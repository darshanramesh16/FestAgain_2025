1. Arrays & Two Pointers: Trapping Rain Water
Problem: Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much rainwater it can trap after raining.

Example:
Input: height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Output: 6

Optimal Approach (O(N) Time, O(1) Space): Two Pointers

The amount of water trapped at any position i depends on the maximum height to its left and the maximum height to its right. The water level at position i is min(max_left[i],max_right[i]). The trapped water is water[i]=water level−height[i].

By using two pointers (left starting at 0, right starting at n−1), we can calculate the water while only keeping track of the current maximums on the boundaries:

Maintain max_left and max_right.

If max_left≤max_right, it means the right side is guaranteed to be taller or equal, so we calculate the water at the current left pointer using max_left as the limiting factor, then move left++.

Otherwise, the left side is the limiting factor, and we calculate the water at the current right pointer using max_right as the limiting factor, then move right--.

2. Trees & Recursion: Lowest Common Ancestor (LCA) of a Binary Tree
Problem: Given a binary tree (not necessarily a Binary Search Tree) and two distinct nodes, p and q, find the Lowest Common Ancestor (LCA) of the two nodes.

The LCA is defined as the lowest node in the tree that has both p and q as descendants (where a node can be a descendant of itself).

Example:
Given the tree: [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4], and nodes p=5,q=1.
Output: 3 (The root)

Approach: Post-Order Recursion

This is best solved using a recursive Depth First Search (DFS) that traverses the tree in a post-order fashion (or modified pre-order that returns a value).

Base Case: If the current node is NULL or the current node is p or q, return the current node.

Recursive Step:

Call DFS on the left child to see if p or q is found in the left subtree.

Call DFS on the right child to see if p or q is found in the right subtree.

Combine Results:

If both the left and right recursive calls return a non-NULL node, it means p and q were found on opposite sides of the current node. Therefore, the current node is the LCA. Return the current node.

If only the left call returns a non-NULL node, return the result from the left call (LCA is in the left subtree, or the left node is the LCA).

If only the right call returns a non-NULL node, return the result from the right call.

3. Dynamic Programming: Word Break
Problem: Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into one or more space-separated words, where each word is in the dictionary.

Note: The same word in the dictionary may be reused multiple times.

Example:
Input: s="leetcode", wordDict=["leet","code"]
Output: True (because "leetcode" can be segmented as "leet code").

Approach: Dynamic Programming (Bottom-Up Tabulation)

This problem satisfies the optimal substructure and overlapping subproblems properties necessary for DP.

Create a boolean array, dp, of size n+1, where n is the length of s.

dp[i] will be True if the substring s[0..i−1] (of length i) can be segmented.

Initialize dp[0]=True (an empty string can always be segmented).

Iterate from i=1 to n (representing the end of the substring):

For each j from 0 to i−1 (representing all possible break points):

If dp[j] is True (the prefix s[0..j−1] is segmentable) AND

The suffix s[j..i−1] is in the wordDict,

Then set dp[i]=True and break the inner loop.

The final answer is dp[n].

Complexity: O(N 
3
 ) (or O(N 
2
 ⋅L) where L is max word length, depending on string operations and dictionary lookup time, which is usually O(1) with a hash set).
