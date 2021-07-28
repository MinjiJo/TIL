### 최댓값과 최솟값

#### 프로그래머스 Level2

##### 문제
문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

##### 제한 사항
- s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.

##### 풀이 방법
*Arrays.sort(행렬명)* 을 이용하면 오름차순 순으로 정렬을 해준다. 그래서 정렬 후 첫 번째가 최솟값, 마지막 값이 최댓값이다. 그런데 String 배열에서 비교하는 경우에는 음수값을 걸러내지 못하기 때문에, Integer로 변환해 주어야 한다. *Integer.parseInt(String부분)* 을 이용하면 손쉽게 바꿔줄 수 있다.

```java
import java.util.Arrays;

class Solution {
    public String solution(String s) {
        
        String[] a = s.split(" ");
        
        int[] b = new int[a.length];
        
        for(int i = 0; i < a.length; i++){
            b[i] = Integer.parseInt(a[i]);
        }
        
        Arrays.sort(b);
        
        String answer = b[0] + " " + b[a.length-1];
        return answer;
    }
}
```

그런데 굳이 배열을 정렬하지 않는다 하더라도 max, min을 바로 비교해서 볼 수 있는 풀이가 있었다.

```java
public class GetMinMaxString {
    public String getMinMaxString(String str) {
        String[] tmp = str.split(" ");
        int min, max, n;
        min = max = Integer.parseInt(tmp[0]);
        for (int i = 1; i < tmp.length; i++) {
                n = Integer.parseInt(tmp[i]);
            if(min > n) min = n;
            if(max < n) max = n;
        }

        return min + " " + max;

    }

    public static void main(String[] args) {
        String str = "1 2 3 4";
        GetMinMaxString minMax = new GetMinMaxString();
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println("최대값과 최소값은?" + minMax.getMinMaxString(str));
    }
}
```