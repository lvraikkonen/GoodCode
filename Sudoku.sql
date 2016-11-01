--SELECT '53 7 6 195 98 6 8 6 34 8 3 17 2 6 6 28 419 5 8 79'
IF OBJECT_ID('SudokuInput') IS NOT NULL
  DROP TABLE SudokuInput;
GO
CREATE TABLE SudokuInput
(
  row INT NOT NULL PRIMARY KEY,
  [1] INT NULL,
  [2] INT NULL,
  [3] INT NULL,
  [4] INT NULL,
  [5] INT NULL,
  [6] INT NULL,
  [7] INT NULL,
  [8] INT NULL,
  [9] INT NULL
);
INSERT INTO SudokuInput
  VALUES( 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,    1);
INSERT INTO SudokuInput
  VALUES( 2, NULL,    2, NULL, NULL, NULL,    3,    9, NULL, NULL);
INSERT INTO SudokuInput
  VALUES( 3, NULL, NULL, NULL,    9,    1,    4, NULL, NULL,    5);
INSERT INTO SudokuInput
  VALUES( 4,    9,    8, NULL,    5, NULL, NULL,    1, NULL, NULL);
INSERT INTO SudokuInput
  VALUES( 5, NULL, NULL, NULL,    6, NULL,    8, NULL, NULL, NULL);
INSERT INTO SudokuInput
  VALUES( 6, NULL, NULL,    6, NULL, NULL,    7, NULL,    8,    3);
INSERT INTO SudokuInput
  VALUES( 7,    4, NULL, NULL,    3,    7,    9, NULL, NULL, NULL);
INSERT INTO SudokuInput
  VALUES( 8, NULL, NULL,    5,    2, NULL, NULL, NULL,    7, NULL);
INSERT INTO SudokuInput
  VALUES( 9,    2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SELECT *
FROM SudokuInput;




--These Variables are intended to be used as input parameters if made into a proc. 
DECLARE  @SudokuNo Int = 1         
		,@SudokuGivens VARCHAR(100) = null
		,@FromTableorString tinyint = 1 --1 = run from TC63, else run from Input Parm 


set @SudokuGivens='';

SELECT @SudokuGivens = @SudokuGivens + '' + Val FROM (
SELECT ROW_NUMBER() over(order by [row]) as RN,
	   isnull(cast([1] as char(1)), ' ') +
	   isnull(cast([2] as char(1)), ' ') +
	   isnull(cast([3] as char(1)), ' ') +
	   isnull(cast([4] as char(1)), ' ') +
	   isnull(cast([5] as char(1)), ' ') +
	   isnull(cast([6] as char(1)), ' ') +
	   isnull(cast([7] as char(1)), ' ') +
	   isnull(cast([8] as char(1)), ' ') +
	   isnull(cast([9] as char(1)), ' ') as Val
FROM SudokuInput) as A

select @SudokuGivens

DECLARE  @SudTable Table
(	  RowCol Int Primary Key Clustered
	, ConcatRow varchar(10)
) 
 
--SET @SudokuGivens = '53  7    6  195    98    6 8   6   34  8 3  17   2   6 6    28    419  5    8  79'

SELECT @SudokuGivens = Replace(@SudokuGivens,',',' ');
--If from table, replace commas.  From a String can have spaces or commas 

--Solve the Sudoku - into a string
WITH dual(N) 
AS (
	SELECT ROW_NUMBER() OVER (ORDER BY (SELECT N)) 
	FROM ( VALUES(1),(2),(3),(4),(5),(6),(7),(8),(9)) AS x(N) 
), X( s, ind ) 
AS
(
	SELECT @SudokuGivens, CHARINDEX(' ',@SudokuGivens ) AS ind
	
	UNION ALL
  
	SELECT CONVERT(VARCHAR(100),substring( s, 1, ind - 1 ) + z + substring( s, ind + 1 ,81))       
		 , CHARINDEX( ' ', s, ind + 1 ) AS ind 
	FROM X CROSS APPLY (
		SELECT convert(VARCHAR(25), N ) AS z
		FROM dual
		WHERE N <= 9
		) AS z (z)
	WHERE ind > 0 AND NOT EXISTS 
	(
		SELECT 1
		from (	SELECT N AS lp
				FROM dual
				WHERE N <= 9
			 ) AS ww (lp) 
		WHERE z = substring( s, ( ind - 1)% 9  - 8 + lp * 9, 1 )--for one column in each rows
		or    z = substring( s, ( ( ind - 1 ) / 9 ) * 9 + lp, 1 )--for one row
		or    z = substring( s, 
					(( ( ind - 1 ) / 3 )%3) * 3 + ( ( ind - 1 ) / 27 ) * 27 + lp + ( ( lp - 1 ) / 3 ) * 6
						, 1 )--one little 9 cube        
	)
), Sud AS 
(
	--Create a 9 record result set that has the string solution duplicated 9 times.
	--Then show only relevant 9 data for each row 
	SELECT TOP 9 SUBSTRING(s
		, ROW_NUMBER() OVER (ORDER BY s) * 9 - 8
		, ROW_NUMBER() OVER (ORDER BY s) * 9 - (ROW_NUMBER() OVER (ORDER BY s) * 9 - 9)) AS ConcatRow 
	FROM X CROSS APPLY dual
	WHERE ind = 0
) 

--Populate a Table Variable for further Row/Col manipulation 
INSERT INTO @SudTable (RowCol,ConcatRow) 
   
SELECT ROW_NUMBER() Over (Order by (Select 1))
	,ConcatRow        
FROM Sud

--Pivot the data out to produce a 9x9 grid 
SELECT --@SudokuNo AS SudokuNo,
	 C1.RowCol
	,[1],[2],[3],[4],[5],[6],[7],[8],[9] 
From @SudTable S Cross Apply 
	(SELECT RowCol,[1],[2],[3],[4],[5],[6],[7],[8],[9]
	 FROM ( SELECT S.RowCol
			  ,ColNo = Row_Number() Over (Partition By RowCol Order By ConcatRow)
			  ,Data = SUBSTRING(ConcatRow, ROW_NUMBER() OVER (Partition By S.RowCol ORDER BY ConcatRow), 1) 
			FROM @SudTable S Cross Apply ( VALUES(1),(2),(3),(4),(5),(6),(7),(8),(9)) AS x(N)
		   ) AS Intr
	 Pivot (Max(Data) FOR ColNo IN ([1],[2],[3],[4],[5],[6],[7],[8],[9]) ) PVT) AS C1
WHERE C1.RowCol = S.RowCol
ORDER BY S.RowCol ASC