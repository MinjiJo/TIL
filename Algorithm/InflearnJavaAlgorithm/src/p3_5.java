import java.util.*;

public class p3_5 {
    public int solution(int n){
        //two point algorithm
        //lt, rt 구간을 만들어서 찾는 방식으로 가야 함
        int answer=0, sum=0, lt=0;
        int m = (n/2)+1;
        int[] arr = new int[m];
        for(int i=0; i<m; i++){
            arr[i] = i+1;
        }

        for(int rt=0; rt<m; rt++){
            sum+=arr[rt];
            if(sum==n) answer++;
            while(sum>=n){
                sum-=arr[lt++];
                if(sum==n) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        p3_5 T = new p3_5();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();        
        System.out.print(T.solution(n));
    }
}