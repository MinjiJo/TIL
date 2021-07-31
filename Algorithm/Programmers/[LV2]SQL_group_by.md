### 입양 시각 구하기(2)

#### 프로그래머스 Level2

##### 문제
ANIMAL_OUTS 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블입니다. ANIMAL_OUTS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME는 각각 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부를 나타냅니다.<br>
보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. 이때 결과는 시간대 순으로 정렬해야 합니다.

##### 풀이 방법
WITH RECURSIVE : 메모리 상에서 가상의 테이블을 만들어 주는 재귀 쿼리. 실제 테이블을 만들거나 INSERT를 하지 않고 활용할 수 있는 테이블 생성이 가능.<br><br>
시간 순서까지는 알겠는데 0~23을 어떻게 만들어야 되는지 알 수가 없었는데, 위 쿼리를 활용해서 해결하는 방식이 있었다.
<br><br>

```SQL
WITH RECURSIVE 테이블명 AS(
    SELECT 초기값 AS 컬럼명
    UNION ALL
    SELECT 컬럼명 
    계산식 FROM 테이블명
    WHERE 조건
)
```
<br>
재귀 쿼리로 가상 테이블을 만들어 활용할 수 있는 방법이 있다는게 몹시 신기하다.
해당 방법으로 나오는 쿼리를 찾은 방식은 아래와 같다.
<br>

```SQL
--MySQL
WITH RECURSIVE TIME AS (
    SELECT 0 HOUR
    UNION ALL
    SELECT HOUR + 1 FROM TIME WHERE HOUR < 23
)

SELECT HOUR, COUNT(*) - 1 COUNT
FROM (
    SELECT HOUR(DATETIME) HOUR FROM ANIMAL_OUTS
    UNION ALL
    SELECT HOUR FROM TIME
    ) VALID
GROUP BY HOUR
ORDER BY HOUR
```