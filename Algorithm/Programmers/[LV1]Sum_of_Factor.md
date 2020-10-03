### 약수의 합

#### 프로그래머스 Level1

##### 문제
정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

##### 제한 사항
- n은 0 이상 3000이하인 정수입니다.

##### 풀이 방법
나누기(%)를 이용한다.

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(n%i==0){
                answer+=i;
            }
        }
        return answer;
    }
}
```

다른 사람의 풀이를 보면서 깨달았는데, 절반까지만 더해도 가능했다. 약수의 합이기 때문에!

```java
class SumDivisor {
    public int sumDivisor(int num) {
        int answer = 0;
            for(int i = 1; i <= num/2; i++){
        if(num%i == 0) answer += i;
      }
        return answer+num;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        SumDivisor c = new SumDivisor();
        System.out.println(c.sumDivisor(12));
    }
}
```