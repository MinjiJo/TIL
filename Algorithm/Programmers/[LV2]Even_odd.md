### 짝수와 홀수

#### 프로그래머스 Level2

##### 문제
정수 num이 짝수일 경우 Even을 반환하고 홀수인 경우 Odd를 반환하는 함수, solution을 완성해주세요.

##### 제한 사항
- num은 int 범위의 정수입니다.
- 0은 짝수입니다.

##### 풀이 방법
나누기(%)를 이용한다.

```java
class Solution {
    public String solution(int num) {
        String answer = "";
        
        if(num%2==0||num==0){
            answer="Even";
        }else{
            answer="Odd";
        }
        
        return answer;
    }
}
```