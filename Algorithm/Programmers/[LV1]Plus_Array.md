### 행렬의 덧셈

#### 프로그래머스 Level1

##### 문제
행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

##### 제한사항
- 행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.

##### 풀이 방법
for문을 이용하여 각 행렬의 값을 모두 더한다.

```java
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int a = arr1.length;
        int b = arr1[0].length;
        
        int[][] answer = new int[a][b];
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
```
