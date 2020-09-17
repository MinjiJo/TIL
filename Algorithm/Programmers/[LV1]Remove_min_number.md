### 제일 작은 수 제거하기

#### 프로그래머스 Level1 

##### 문제
정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

##### 제한사항
- arr은 길이 1 이상인 배열입니다.
- 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.

##### 풀이 방법
Math.min(int, int)를 이용한다<br>
이 함수를 사용하면 두 int 중 작은 int를 구할 수 있기 때문에,최소값을 찾을 수 있다.<br>
이 최소값을 index 값을 하나 정해서 새롭게 배열로 정의하면 최소값이 빠진 배열을 만들 수 있다.<br><br><br>

```java
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length <= 1){
            int[] answer = {-1};
            return answer;
        }
        
        int min = arr[0];
        for(int i=1;i<arr.length;i++){
            min = Math.min(min, arr[i]);
        }
            
        int[] answer = new int[arr.length-1];
        int index = 0;
            
        for(int i=0;i<arr.length;i++){
            if(min==arr[i]){
                continue;
            }
            answer[index++] = arr[i];
        }
        
        return answer;
    }
}
```
