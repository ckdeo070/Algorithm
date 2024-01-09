import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    Stack<Integer> stack = new Stack<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int num = Integer.parseInt(br.readLine());
      if (num == 0) {
        stack.pop();
      } else {
        stack.add(num);
      }
    }
    
    int sum = 0;
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }
    
    System.out.println(sum);
  }

}