select to_char(hiredate, 'yyyy') hdate
      ,listagg(ename, ',')
within group (order by ename) enames
from emp
group by to_char(hiredate, 'yyyy')

-- 11g hidden function
SELECT TO_CHAR(HIREDATE,'YYYY'),WM_CONCAT(ENAME)ENAME,MAX(SAL),MIN(SAL),COUNT(SAL) 
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YYYY');

--
select  
   deptno,
   rtrim (xmlagg (xmlelement (e, ename || ',')).extract ('//text()'), ',') enames
from  
   emp
group by  
   deptno
;

