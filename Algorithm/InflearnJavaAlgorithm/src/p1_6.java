import java.util.*;

public class p1_6 {
    public String solution(String str){
        String answer="";
        for(int i=0; i<str.length(); i++) {
            //System.out.println(str[i]+" "+i+" "+str.indexOf(str.charAt(i)));
            //indexOf : 처음 발견(?)되는 위치를 알 수 있음

            if(str.indexOf(str.charAt(i))==i) answer+=str.charAt(i);
        }

        return answer;
    }

    public static void main(String[] args){
        p1_6 T = new p1_6();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));        
    }
}
