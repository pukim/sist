select rownum, a.*
from (
	select empno
	       ,ename
	       ,job
	       ,sal
	from emp
	order by sal desc
) a           
;


SELECT RANK() OVER (ORDER BY sal DESC ) as rank
      ,empno
      ,ename
      ,job
      ,sal
 FROM emp;
 
 
 SELECT deptno
         , ename
         , sal
         , RANK() OVER (PARTITION BY deptno ORDER BY sal DESC ) as rank
 FROM emp ;
