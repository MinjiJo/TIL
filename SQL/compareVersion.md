### 모듈 버전 비교 함수

###### 모듈 버전(ex.1.12.00.103)을 그냥 비교하다 보면, 이상하게 비교가 되어진다. string으로 받아오다 보면, 1.103이 1.21보다 크지만, 앞에서부터 차례대로 비교가 되어 21이 더 크다고 비교가 되어진다. 그래서 이를 방지하려면 하나씩 다 잘라서, 숫자로 바꿔서, 비교를 해줘야 한다. 이럴 때 쓰기 위해 함수를 미리 DB서버 내에 만들어 두고 쓰는데, 현재 사용하고 있는 방식을 정리해 두면 나중에 쓰기에도 편할 것이어서 정리해 본다.

```SQL
CREATE FUNCTION  CompareVer (
   @version1   nvarchar(20),  -- 비교 버전
   @version2   nvarchar(20)  -- 기준 버전
)  RETURNS INT
AS
BEGIN
   declare @v1 nvarchar(20) 
   declare @v2 nvarchar(20)

   declare @dot_number int
   declare @result int

   SET @v1 = REPLACE(@version1,',','.')
   SET @v2 = REPLACE(@version2,',','.')

   SET @dot_number = CONVERT(int, LEN(@v1)-LEN( REPLACE(@v1,'.','')))

   if @version1 = '0.0.0.0'
      begin
         set @result = 0 
      end
   else if @dot_number = 3
   begin
      select @result = 
         case
         when CONVERT(int, LEFT(@v1, CHARINDEX('.', @v1) - 1)) < CONVERT(int, LEFT(@v2, CHARINDEX('.', @v2) - 1)) then 0
         when CONVERT(int, LEFT(@v1, CHARINDEX('.', @v1) - 1)) > CONVERT(int, LEFT(@v2, CHARINDEX('.', @v2) - 1)) then 1
         when CONVERT(int, LEFT( (SUBSTRING(@v1, CHARINDEX('.', @v1) + 1, LEN(@v1))), (CHARINDEX('.', (SUBSTRING(@v1, CHARINDEX('.', @v1) + 1, LEN(@v1))), CHARINDEX('.', (SUBSTRING(@v1, CHARINDEX('.', @v1) + 1, LEN(@v1)))) - 1)) - 1) ) < CONVERT(int, LEFT( (SUBSTRING(@v2, CHARINDEX('.', @v2) + 1, LEN(@v2))), (CHARINDEX('.', (SUBSTRING(@v2, CHARINDEX('.', @v2) + 1, LEN(@v2))), CHARINDEX('.', (SUBSTRING(@v2, CHARINDEX('.', @v2) + 1, LEN(@v2)))) - 1)) - 1) ) then 0
         when CONVERT(int, LEFT( (SUBSTRING(@v1, CHARINDEX('.', @v1) + 1, LEN(@v1))), (CHARINDEX('.', (SUBSTRING(@v1, CHARINDEX('.', @v1) + 1, LEN(@v1))), CHARINDEX('.', (SUBSTRING(@v1, CHARINDEX('.', @v1) + 1, LEN(@v1)))) - 1)) - 1) ) > CONVERT(int, LEFT( (SUBSTRING(@v2, CHARINDEX('.', @v2) + 1, LEN(@v2))), (CHARINDEX('.', (SUBSTRING(@v2, CHARINDEX('.', @v2) + 1, LEN(@v2))), CHARINDEX('.', (SUBSTRING(@v2, CHARINDEX('.', @v2) + 1, LEN(@v2)))) - 1)) - 1) )  then 1
         when CONVERT(int, LEFT( (SUBSTRING(@v1, CHARINDEX('.', @v1, CHARINDEX('.', @v1) + 1) + 1, LEN(@v1))), (CHARINDEX('.', (SUBSTRING(@v1, CHARINDEX('.', @v1, CHARINDEX('.', @v1) + 1) + 1, LEN(@v1))), CHARINDEX('.', (SUBSTRING(@v1, CHARINDEX('.', @v1, CHARINDEX('.', @v1) + 1) + 1, LEN(@v1)))) -1)) -1) ) < CONVERT(int, LEFT( (SUBSTRING(@v2, CHARINDEX('.', @v2, CHARINDEX('.', @v2) + 1) + 1, LEN(@v2))), (CHARINDEX('.', (SUBSTRING(@v2, CHARINDEX('.', @v2, CHARINDEX('.', @v2) + 1) + 1, LEN(@v2))), CHARINDEX('.', (SUBSTRING(@v2, CHARINDEX('.', @v2, CHARINDEX('.', @v2) + 1) + 1, LEN(@v2)))) -1)) -1) )  then 0
         when CONVERT(int, LEFT( (SUBSTRING(@v1, CHARINDEX('.', @v1, CHARINDEX('.', @v1) + 1) + 1, LEN(@v1))), (CHARINDEX('.', (SUBSTRING(@v1, CHARINDEX('.', @v1, CHARINDEX('.', @v1) + 1) + 1, LEN(@v1))), CHARINDEX('.', (SUBSTRING(@v1, CHARINDEX('.', @v1, CHARINDEX('.', @v1) + 1) + 1, LEN(@v1)))) -1)) -1) ) > CONVERT(int, LEFT( (SUBSTRING(@v2, CHARINDEX('.', @v2, CHARINDEX('.', @v2) + 1) + 1, LEN(@v2))), (CHARINDEX('.', (SUBSTRING(@v2, CHARINDEX('.', @v2, CHARINDEX('.', @v2) + 1) + 1, LEN(@v2))), CHARINDEX('.', (SUBSTRING(@v2, CHARINDEX('.', @v2, CHARINDEX('.', @v2) + 1) + 1, LEN(@v2)))) -1)) -1) )  then 1
         when CONVERT(int, SUBSTRING(@v1, CHARINDEX('.', @v1, CHARINDEX('.', @v1, CHARINDEX('.', @v1) + 1) + 1) + 1, LEN(@v1)) ) < CONVERT(int, SUBSTRING(@v2, CHARINDEX('.', @v2, CHARINDEX('.', @v2, CHARINDEX('.', @v2) + 1) + 1) + 1, LEN(@v2)) )  then 0
         when CONVERT(int, SUBSTRING(@v1, CHARINDEX('.', @v1, CHARINDEX('.', @v1, CHARINDEX('.', @v1) + 1) + 1) + 1, LEN(@v1)) ) > CONVERT(int, SUBSTRING(@v2, CHARINDEX('.', @v2, CHARINDEX('.', @v2, CHARINDEX('.', @v2) + 1) + 1) + 1, LEN(@v2)) )  then 1
         else 0
         end
   end
   else if @dot_number = 2
   begin
      select @result = 
         case
         when CONVERT(int, LEFT(@v1, CHARINDEX('.', @v1) - 1)) < CONVERT(int, LEFT(@v2, CHARINDEX('.', @v2) - 1)) then 0
         when CONVERT(int, LEFT(@v1, CHARINDEX('.', @v1) - 1)) > CONVERT(int, LEFT(@v2, CHARINDEX('.', @v2) - 1)) then 1
         when CONVERT(int, LEFT( (SUBSTRING(@v1, CHARINDEX('.', @v1) + 1, LEN(@v1))), (CHARINDEX('.', (SUBSTRING(@v1, CHARINDEX('.', @v1) + 1, LEN(@v1))), CHARINDEX('.', (SUBSTRING(@v1, CHARINDEX('.', @v1) + 1, LEN(@v1)))) - 1)) - 1) ) < CONVERT(int, LEFT( (SUBSTRING(@v2, CHARINDEX('.', @v2) + 1, LEN(@v2))), (CHARINDEX('.', (SUBSTRING(@v2, CHARINDEX('.', @v2) + 1, LEN(@v2))), CHARINDEX('.', (SUBSTRING(@v2, CHARINDEX('.', @v2) + 1, LEN(@v2)))) - 1)) - 1) ) then 0
         when CONVERT(int, LEFT( (SUBSTRING(@v1, CHARINDEX('.', @v1) + 1, LEN(@v1))), (CHARINDEX('.', (SUBSTRING(@v1, CHARINDEX('.', @v1) + 1, LEN(@v1))), CHARINDEX('.', (SUBSTRING(@v1, CHARINDEX('.', @v1) + 1, LEN(@v1)))) - 1)) - 1) ) > CONVERT(int, LEFT( (SUBSTRING(@v2, CHARINDEX('.', @v2) + 1, LEN(@v2))), (CHARINDEX('.', (SUBSTRING(@v2, CHARINDEX('.', @v2) + 1, LEN(@v2))), CHARINDEX('.', (SUBSTRING(@v2, CHARINDEX('.', @v2) + 1, LEN(@v2)))) - 1)) - 1) )  then 1
         when CONVERT(int, SUBSTRING(@v1, CHARINDEX('.', @v1, CHARINDEX('.', @v1) + 1) + 1, LEN(@v1)) ) < CONVERT(int, SUBSTRING(@v2, CHARINDEX('.', @v2, CHARINDEX('.', @v2) + 1) + 1, LEN(@v2)) )  then 0
         when CONVERT(int, SUBSTRING(@v1, CHARINDEX('.', @v1, CHARINDEX('.', @v1) + 1) + 1, LEN(@v1)) ) > CONVERT(int, SUBSTRING(@v2, CHARINDEX('.', @v2, CHARINDEX('.', @v2) + 1) + 1, LEN(@v2)) )  then 1
         else 0
         end
   end

   else if @dot_number = 1
   begin
      select @result = 
         case
         when CONVERT(int, LEFT(@v1, CHARINDEX('.', @v1) - 1)) < CONVERT(int, LEFT(@v2, CHARINDEX('.', @v2) - 1)) then 0
         when CONVERT(int, LEFT(@v1, CHARINDEX('.', @v1) - 1)) > CONVERT(int, LEFT(@v2, CHARINDEX('.', @v2) - 1)) then 1
         when CONVERT(int, SUBSTRING(@v1, CHARINDEX('.', @v1) + 1, LEN(@v1)) ) < CONVERT(int, SUBSTRING(@v2, CHARINDEX('.', @v2) + 1, LEN(@v2)) )  then 0
         when CONVERT(int, SUBSTRING(@v1, CHARINDEX('.', @v1) + 1, LEN(@v1)) ) > CONVERT(int, SUBSTRING(@v2, CHARINDEX('.', @v2) + 1, LEN(@v2)) )  then 1
         else 0
         end
   end
   else
   begin
      select @result = 0 
      --print '버전 데이터안에 .(dot)이 4개 이상입니다.'
   end


   RETURN @result
END
```