class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int count = 0;
        int i = 0;
        int j = 0;
        int k = n;
        int one = k--;
        int two = one + k--;;
        int three = two + k--;
        while (count++ < n * (n + 1) / 2) {
            if (count == three) {
                one = count + k--;
                two = one + k--;
                three = two + k--;
            }
            arr[i][j] = count;
            if (count < one) i++;
            else if (count < two) j++;
            else if (count < three) {
                i--;
                j--;
            }
        }

        int[] answer = new int[n * (n + 1) / 2];
        int l = 0;
        for (int m = 0; m < n; m++) {
            for (int o = 0; o <= m; o++) {
                answer[l++] = arr[m][o];
            }
        }

        return answer;
    }
}