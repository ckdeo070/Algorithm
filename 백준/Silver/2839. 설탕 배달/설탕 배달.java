import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int min = 10000, fiveCount = 0;

    while (5 * fiveCount <= N) {
      int num = N - 5 * fiveCount;
      if (num % 3 == 0) {
        min = Integer.min(fiveCount + num / 3, min);
      }
      fiveCount++;
    }

    if (min == 10000) {
      System.out.println(-1);
    } else {
      System.out.println(min);
    }
  }
}
