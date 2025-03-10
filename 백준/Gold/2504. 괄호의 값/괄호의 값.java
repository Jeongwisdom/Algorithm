class Main {
    public static void main(String[] args) throws Exception {
        int c, sum, tail = 0;
        int[] stack = new int[40];
        boolean isValid = true;
        while ((c = System.in.read()) > 31) {
            if (c == '(') {
                stack[tail++] = -2;
            }
            else if (c == ')') {
                sum = 0;
                while (tail > 0 && stack[tail - 1] >= 0) {
                    sum += stack[tail - 1];
                    tail--;
                }
                if (tail == 0 || stack[tail - 1] == -3) {
                    isValid = false;
                    break;
                }
                if (sum == 0) sum = 1;
                sum *= 2;
                stack[tail - 1] = sum;
            }
            else if (c == '[') {
                stack[tail++] = -3;
            }
            else if (c == ']') {
                sum = 0;
                while (tail > 0 && stack[tail - 1] >= 0) {
                    sum += stack[tail - 1];
                    tail--;
                }
                if (tail == 0 || stack[tail - 1] == -2) {
                    isValid = false;
                    break;
                }
                if (sum == 0) sum = 1;
                sum *= 3;
                stack[tail - 1] = sum;
            }
        }

        int answer = 0;
        if (isValid) {
            for (int i = tail - 1; i >= 0; i--) {
                if (stack[i] >= 0) answer += stack[i];
                else {
                    answer = 0;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}