import java.util.*;

public class p1_12 {
    public String solution(int n, String s){
        //substring 으로 7개씩 끊어내기
        //replace('바꿀것','바꾸고 싶은 값');
        //Integer.parseInt(tmp, 2); <- 2진수를 10진수로 바꿀 수 있음
        String answer="";
        for(int i=0; i<n; i++){
            String tmp=s.substring(0, 7).replace('#','1').replace('*','0');
            int num=Integer.parseInt(tmp, 2);
            answer+=(char)num; //char 형변환
            s=s.substring(7);
        }
        return answer;
    }

    public static void main(String[] args){
        p1_12 T = new p1_12();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(T.solution(n, str));
    }
}
