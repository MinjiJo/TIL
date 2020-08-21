## 선택 정렬(Selection Sort)

선택 정렬은 정렬되어져 있지 않은 자료를 정렬하는 방식 중 하나로 주어진 데이터값을 모두 비교해 최솟값의 위치를 기억해뒀다가 앞의 위치로 교환하는 정렬 방식이다. 즉, 데이터 전체에서 가장 작은 데이터를 찾아 가장 앞의 데이터와 교환하는 방식으로 특정 배열의 값을 정리한다.

## 예시 코드

```java
for (int i = 0; i < num.length - 1; i++){
	for (int j = i + 1; j < num.length; j++){
		if (num[i] > num[j]){
			int temp = num[j];
			num[j] = num[i];
			num[i] = temp;
		}
	}
}
```

이 방식은 배열에서 i와 j를 비교했을 때 숫자가 더 큰 것을 계속 뒤로 보내는 방법이다.<br>
중요한 것은 temp와 같은 임시 int 값을 만들어서 숫자를 임시적으로 담아주어야 두 개의 숫자를 온전히 바꿀 수 있다는 것이다.<br><br>
모든 인자를 서로 다 비교하기 때문에 시간이 오래 걸려 효율성이 좋다고 보기는 어렵지만 간단하면서도 쉬운 방식이라 알고리즘에서도 많이 사용된다.

## 참고

[![Selection_Array_Fork_Dance](http://img.youtube.com/vi/gARC8MApdcY/0.jpg)](https://youtu.be/gARC8MApdcY)
<br><br>정말 어마어마한 선택 정렬 포크 댄스 ㅋㅋㅋ <br>한 번 보면 확실하게 이해를 시켜 주는 포크 댄스다!