import java.util.*;

public class p1_7 {
    public String solution(String str){
        //방법2. StringBuilder 와 reverse & equalsIgnoreCases 사용
        String answer="NO";
        String tmp=new StringBuilder(str).reverse().toString();
        //equals 는 대소문자를 구분함 
        //if(str.equals(tmp)) answer="YES";
        
        //equalsIgnoreCaes() 는 대소문자 구분하지 않음
        if(str.equalsIgnoreCase(tmp)) answer="YES";
        return answer;
        
        /*방법 1. 소문자 / 대문자로 변경해서 비교 
        String answer="YES";
        str=str.toLowerCase(); //or str=str.toUpperCase();
        int len=str.length();
        
        for(int i=0; i<len/2; i++){
            if(str.charAt(i)!=str.charAt(len-i-1)) return "NO";
        }
        return answer;
        */
        
    }

    public static void main(String[] args){
        p1_7 T = new p1_7();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));        
    }
}
