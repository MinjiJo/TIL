### 시저 암호

#### 프로그래머스 Level1 

##### 문제
어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

##### 제한사항
- 공백은 아무리 밀어도 공백입니다.
- s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
- s의 길이는 8000이하입니다.
- n은 1 이상, 25이하인 자연수입니다.


##### 풀이 방법
영문자 26자가 순환되어서 나와야 하는데, 아스키 코드 상 소문자 및 대문자 z모두 다음이 a가 오는 것이 아니라 특수문자들이 오게 된다. 그렇기 때문에 대문자나 소문자 중 한 경우로 정한 후에 그 안에서 순환하도록 해주어야 한다.<br>

>> **Character.isLowerCase(char ch) -> ch가 영문 소문자인지 여부를 판단하여 true, false를 반환**<br>

또한 공백은 유지가 되어야 하기 때문에 공백인 경우를 제외하고 밀어준다.<>

```java
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char a;

        for(int i = 0; i < s.length(); i++){
            a = s.charAt(i);
            if(a!=' '){
                char start = Character.isLowerCase(a)?'a':'A';
                a = (char)(start + (a+n-start)%26);
            }
            answer += a;
        }

        return answer;
    }
}
```