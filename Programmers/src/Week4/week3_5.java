package Week4;

class week3_5 {
    public int solution(int a, int b) {
        int answer = 0;

        String ab = Integer.toString(a) + Integer.toString(b);
        int ba1 = 2 * a * b;

        answer += Math.max(Integer.parseInt(ab), ba1);

        return answer;
    }
}
