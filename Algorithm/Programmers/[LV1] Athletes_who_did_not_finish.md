### 완주하지 못한 선수

#### 프로그래머스 Level1 

##### 문제
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
<br><br>

##### 제한사항
 - 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 - completion의 길이는 participant의 길이보다 1 작습니다.
 - 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 - 참가자 중에는 동명이인이 있을 수 있습니다.

##### 풀이 방법
participant가 completion 보다 항상 1이 적은 것을 이용하여,
정렬 시킨 후 다른 값이 나오는 순간의 값을 찾는다.

```java
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant); 
        Arrays.sort(completion); 
        //배열을 순서대롲 정렬
        
        int i;
        for(i=0;i<completion.length;i++) {
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }            
        }
        //배열이 서로 다른 값인 순간을 찾음
        
        if(answer=="")
            answer = participant[i].toString();
        //만약 끝까지 돌았을 경우 맨 마지막에 다른 값이 나올 것이었음
        
        return answer;
    }
}
```

#### 다른 사람의 풀이
그런데 이 문젠느 원래 해시 영역의 문제... 해시맵을 이용해야 되는 것 같은데...
```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();
        // 참가자의 이름별 명단을 맵에 담음
        for (String p:participant)  {
            if(map.get(p) != null){
                map.put(p, map.get(p) + 1);
            }else{
                map.put(p,1);
            }
        }
        // 완주자의 리스트 만큼 명단에서 cnt 를 낮춤
        for (String c:completion){
            if(map.get(c) != 0) {
                map.put(c, map.get(c) - 1);
            }
        }
        // map 중 값이 0이 아닌 key 만 answer 에 담음
        List<String> list = new ArrayList<>();
        Iterator<String> keys = map.keySet().iterator();
        while( keys.hasNext() ){
            String key = keys.next();
            if(map.get(key) != 0) {
                for(int i = 0; i < map.get(key); i++) {
                    list.add(key);
                }
            } 
        }
        String answer = list.get(0);
        return answer;
    }
}

```