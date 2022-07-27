import java.util.*;

public class p1_9 {
    public int solution(String s){
        String answer="";
        for(char x : s.toCharArray()){
            if(Character.isDigit(x)) answer+=x;
        }
        return Integer.parseInt(answer);
        /*방법1 : 아스타리카 숫자 사용
        //아스타리카 숫자는 48~57 : 0~9 외워 두는 것이 좋음!
        int answer=0;
        for(char x : s.toCharArray()){
            if(x>=48 && x<57) answer = answer * 10 + (x-48);
        }
        return answer;
        */
    }

    public static void main(String[] args){
        p1_9 T = new p1_9();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));        
    }
}
