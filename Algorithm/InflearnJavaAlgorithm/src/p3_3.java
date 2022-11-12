import java.util.*;

public class p3_3 {
    public int solution(int n, int k, int[] arr){
        //window 방식으로 오른쪽으로 쭉쭉 밀어가면서 오른쪽을 더하고 가장 왼쪽을 빼는 방식으로 해야 함!
        //무조건 k만큼을 다 더하면 너무 횟수가 많아짐
        int answer, sum=0;
        for(int i=0; i<k; i++) sum+=arr[i];
        answer=sum;
        for(int i=k; i<n; i++){
            sum+=(arr[i]-arr[i-k]);
            answer=Math.max(answer, sum);
        }
        
        return answer;
    }

    public static void main(String[] args){
        p3_3 T = new p3_3();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        
        System.out.print(T.solution(n, k, arr));
    }
}