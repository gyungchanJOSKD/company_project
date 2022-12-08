import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

    class P_01 {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            List<Integer> a = new ArrayList<>();

            for(int i=0; i<answer.length; i++) {
                if(a.size() < k) {
                    a.add(score[i]);
                }else {
                    if (score[i] > a.get(0)) {
                        a.set(0, score[i]);
                    }
                }
                Collections.sort(a);
                answer[i] = a.get(0);
            }

            return answer;
        }

        public static void main(String[] args) throws IOException {

            P_01 s = new P_01();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[] score = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                score[i] = Integer.parseInt(st.nextToken());
            }

            for(int x : s.solution(k, score)) {
                System.out.print(x + " ");
            }
        }
}
