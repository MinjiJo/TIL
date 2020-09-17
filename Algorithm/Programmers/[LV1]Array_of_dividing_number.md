### 나누어 떨어지는 숫자 배열

#### 프로그래머스 Level1 

##### 문제
array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.<br>
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

##### 제한사항
- arr은 자연수를 담은 배열입니다.
- 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
- divisor는 자연수입니다.
- array는 길이 1 이상인 배열입니다.

##### 풀이 방법
길이를 정하지 않아도 되는 ArrayList에 먼저 조건에 해당하는 숫자를 넣고, 그 숫자를 배열에 담아 Arrays.sort(배열) 을 이용하여 오름차순 정렬 시켰다.

```java
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        ArrayList arrlist = new ArrayList();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0){
                arrlist.add(arr[i]);        
            }
        }
        
        if(arrlist.size()==0){
            int[] answer = {-1};
            return answer;   
        }
        
        int[] answer = new int[arrlist.size()];
        
        for(int i=0; i<arrlist.size(); i++){
            answer[i] = (Integer)arrlist.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}
```