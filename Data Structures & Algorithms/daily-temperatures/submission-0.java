class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int[]> s = new Stack<>(); // temp, index
        int n = temp.length;

        int[] res = new int[n];

        for (int i = 0; i < n; i ++) {
            int t = temp[i];
            while (!s.isEmpty() && t > s.peek()[0]) {
                int[] pair = s.pop();
                res[pair[1]] = i - pair[1];
            }
            s.push(new int[]{t, i});
        }

        return res;
    }
}
