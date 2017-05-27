SQL Server Pagnation ���ݿ��ҳ
=================================

�ڱ�дWebӦ�ó����ϵͳʱ�����漰�������ݿ�Ľ�����������ݿ����������ܴ�Ļ���һ�μ������еļ�¼����ռ��ϵͳ�ܴ����Դ����˳������÷�ҳ��䣺��Ҫ�������ݾ�ֻ�����ݿ���ȡ��������¼��

�����ĶԴ���������ѯ�Ľ���������������֣�

1. ��ȫ�������Ȳ�ѯ���ڴ��У�Ȼ�����ڴ��н��з�ҳ�����ַ�ʽ���ڴ�ռ�ýϴ󣬱�������һ�β�ѯ����������

2. ���ô洢���������ݿ��н��з�ҳ�����ַ�ʽ�����ݿ�������ϴ󣬲�ͬ�����ݿ�ʵ�ֻ��Ʋ�ͨ�����Ҳ�ѯЧ�ʲ������롣�������ַ�ʽ���û���˵�������Ѻá�

## ʹ��ROW_NUMBER()������ҳ

SQL Server 2005֮�������� ```ROW_NUMBER()``` ������ͨ���ú������ݶ��õ������ֶι��򣬲�����¼���

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

## ʹ��OFFSET FETCH�Ӿ��ҳ

SQL Server 2012��������OFFSET-FETCH��䣬����ͨ��ʹ��OFFSET-FETCH��������ʵ�ַ�ҳ

``` sql
SELECT  * 
FROM    dbo.Products 
ORDER   BY UnitPrice DESC 
OFFSET  ( @pageSize * ( @pageIndex - 1 )) ROWS 
FETCH NEXT @pageSize ROWS ONLY;
```