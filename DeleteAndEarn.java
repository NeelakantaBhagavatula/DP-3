// Time Complexity : O(n) + O(max(m)), were n is length of array, m is maximum element in array
// Space Complexity : O(m), where m is max element in array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int max = nums[0];
        
        for (int num : nums) {
            max = Math.max(max, num);
        }
        
        int[] arr = new int[max+1];
        
        for (int num : nums) { // O(n), where n is length of array
            arr[num] += num;
        }
        
        int prev = 0, curr = arr[1];
        
        for (int i = 2; i < arr.length; i++) { // O(max(m)), where m is maximum element in array
            int temp = curr;
            curr = Math.max(curr, prev + arr[i]);
            prev = temp;
        }
        
        return curr;
    }
}