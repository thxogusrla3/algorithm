class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int index, int sum) {
        if(numbers.length == index) {
            return target == sum ? 1 : 0;
        }
        
        int plus = dfs(numbers, target, index + 1, sum + numbers[index]);
        int minus = dfs(numbers, target, index + 1, sum - numbers[index]);
        
        return plus + minus;
    }
}