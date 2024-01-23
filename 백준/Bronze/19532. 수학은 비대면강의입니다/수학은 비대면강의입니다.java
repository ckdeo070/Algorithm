import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringTokenizer st = new StringTokenizer(sc.nextLine());
    int[] num = new int[6];
    for (int i = 0; i < 6; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

    for (int x = -999; x <= 999; x++) {
      for (int y = -999; y <= 999; y++) {
        if (num[0] * x + num[1] * y == num[2] &&
            num[3] * x + num[4] * y == num[5]) {
          System.out.println(x + " " + y);
        }
      }
    }
  }
}
