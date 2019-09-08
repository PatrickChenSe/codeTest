package amazon;

import java.util.*;

/*
Given n ropes of different lengths, we need to connect these ropes into one rope. We can connect only 2 ropes at a time.
The cost required to connect 2 ropes is equal to sum of their lengths. The length of this connected rope is also equal to the sum of their lengths.
This process is repeated until n ropes are connected into a single rope. Find the min possible cost required to connect all ropes.

Example 1:

Input: ropes = [8, 4, 6, 12]
Output: 58
Explanation: The optimal way to connect ropes is as follows
1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10, 12]
2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12]
3. Connect the ropes of length 18 and 12 (cost is 30).
Total cost to connect the ropes is 10 + 18 + 30 = 58
Example 2:

Input: ropes = [20, 4, 8, 2]   2，4->6, 6,8 -> 14, 14, 20 -> 34   2* 3 + 4 * 3 + 8 * 2 + 20 = 6 + 12 + 16 + 20 = 54
Output: 54
Example 3:

Input: ropes = [1, 2, 5, 10, 35, 89]
Output: 224
Example 4:

Input: ropes = [2, 2, 3, 3]
Output: 20

@heap

 */
public class MinCostToConnectRopes {

    public static void main(String[] args) {
        System.out.println(minCost(new int[]{2, 2, 3, 3}));
        System.out.println(minCost(new int[]{1, 2, 5, 10, 35, 89}));
        System.out.println(minCost(new int[]{20, 4, 8, 2}));
    }

    public static int minCost(int[] arr) {
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int f : arr) {
            minHeap.offer(f);
        }
        int res = 0;
        while(minHeap.size() > 1) {
            int f1 = minHeap.poll();
            int f2 = minHeap.poll();
            int tmp = f1 + f2;
            res += tmp;
            minHeap.offer(tmp);
        }
        return res;
    }

    public int minimumTime(int numOfSubFiles, List<Integer> files) {
        int result = 0;
        while (files.size()>1){
            Integer[] sorted = files.toArray(new Integer[files.size()]);
            Arrays.sort(sorted);
            files = new ArrayList<>(Arrays.asList(sorted));

            Integer sum = files.get(0) + files.get(1);

            files.remove(0);
            files.remove(0);
            files.add(sum);
            result += sum;
        }

        return result;
    }
}
