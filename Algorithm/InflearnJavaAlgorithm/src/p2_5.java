import java.util.*;

//에라토스테네스 체 : 소수 구하는 방법 중에 가장 빠른 방법임
//ch=new int[n+1] 일 때, 나머지 계산 시 ch[i]==0 이면 ch[i]의 배수를 모두 체크해서 없애는 방식!!!
//이 외에 이중for문을 돌리면 대부분 타임 오버되버릴것임!!!
public class p2_5 {
    public int solution(int n){
        int answer=0;
        int[] ch=new int[n+1];
        for(int i=2; i<n; i++){
            if(ch[i]==0){
                answer++;
                for(int j=i; j<=n; j=j+i) ch[j]=1;
            }
        }
        
        return answer;
    }

    public static void main(String[] args){
        p2_5 T = new p2_5();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.print(T.solution(n));
    }
}