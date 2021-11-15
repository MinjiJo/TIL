### 최소직사각형

#### 프로그래머스 Level1 

##### 문제
명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다. 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다. 이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.
아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.<br><br>
명함 번호	가로 길이	세로 길이
1	60	50
2	30	70
3	60	30
4	80	40
<br><br>
가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다. 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.<br>
모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.<br><br>

##### 제한사항
- sizes의 길이는 1 이상 10,000 이하입니다.
    - sizes의 원소는 [w, h] 형식입니다.
    - w는 명함의 가로 길이를 나타냅니다.
    - h는 명함의 세로 길이를 나타냅니다.
    - w와 h는 1 이상 1,000 이하인 자연수입니다.

##### 풀이 방법
Math.max/min 메서드를 사용한다. Math.max, min은 두 값중 크거나 작은 값을 리턴하는 것이다.
그리고 가로, 세로는 돌릴 수 있다는 점이 있으므로 두 페어 중 큰 값이 앞, 작은 값은 뒤에 있다고 생각하고 풀어야 한다.

```java
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_v=0;
        int max_h=0;
        for(int i=0;i<sizes.length;i++){
            int v=Math.max(sizes[i][0],sizes[i][1]);
            int h=Math.min(sizes[i][0],sizes[i][1]);
            max_v=Math.max(max_v,v);
            max_h=Math.max(max_h,h);
        }
        return answer=max_v*max_h;
    }
}
```

#### 다른 사람의 풀이
```java
import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        return Arrays.stream(sizes).reduce((a, b) -> new int[]{
                Math.max(Math.max(a[0], a[1]), Math.max(b[0], b[1])), Math.max(Math.min(a[0], a[1]), Math.min(b[0], b[1]))
        }).map(it -> it[0] * it[1]).get();
    }
}
```