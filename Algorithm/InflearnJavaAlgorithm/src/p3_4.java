import java.util.*;

public class p3_4 {
    public int solution(int n, int m, int[] arr){
        //for문 안에 for문을 돌려서 찾으면 시간복잡도 너무 늘어남!!
        //lt, rt 구간을 만들어서 찾는 방식으로 가야 함
        int answer=0, sum=0, lt=0;
        for(int rt=0; rt<n; rt++){
            sum+=arr[rt];
            if(sum==m) answer++;
            while(sum>=m){
                sum-=arr[lt++];
                if(sum==m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        p3_4 T = new p3_4();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        
        System.out.print(T.solution(n, m, arr));
    }
}