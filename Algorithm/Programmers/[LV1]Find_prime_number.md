### 제일 작은 수 제거하기

#### 프로그래머스 Level1 

##### 문제
1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.<br>
소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.<br>
(1은 소수가 아닙니다.)

##### 제한사항
- n은 2이상 1000000이하의 자연수입니다.

##### 풀이 방법
처음에는 아래의 방식으로 풀었더니,
쉬운 테스트 케이스들은 통과하지만 뒤의 것들은 시간초과로 통과하지 못했고,
효율성 테스트에서는 0점이 나왔다.

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
    
        for(int i=2;i<=n;i++){
            int count = 0;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    count++;
                }
            }
            if(count==0){
                answer++;
            }
        }
        return answer;
    }
}
```


그래서 찾아보니 에라토스테네스의 체 라는 소수를 찾는 이론이 있었다.
1. 2부터 소수를 구하고자 하는 구간의 모든 수를 나열한다.
2. 2는 소수이므로 오른쪽에 2를 쓴다.
3. 자기 자신을 제외한 2의 배수를 모두 지운다.
4. 남아있는 수 가운데 3은 소수이므로 오른쪽에 3을 쓴다.
5. 자기 자신을 제외한 3의 배수를 모두 지운다.
6. 남아있는 수 가운데 5는 소수이므로 오른쪽에 5를 쓴다.
7. 자기 자신을 제외한 5의 배수를 모두 지운다.
8. 남아있는 수 가운데 7은 소수이므로 오른쪽에 7을 쓴다.
9. 자기 자신을 제외한 7의 배수를 모두 지운다.
10. 위의 과정을 반복하면 구하는 구간의 모든 소수가 남는다.


그리고 이를 자바로 만들어놓은 코드를 찾으니 아래와 같았다.

```java
public class Eratos {
	public static void main(String[] args) {
		// ArrayList로 구현
		ArrayList<Boolean> primeList;

		// 사용자로부터의 콘솔 입력
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		// n <= 1 일 때 종료
		if(n <= 1) return;

		// n+1만큼 할당
		primeList = new ArrayList<Boolean>(n+1);
		// 0번째와 1번째를 소수 아님으로 처리
		primeList.add(false);
		primeList.add(false);
		// 2~ n 까지 소수로 설정
		for(int i=2; i<=n; i++ )
			primeList.add(i, true);

		// 2 부터  ~ i*i <= n
		// 각각의 배수들을 지워간다.
		for(int i=2; (i*i)<=n; i++){
			if(primeList.get(i)){
				for(int j = i*i; j<=n; j+=i) primeList.set(j, false);
				//i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
			}
		}
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for(int i=0; i<=n; i++){
			if(primeList.get(i) == true){
				sb.append(i);
				sb.append(",");
			}
		}
		sb.setCharAt(sb.length()-1, '}');

		System.out.println(sb.toString());

	}
}
```


나는 아래 방식으로 풀었다.
```java
class Solution {
  public int solution(int n) {
      int answer = 0;
      boolean[] sosu =new boolean [n+1];

      for(int i=2; i<=n ; i++)
          sosu[i]=true;
       //에라테네스   
      int root=(int)Math.sqrt(n);

     for(int i=2; i<=root; i++){
         if(sosu[i]==true){
             for(int j=i; i*j<=n; j++)
                sosu[i*j]=false;
         }      
     }
      for(int i =2; i<=n; i++)  { 
          if(sosu[i]==true)
          answer++;
      }
      return answer;
  }
}
```
