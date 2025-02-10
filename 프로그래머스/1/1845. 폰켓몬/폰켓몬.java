import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            hs.add(nums[i]);
        }
        
        if (hs.size() > n/2)
            return n/2;
        
        return hs.size();
    }
}