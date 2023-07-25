import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    sc.nextLine();
    while (T-- > 0) {
      sb.append(score(sc.nextLine()) + "\n");
    }
    System.out.println(sb);
  }

  public static int score(String s) {
    int len = s.length();
    int min = len - 1, num = 0;
    for (char c : s.toCharArray()) {
      num += Math.min(c - 'A', 'Z' - c + 1);
    }
    for (int i = 0; i < len; i++) {
      int next = i + 1;
      while (next < len && s.charAt(next) == 'A') {
        next++;
      }
      min = Math.min(min, i * 2 + (len - next));
      min = Math.min(min, (len - next) * 2 + i);
    }
    return num + min;
  }
}