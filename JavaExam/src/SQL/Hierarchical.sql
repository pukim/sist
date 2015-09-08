-- http://www.gurubee.net/lecture/1300

SELECT * 
FROM EMP
;

SELECT MGR, COUNT(*)
FROM EMP
GROUP BY MGR
;


SELECT LEVEL, LPAD(' ', 4*(LEVEL-1)) || ename ename, empno, mgr, job 
  FROM emp
 START WITH job='PRESIDENT'
CONNECT BY PRIOR empno=mgr; 


SELECT LEVEL, LPAD(' ', 4*(LEVEL-1)) || ename ename, empno, mgr, job 
  FROM emp
 START WITH job = 'CLERK'
CONNECT BY PRIOR mgr=empno; 

