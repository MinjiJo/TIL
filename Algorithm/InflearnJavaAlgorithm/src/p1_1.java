import java.util.Scanner;

public class p1_1 {
    public int solution(String str, char t){
        int answer = 0;
        str=str.toLowerCase();
        t=Character.toLowerCase(t);

        /*for(int i=0; i < str.length(); i++){
            if(str.charAt(i)==t) answer++;
        }*/

        for(char x : str.toCharArray()){  //toCharArray() : String 을 한 글자씩 배열 형태로 담아옴
            if(x==t) answer++;
        }

        return answer;
    }
    public static void main(String[] args){
        p1_1 T = new p1_1();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.print(T.solution(str, c));
    }
}
