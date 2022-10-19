import java.util.*;

public class p2_7 {

    /*내 풀이 -- 풀이 방법은 맞지만 단계를 하나 더 쓴 느낌임
    public Integer solution(int n, int[] arr){
        int answer = 0;
        int tmp = 0;

        if(arr[0]==1){
            answer+=1;
            tmp+=1;
        }
        for(int i=1; i<n; i++){
            if(arr[i]==1){
                answer+=1;
                answer+=tmp;
                tmp+=1;
            } else {
                tmp=0;
            }
        }
        return answer;
    }
    */
    public int solution(int n, int[] arr){
        int answer=0, cnt=0;
        for(int i=0; i<n; i++){
            if(arr[i]==1){
                cnt++;
                answer+=cnt;
            }
            else cnt=0;
        }

        return answer;
    }

    public static void main(String[] args){
        p2_7 T = new p2_7();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.print(T.solution(n, arr));
    }
}