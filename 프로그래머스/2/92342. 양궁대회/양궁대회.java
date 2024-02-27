class Solution {
    int[] answer;
    int diff;
    
    public int[] solution(int n, int[] info) {
        answer = new int[] {-1};
        diff = Integer.MIN_VALUE;
        DFS(n, info, new int[info.length], 0, 0, 0, 0);
        return answer;
    }
    
    public void DFS(int n, int[] info, int[] arr, int count, int sum, int ryan, int apeach) {
        if (count == info.length) {
            int d = ryan - apeach;
            if (d > 0 && d >= diff) {
                if (d > diff) {
                    answer = arr.clone();
                    diff = d;
                } else {
                    for (int i = arr.length - 1; i >= 0; i--) {
                        if (arr[i] > answer[i]) {
                            answer = arr.clone();
                            break;
                        } else if (arr[i] < answer[i]) break;
                    }
                }
            }
        } else {
            if (sum + info[count] + 1 <= n) {
                arr[count] = info[count] + 1;
                DFS(n, info, arr, count + 1, sum + arr[count], ryan + 10 - count, apeach);
            } else if (count == info.length - 1 && sum < n) {
                arr[count] = n - sum;;
                DFS(n, info, arr, count + 1, sum + arr[count], ryan + 10 - count, apeach);
            }
            arr[count] = 0;
            if (info[count] == 0) DFS(n, info, arr, count + 1, sum, ryan, apeach);
            else DFS(n, info, arr, count + 1, sum, ryan, apeach + 10 - count);
        }
    }
}