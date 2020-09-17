### 핸드폰 번호 가리기

#### 프로그래머스 Level1 

##### 문제
프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

##### 제한사항
- s는 길이 4 이상, 20이하인 문자열입니다.

##### 풀이 방법
.substring(), .length() 를 이용하였다.

```java
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        int lth = phone_number.length();
        
        String temp = phone_number.substring(lth-4,lth);
        
        for(int i=0; i<lth-4; i++){
            answer+="*";
        }
        
        answer+=temp;
        
        return answer;
    }
}
```


이 외 깔끔하게 생각했던 풀이는 아래와 같다.
```java
class Solution {
  public String solution(String phone_number) {
     char[] ch = phone_number.toCharArray();
     for(int i = 0; i < ch.length - 4; i ++){
         ch[i] = '*';
     }
     return String.valueOf(ch);
  }
}
```

```java
class Solution {
  public String solution(String phone_number) {
    return phone_number.replaceAll(".(?=.{4})", "*");
  }
}
```