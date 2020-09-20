### x만큼 간격이 있는 n개의 숫자

#### 프로그래머스 Level1 

##### 문제
함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

##### 제한사항
- x는 -10000000 이상, 10000000 이하인 정수입니다.
- n은 1000 이하인 자연수입니다.


##### 풀이 방법
x가 0일 수도 있으므로 그 경우의 수도 해 주어야 하는데, 배열 기본이 0으로 세팅되므로 이를 이용하여 return 해준다.

```java
class Solution {
    public long[] solution(long x, int n) {
        if(x == 0){
            return new long[n];
        }


        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (i + 1) * x;
        }

        return answer;
    }
}
```