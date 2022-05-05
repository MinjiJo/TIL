import java.util.Scanner;

public class p1_2 {
    public String solution(String str){
        String answer="";

        /*
        내가 풀었던 것
        for(int i=0; i < str.length(); i++){
            if(Character.isUpperCase(str.charAt(i))) { //.isUpperCase() : 대문자인지 확인 <-> .isLowerCase()
                char a = str.charAt(i);
                a = Character.toLowerCase(a); //.toLowerCase() : 소문자로 변환 <-> .toUpperCase()
                answer+=a;
            } else {
                char a = str.charAt(i);
                a = Character.toUpperCase(a);
                answer+=a;
            }
        }*/

        //아스키넘버 사용
        //대문자 : 65~90
        //소문자 : 97~122
        //소문자에서 32 빼면 대문자로 됨 / 대문자에서 32 더하면 소문자 됨
        for(char x : str.toCharArray()){
            if(x>=65 && x<=90) answer+=(char)(x+32);
            else answer+=(char)(x-32);
        }

        //간단
        /*for(char x : str.toCharArray()){
            if(Character.isLowerCase(x)) answer+=Character.toUpperCase(x);
            else answer+=Character.toLowerCase(x);
        }*/

        return answer;
    }
    public static void main(String[] args){
        p1_2 T = new p1_2();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }
}
