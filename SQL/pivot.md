피벗함수의 경우 엑셀의 피벗과 동일하게 행과 열을 바꿔 수량(합계 등)을 나타낼 때 쓸 수 있다.<br>
다만, 수량이 아닌 string으로 행과 열을 바꿔서 나타내고 싶을 때가 있는데,
그럴 때는 아래와 같이 적어쥴 수 있다.

```SQL
SELECT *
FROM
(
SELECT [id], [file_name], [ver]
FROM TableName
) AS source
PIVOT
(
   MAX([ver])
   FOR [id] IN ([1], [2])
) as pvt;
```

혹은 아래의 방법도 있다.

```SQL
SELECT file_name,
    MAX(CASE WHEN id='1' THEN ver ELSE NULL END) [1],
    MAX(CASE WHEN id='2' THEN ver ELSE NULL END) [2],
FROM tableName
GROUP BY file_name
```