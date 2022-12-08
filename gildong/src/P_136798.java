import java.util.Scanner;

public class P_136798 {
    public static int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++) {
            int count = 0;
            for(int j=1; j<=i; j++) {
                if((i % j) == 0) {
                    count++;
                }
            }
            if(count > limit) answer += power;
            else answer += count;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int limit = scan.nextInt();
        int power = scan.nextInt();

        System.out.println(solution(number, limit, power));
    }
}
