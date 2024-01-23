import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int sum = sc.nextInt();

    for (int i = 0; i <= sum; i++) {
      if (getSum(i) == sum) {
        System.out.println(i);
        return;
      }
    }
      System.out.println(0);
  }

  public static int getSum(int num) {
    int sum = num;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }
}
