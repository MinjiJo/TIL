### EXISTS / NOT EXISTS 사용법

 - EXISTS / NOT EXISTS 는 WHERE 문 앞에서 사용
 - 말 그대로 존재하는지 or 존재하지 않는지를 파악하여 나타냄

##### 예시

```SQL
insert into setupFile
select file_name, version_file, getdate()
from (select *, ROW_NUMBER() OVER (order by id_version DESC) AS RankNo
	  from setupFile
	  where file_name='abc.dll') T
where RankNo=1
and not exists (select * 
				from setupFile
				where id_srcdir='1' 
				and file_name='abc.dll')
```