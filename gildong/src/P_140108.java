import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_140108 {
    public int solution(String s) {
        int answer = 0;
        int count = 0;
        int dif_count = 0;
        char a = ' '; // 첫번째 글자를 저장하는 변수

        for(char x : s.toCharArray()) {
            if(count == dif_count) {
                answer++;
                a = x;
            }
            if(a != x) dif_count++;
            else count++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        P_140108 p = new P_140108();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(p.solution(s));

    }
}
