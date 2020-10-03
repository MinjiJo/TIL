### 2016년

#### 프로그래머스 Level1

##### 문제
2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT
입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

##### 제한 조건
- 2016년은 윤년입니다.
- 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)

##### 풀이 방법
for문을 이용하여 각 월의 일자만큼 더한 후 행렬에서 해당하는 요일을 가져올 수 있도록 한다.

```java
class Solution {
    public String solution(int a, int b) {
        int total = 0;
        
        String[] dayOfWeek = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        
        for(int i=1; i<a; i++){
            if(i==4||i==6||i==9||i==11){
                total+=30;        
            } else if(i==2){ 
                total+=29;
            } else {
                total+=31;
            }
        }
        
        int day = b+total+4;
        
        return dayOfWeek[day%7];
    }
}
```
