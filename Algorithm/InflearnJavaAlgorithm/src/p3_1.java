import java.util.*;

public class p3_1 {
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
        // 투 포인트를 잡아서 할 수 있는지 보는 문제! 아래처럼 푸는 것이 좋음~!
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        while(p1<n && p2<m){
            if(a[p1]<b[p2]) answer.add(a[p1++]); // p1이 가르키는 값이 add 가 된 후 p1 값이 1 증가함!!!
            else answer.add(b[p2++]);
        }
        while(p1<n) answer.add(a[p1++]);
        while(p2<m) answer.add(b[p2++]);
        return answer;
    }

    public static void main(String[] args){
        p3_1 T = new p3_1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i]=kb.nextInt();
        }
        int m = kb.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++){
            arr2[i]=kb.nextInt();
        }
        
        for(int x : T.solution(n, m, arr1, arr2)) System.out.print(x+" ");
    }
}