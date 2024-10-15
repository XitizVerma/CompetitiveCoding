package ZZTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// Java code for segment tree with sum
// range and update query
import java.io.*;
import java.util.*;

class GFG {
    static int n = 6;
    static int A[] = { 0, 1, 3, 5, -2, 3 };

    // Create a segment tree of size 4*n
    static int ST[] = new int[4 * n];
    public static void build(int node, int L, int R)
    {

        // Leaf node where L == R
        if (L == R) {
            ST[node] = A[L];
        }
        else {

            // Find the middle element to
            // split the array into two halves
            int mid = (L + R) / 2;

            // Recursively travel the
            // left half
            build(2 * node, L, mid);

            // Recursively travel the
            // right half
            build(2 * node + 1, mid + 1, R);

            // Storing the sum of both the
            // children into the parent
            ST[node] = ST[2 * node] + ST[2 * node + 1];
        }
    }

    public static void update(int node, int L, int R,
                              int idx, int val)
    {

        // Find the lead node and
        // update its value
        if (L == R) {
            A[idx] += val;
            ST[node] += val;
        }
        else {

            // Find the mid
            int mid = (L + R) / 2;

            // If node value idx is at the
            // left part then update
            // the left part
            if (L <= idx && idx <= mid)
                update(2 * node, L, mid, idx, val);
            else
                update(2 * node + 1, mid + 1, R, idx, val);

            // Store the information in parents
            ST[node] = ST[2 * node] + ST[2 * node + 1];
        }
    }

    public static int query(int node, int tl, int tr, int l,
                            int r)
    {

        // If it lies out of range then
        // return 0
        if (r < tl || tr < l)
            return 0;

        // If the node contains the range then
        // return the node value
        if (l <= tl && tr <= r)
            return ST[node];
        int tm = (tl + tr) / 2;

        // Recursively traverse left and right
        // and find the node
        return query(2 * node, tl, tm, l, r)
                + query(2 * node + 1, tm + 1, tr, l, r);
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Build a segment tree
        build(1, 0, n - 1);
        System.out.println(
                "Sum of values in range 0-4 are: "
                        + query(1, 0, n - 1, 0, 4));

        // Update the value at idx = 1 by
        // 100 ths becoming 101
        update(1, 0, n - 1, 1, 100);
        System.out.println(
                "Value at index 1 increased by 100");
        System.out.println("sum of value in range 1-3 are: "
                + query(1, 0, n - 1, 1, 3));
    }
}

// This code is contributed by Rohit Pradhan
