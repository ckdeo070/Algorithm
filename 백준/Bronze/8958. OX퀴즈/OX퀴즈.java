import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();

    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    sc.nextLine();

    while (T-- > 0) {
      String str = sc.nextLine();
      int cnt = 0, sum = 0;
      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c == 'O') {
          cnt++;
        } else {
          stack.add(cnt);
          cnt = 0;
        }
      }
      stack.add(cnt);
      sum = getSum(stack);
      
      System.out.println(sum);
    }
  }

  private static int getSum(Stack<Integer> stack) {
    int sum = 0;
    while (!stack.isEmpty()) {
      int n = stack.pop();
      if (n != 0) {
        sum += (n + 1) * n / 2;
      }
    }
    return sum;
  }
}
