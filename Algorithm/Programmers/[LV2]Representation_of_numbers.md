### 숫자의 표현

#### 프로그래머스 Level2

##### 문제
Finn은 요즘 수학공부에 빠져 있습니다. 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다. 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.<br>
- 1 + 2 + 3 + 4 + 5 = 15
- 4 + 5 + 6 = 15
- 7 + 8 = 15
- 15 = 15
자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.<br>

##### 제한 사항
- n은 10,000 이하의 자연수 입니다.

##### 풀이 방법
조건에 맞게 while, for 등을 돌린다.

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        int j=0;
        int z=0;
        
        for(int i=1; i<=n; i++){
            while(z<n){
                j+=1;
                z+=j;
                if(z==n){
                    answer+=1;
                }
            }
            j=i;
            z=0;
        }
        
        return answer;
    }
}
```

이 방식보다 int j=i; 이런 식으로 표현하는게 더 나았을 것 같다. 나와 비슷하지만 좀 더 나은 풀이가 하단과 같았다.

```java
public class Expressions {

    public int expressions(int num) {
        int answer = 0;

    int sum;
    for(int i = 1 ; i <= num ; i++) {
      sum = 0;
      for(int j = i ; j <= num ; j++) {
        sum += j;
        if(sum == num) {
          answer++;
          j = num+1;
        }
      }
    }

        return answer;
    }

    public static void main(String args[]) {
        Expressions expressions = new Expressions();
        // 아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(expressions.expressions(15));
    }
}
```