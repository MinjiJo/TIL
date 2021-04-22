- 자바스크립트 String 을 parameter 와 쉽게 나타내는 방법

- 백틱(`) 안에 String을 쓴 후 ${} 안에 변수로 쓰이게 되는 파라미터를 넣어 주면 된다.

- 이전 방식
```javascript
function logPre(a, b){
    return 'Hi, my name is ' + a + "I'm " + b + " years old." 
}
console.log(logPre('Lina', 20));

```

- 발전된 방식
```javascript
function logNow(a, b){
    return `Hi, my name is ${a}. I'm ${b} years old.` 
}

console.log(logNow('Lina', 20));

```

- 백틱의 경우 한글로 '₩' 을 치는 부분을 영어로 치면 ` 을 칠 수 있다.