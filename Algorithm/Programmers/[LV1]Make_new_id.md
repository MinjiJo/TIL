### 신규 아이디 추천

#### 프로그래머스 Level1

##### 문제 설명
카카오에 입사한 신입 개발자 네오는 "카카오계정개발팀"에 배치되어, 카카오 서비스에 가입하는 유저들의 아이디를 생성하는 업무를 담당하게 되었습니다. "네오"에게 주어진 첫 업무는 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.<br>
다음은 카카오 아이디의 규칙입니다.<br><br>
*************
아이디의 길이는 3자 이상 15자 이하여야 합니다.<br>
아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.<br>
단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.<br><br>
*************
"네오"는 다음과 같이 7단계의 순차적인 처리 과정을 통해 신규 유저가 입력한 아이디가 카카오 아이디 규칙에 맞는 지 검사하고 규칙에 맞지 않은 경우 규칙에 맞는 새로운 아이디를 추천해 주려고 합니다.<br>
신규 유저가 입력한 아이디가 new_id 라고 한다면,<br><br>
***************
1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.<br>
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.<br>
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.<br>
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.<br>
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.<br>
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.<br>
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.<br>
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.<br>
****************

##### 문제
신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.

##### 제한사항
- new_id는 길이 1 이상 1,000 이하인 문자열입니다.
- new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
- new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.

##### 풀이 방법
정규식 활용을 잘한다.

```java
class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        //1단계
        new_id=new_id.toLowerCase();
        System.out.println(new_id);
        
        //2단계
        new_id=new_id.replaceAll("[^a-z0-9._-]", "");
        System.out.println(new_id);

        //3단계
        new_id=new_id.replaceAll("[.]{2,}", ".");
        System.out.println(new_id);

        //4단계
        new_id=new_id.replaceAll("^[.]|[.]$", "");
        System.out.println(new_id);

        //5단계
        if(new_id.isEmpty()) new_id="a";
        System.out.println(new_id);

        //6단계
        if(new_id.length() >= 16) {
            new_id=new_id.substring(0,15);
            new_id=new_id.replaceAll("[.]$", "");
        }
        System.out.println(new_id);

        //7단계
        while(new_id.length() < 3) {
            new_id+=new_id.substring(new_id.length()-1);
        }
        
        answer = new_id;
        return answer;
    }
}
```


##### 다른 사람의 풀이
```java
class Solution {
    public String solution(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase();

        temp = temp.replaceAll("[^-_.a-z0-9]","");
        System.out.println(temp);
        temp = temp.replaceAll("[.]{2,}",".");
        temp = temp.replaceAll("^[.]|[.]$","");
        System.out.println(temp.length());
        if(temp.equals(""))
            temp+="a";
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("^[.]|[.]$","");
        }
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        return answer;
    }
}
```