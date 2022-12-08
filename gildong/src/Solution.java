import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] a = new int[k];

        int min = Integer.MAX_VALUE;
        for(int i=0; i<k; i++) {
            a[i] = score[i];
            if(a[i] < min) {
                min = a[i];
            }
            answer[i] = min;
        }

        Arrays.sort(a);
        for(int i=k; i<answer.length; i++) {
            if(score[i] > a[0]) {
                a[0] = score[i];
                if(a[0] > a[k-1]) {
                    int tmp = a[0];
                    a[0] = a[k-1];
                    a[k-1] = tmp;
                }

                for(int lt=1; lt<k; lt++) {
                    if(a[0] <= a[lt]) {
                        int tmp = a[0];
                        a[0] = a[lt-1];
                        a[lt-1] = tmp;
                        break;
                    }
                }
            }
            for(int x : a) {
                System.out.print(x + " ");
            }
            System.out.println();
            answer[i] = a[0];
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Solution s = new Solution();
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
