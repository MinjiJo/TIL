import java.util.*;

public class p3_2 {
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
        /* 내 플이는 타임아웃이 나와버림 
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i]==b[j]) {
                    answer.add(a[i]);
                    break;
                }
            }
        }

        Collections.sort(answer);
        */
        // point alrogithm 으로 풀면 됨!!!
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1=0, p2=0;
        while(p1<n && p2<m){
            if(a[p1]==b[p2]){
                answer.add(a[p1++]);
                p2++;
            }
            else if(a[p1]<b[p2]) p1++;
            else p2++;
        }

        return answer;
    }

    public static void main(String[] args){
        p3_2 T = new p3_2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }
        int m = kb.nextInt();
        int[] b = new int[m];
        for(int i=0; i<m; i++){
            b[i]=kb.nextInt();
        }
        
        for(int x : T.solution(n, m, a, b)) System.out.print(x+" ");
    }
}