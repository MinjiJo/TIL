### 내적

#### 프로그래머스 Level1 

##### 문제
어떤 정수들이 있습니다.<br>
이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다.<br>
실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.<br><br>

##### 제한사항
- absolutes의 길이는 1 이상 1,000 이하입니다.
    - absolutes의 모든 수는 각각 1 이상 1,000 이하입니다.
- signs의 길이는 absolutes의 길이와 같습니다.
    - signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수임을, 그렇지 않으면 음수임을 의미합니다.<br><br>

##### 풀이 방법
for문을 이용하여 양수인 경우 그대로 더하고, 음수인 경우 -1을 곱하여 더한다.<br><br>

```java
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i] == true) {
                answer += absolutes[i];
            } else {
                answer += absolutes[i]*-1;
            }
        }
        return answer;
    }
}
```

<br><br>
다른 사람 풀이를 보니, 깔끔하게 한 줄로 나타낸 식이 있었다.<br>

```
조건 ? 참일 때 리턴값 : 거짓일 때 리턴값
```

위의 방식으로 나타냈는데 역시 다들 천재인게 틀림없다.<br><br>

```java
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i=0; i<signs.length; i++)
            answer += absolutes[i] * (signs[i]? 1: -1);
        return answer;
    }
}
```