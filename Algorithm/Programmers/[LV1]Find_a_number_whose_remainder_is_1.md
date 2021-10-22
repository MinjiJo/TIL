### 나머지가 1이 되는 수 찾기

#### 프로그래머스 Level1

##### 문제
자연수 n이 매개변수로 주어집니다. n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요. 답이 항상 존재함은 증명될 수 있습니다.

##### 제한사항
- 3 ≤ n ≤ 1,000,000

##### 풀이 방법
% 연산자와 / 연산자를 사용한다.<br>
while 문을 사용하여 가장 작은 수로 answer 가 대치되도록 한다.<br><br><br>

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        int x = n-1;
        while(x >= 1) {
            if(n%x == 1) {
                answer = x;
            }
            x = x-1;
        }
        return answer;
    }
}
```

<br><br><br>
다른 사람 풀이를 보니 break 문을 쓰는 경우가 많았다. <br>

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        int x =2;
        while(true) {
            if(n%x==1) {
                answer = x;
                break;
            }
            x++;
        }
        return answer;
    }
}
```