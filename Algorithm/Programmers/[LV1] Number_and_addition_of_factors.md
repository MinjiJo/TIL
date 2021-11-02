### 약수의 개수와 덧셈

#### 프로그래머스 Level1 

##### 문제
두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

##### 제한사항
- 1 ≤ left ≤ right ≤ 1,000

##### 풀이 방법
약수의 정의는 다음과 같다.
> 약수 : 어떤 수나 식을 나누어 나머지가 없이 떨어지는 수나 식을 일컫는 말.
따라서 약수를 구하는 방법은 1부터 특정 수까지 나누기를 했을 때 0이 나오는 숫자가 바로 그 수의 약수이다.<br>
그러므로 left수와 right수가 주어지면, 각 수마다 for 문을 돌려서 약수의 개수를 구하면 된다.<br><br>

```java
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
            int cnt = 0;
            for(int j = 1; j <= i; j++) {
                if(i%j==0) {
                    cnt++;
                }
            }
            if(cnt%2==0) {
                answer+=i;
            } else {
                answer-=i;
            }
        }
        
        return answer;
    }
}
```

##### 다른 사람 풀이
그런데 정말 약수의 개념을 잘 활용한 다른 사람의 풀이도 발견했다. 이런건 정말 수학적 개념이 충실히 있어야 가능한듯.

```java
class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i=left;i<=right;i++) {
            //제곱수인 경우 약수의 개수가 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            //제곱수가 아닌 경우 약수의 개수가 짝수
            else {
                answer += i;
            }
        }

        return answer;
    }
}
```