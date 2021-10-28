### 음양 더하기

#### 프로그래머스 Level1 

##### 문제
0부터 9까지의 숫자 중 일부가 들어있는 배열 numbers가 매개변수로 주어집니다.<br> 
numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

##### 제한사항
- 1 ≤ numbers의 길이 ≤ 9
- 0 ≤ numbers의 모든 수 ≤ 9
- numbers의 모든 수는 서로 다릅니다.

##### 풀이 방법
'없는' 숫자를 더해야 해서 열심히 고민했었는데, 고민이 무색하게도...<br>
0~9까지 더한 45에서 있는 숫자를 빼면 되었다.<br><br>
향상된 for문을 쓰면 편한데, 원래의 for문은 아래와 같다.<br>
> for(초기화 부분; 조건 부분; 증감 부분)

<br>

향상된 for문은 배열을 반복할 때 많이 쓰며 아래와 같다.<br>

> for(대입받을 변수정의 : 배열명)

<br>

향상된 for문은 배열의 값을 하나씩 가져온다고 생각하면 된다.<br><br>


```java
class Solution {
    public int solution(int[] numbers) {
        // 1 ~ 9 까지의 합인 45에서 numbers의 합을 뺀다.
        int answer = 45;
        
        for(int number : numbers) {
            answer -= number;
        }    
        
        return answer;
    }
}
```