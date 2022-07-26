import java.util.*;

public class p1_8 {
    public String solution(String s){
        //replaceAll 은 정규식 사용 가능. replace 는 불가능.
        String answer="NO";
        s=s.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(s).reverse().toString();
        if(s.equals(tmp)) answer="YES";
        return answer;
    }

    public static void main(String[] args){
        p1_8 T = new p1_8();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));        
    }
}
