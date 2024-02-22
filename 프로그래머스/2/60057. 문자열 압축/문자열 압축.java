class Solution { 
    public int solution(String s) {
        int answer = s.length();
        int unit = 0;
        StringBuilder sb;
        while (unit++ < s.length() / 2) {
            sb = new StringBuilder();
            String ex = s.substring(0, unit);
            String str = "";
            int num = 0;
            for (int i = 0; i < s.length(); i += unit) {
                str = s.substring(i, Math.min(i + unit, s.length()));
                if (ex.equals(str)) {
                    num++;
                } else {
                    if (num > 1) sb.append(num);
                    sb.append(ex);
                    num = 1;
                    ex = str;
                }
            }
            if (num > 1) sb.append(num);
            sb.append(str);

            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}