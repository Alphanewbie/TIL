import java.util.*;
import java.util.stream.Collectors;

public class Main {
    /**
     * 에라토스 테네스의 체로 소수들을 찾는다.
     *
     * @param n n의 범위 까지의 소수
     * @return 소수인 수는 true로 체크되어있는 n까지의 배열
     */
    private static boolean[] eratos(int n) {
        boolean[] seive = new boolean[n + 1];
        Arrays.fill(seive, true);
        seive[0] = seive[1] = false;
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (seive[i]) {
                for (int j = i * i; j < n + 1; j = j + i) {
                    seive[j] = false;
                }
            }
        }

        return seive;
    }

    private static int dfs(boolean[] seive, int n) {
        int sum = 0;
        int answer = 0;
        List<Integer> sumList = new ArrayList<>();
        int i = 2;
        while (i <= n + 1) {
            if (sum == n) {
                answer++;
            }
            if (sum >= n) {
                sum -= sumList.get(0);
                sumList.remove(0);
            } else {
                while (i <= n && !seive[i]) {
                    i++;
                }
                sum += i;
                sumList.add(i);
                i++;
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        boolean[] seive = eratos(n);

        System.out.println(dfs(seive, n));
    }
}