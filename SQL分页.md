SQL Server Pagnation 数据库分页
=================================

在编写Web应用程序等系统时，会涉及到与数据库的交互，如果数据库中数据量很大的话，一次检索所有的记录，会占用系统很大的资源，因此常常采用分页语句：需要多少数据就只从数据库中取多少条记录。

常见的对大数据量查询的解决方案有以下两种：

1. 将全部数据先查询到内存中，然后在内存中进行分页，这种方式对内存占用较大，必须限制一次查询的数据量。

2. 采用存储过程在数据库中进行分页，这种方式对数据库的依赖较大，不同的数据库实现机制不通，并且查询效率不够理想。以上两种方式对用户来说都不够友好。

## 使用ROW_NUMBER()函数分页

SQL Server 2005之后引入了 ```ROW_NUMBER()``` 函数，通过该函数根据定好的排序字段规则，产生记录序号

``` sql
SELECT  ROW_NUMBER() OVER ( ORDER BY dbo.Products.ProductID DESC ) AS rownum
      , *
FROM    dbo.Products
```

``` sql
SELECT  *
FROM    ( SELECT TOP ( @pageSize * @pageIndex )
                    ROW_NUMBER() OVER ( ORDER BY dbo.Products.UnitPrice DESC ) AS rownum ,
                    *
          FROM      dbo.Products
        ) AS temp
WHERE   temp.rownum > ( @pageSize * ( @pageIndex - 1 ) )
ORDER BY temp.UnitPrice
```

## 使用OFFSET FETCH子句分页

SQL Server 2012中引入了OFFSET-FETCH语句，可以通过使用OFFSET-FETCH过滤器来实现分页

``` sql
SELECT  * 
FROM    dbo.Products 
ORDER   BY UnitPrice DESC 
OFFSET  ( @pageSize * ( @pageIndex - 1 )) ROWS 
FETCH NEXT @pageSize ROWS ONLY;
```