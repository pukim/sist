SELECT COUNT(*)
FROM CAR_MODEL

SELECT MAKER, MODEL, COUNT(*)
FROM CAR_MAKER
GROUP BY MAKER, MODEL
ORDER BY MAKER
;

SELECT A.*
  FROM CAR_MAKER A LEFT OUTER JOIN CAR_MODEL B
 ON A.MODEL = B.MODEL
;

SELECT A.*
      ,B.*
  FROM CAR_MAKER A
      ,CAR_MODEL B
WHERE A.MODEL = B.MODEL(+)
  AND A.MAKER = '현대'
;

SELECT A.*
      ,B.*
  FROM CAR_MAKER A LEFT OUTER JOIN CAR_MODEL B
    ON A.MODEL = B.MODEL
 WHERE A.MAKER = '현대'
;

SELECT A.MAKER
      ,A.MODEL
  FROM CAR_MAKER A
 WHERE A.MAKER = '현대' 

SELECT B.*
  FROM CAR_MODEL B
 WHERE B.MAKER = '현대'  

SELECT A.*
  FROM CAR_MAKER A LEFT OUTER JOIN CAR_MODEL B
 ON A.MODEL = B.MODEL
WHERE B.MODEL IS NULL 
;

SELECT *
  FROM CAR_MODEL A
 WHERE MODEL IN (SELECT MODEL
                   FROM CAR_MAKER B 
                   WHERE MAKER = '현대')    
                  
SELECT *
  FROM CAR_MODEL A
 WHERE EXISTS (SELECT 1
                    FROM CAR_MAKER B 
                   WHERE A.MODEL = B.MODEL
                     AND MAKER = '현대')    
                  

SELECT 'BEFORE'
      ,ROWNUM R
      ,A.*
  FROM CAR_MAKER A
 WHERE MAKER = '현대'
  
 
 SELECT 'AFTER' 
      ,ROWNUM
      ,A.*
  FROM CAR_MAKER A
 WHERE MAKER = '현대'
--   AND ROWNUM < 3
ORDER BY MODEL DESC
 
 
 
                   

  