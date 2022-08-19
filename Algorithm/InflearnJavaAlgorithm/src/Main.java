import java.util.*;

public class Main {
    public String solution(String s){
        //String 입력 받은 값에 빈칸 하나 넣는 것이 Key!!!
        String answer="";
        s=s+" ";
        int cnt=1;
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)==s.charAt(i+1)) cnt++;
            else {
                answer+=s.charAt(i);
                if(cnt>1) answer+=String.valueOf(cnt); //integer.toString() 써도 됨
                cnt=1;
            }
        }

        return answer;
        /**내가 만든 코드
        String answer="";
        int a=1;
        for(int i=0; i<s.length(); i++){
            if(i!=s.length()-1){
                if(s.charAt(i)==s.charAt(i+1)){
                    a++;
                }
                else {
                    answer+=s.charAt(i);
                    if(a!=1) {
                        answer+=a;
                        a=1;
                    }
                }
            } else {
                answer+=s.charAt(i);
                if(a!=1) {
                    answer+=a;
                }
            }
            
        }

        return answer;
         **/
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));        
    }
}
