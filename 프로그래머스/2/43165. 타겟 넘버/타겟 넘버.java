class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int sum) {
        // 모든 숫자를 다 사용한 경우
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        
        // 현재 숫자를 더하는 경우와 빼는 경우
        int add = dfs(numbers, target, index + 1, sum + numbers[index]);
        int subtract = dfs(numbers, target, index + 1, sum - numbers[index]);
        
        // 두 가지 경우의 결과를 합산
        return add + subtract;
    }
}
