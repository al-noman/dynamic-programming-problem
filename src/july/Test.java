package july;

public class Test {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {-40000, -20000, 2, 4, 6, 10, 12, 12, 15, 16}, 15));
    }

    static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] == X) {
                return m;
            }
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
