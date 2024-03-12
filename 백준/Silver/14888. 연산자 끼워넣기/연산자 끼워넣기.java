import java.util.Scanner;

public class Main {

    static int[] num;
    static int[] op = new int[4];
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }

        dfs(num[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int sum, int depth) {
        if (depth == N) {
            if (max < sum) {
                max = sum;
            }
            if (min > sum) {
                min = sum;
            }
            return;
        }

        for (int j = 0; j < 4; j++) {
            if (op[j] > 0) {

                if (j == 0) {
                    op[j]--;
                    dfs(sum + num[depth], depth + 1);
                    op[j]++;

                } else if (j == 1) {
                    op[j]--;
                    dfs(sum - num[depth], depth + 1);
                    op[j]++;

                } else if (j == 2) {
                    op[j]--;
                    dfs(sum * num[depth], depth + 1);
                    op[j]++;

                } else {
                    op[j]--;
                    dfs(sum / num[depth], depth + 1);
                    op[j]++;
                }
            }
        }

    }
}