import java.util.*;

public class p2_2 {
    public int solution(int n, int[] arr){
        int answer=1, max=arr[0];
        for(int i=1; i<n; i++){
            if(arr[i]>max){
                answer++;
                max=arr[i];
            }
        }
        /* 내가 풀은 방식 : 풀이법 컨셉은 같음
        int answer = 1;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        int max = arr[0];
        
        for(int i=1; i<n; i++){
            if(arr[i]>max) {
                max = arr[i];
                answer++;
            }
        }
        */
        return answer;
    }

    public static void main(String[] args){
        p2_2 T = new p2_2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.print(T.solution(n, arr));
    }
}
