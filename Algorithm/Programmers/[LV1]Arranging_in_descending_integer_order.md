### 정수 내림차순으로 배치하기

#### 프로그래머스 Level1 

##### 문제
함수 solution은 정수 n을 매개변수로 입력받습니다. <br>
n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. <br>
예를들어 n이 118372면 873211을 리턴하면 됩니다.

##### 제한사항
- n은 1이상 8000000000 이하인 자연수입니다.

##### 풀이 방법
- int -> String ; String.vaueOf(int);
- String -> int : Integer.parseInt(String);
- String -> long : Long.parseLong(String);

처음에 return 값이 long인 것을 간과하고 마지막에 answer를 int로 처리했더니 런타임 에러가 발생했다. Long.parseInt(String);을 사용하니 에러 발생 없이 잘 제출 되었다.

```java
class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String str = String.valueOf(n);
        
        int arr[] = new int[str.length()];
        
        for(int i=0; i<str.length(); i++){
            arr[i] = Integer.parseInt(str.substring(i,i+1));
        }
        
        for(int i=0; i<str.length()-1; i++){
            for(int j=0; j<str.length()-1; j++){
                int temp = 0;
                if(arr[j] < arr[j+1]){
                  temp = arr[j+1];
                  arr[j+1] = arr[j];
                  arr[j] = temp;
                } 
            }
        }

        String temp = "";
        for(int i=0; i<str.length(); i++){
            temp += arr[i];
        }

        answer = Long.parseLong(temp);
        
        return answer;
    }
}
```


와 이게 한줄로 되네 싶었던 코드

```java
public int reverseInt(int n){
    res = "";
    Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
    return Integer.parseInt(res);
}
```