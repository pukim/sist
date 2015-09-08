select CAR_YEAR, MODEL, COUNT(*)
from car_model
GROUP BY CAR_YEAR, MODEL


SELECT CAR_YEAR
      ,SUM(�ƹ���) �ƹ���
      ,SUM(�׷���) �׷���
      ,SUM(ü���) ü���
      ,SUM(�ҷ���) �׼�Ʈ
      ,SUM(SM3)  SM3
      ,SUM(QM5)  QM5
FROM (      
	SELECT CAR_YEAR
	      ,SUM(DECODE(MODEL, '�ƹ���', 1, 0)) �ƹ���
	      ,SUM(DECODE(MODEL, '�׷���', 1, 0)) �׷���
	      ,SUM(DECODE(MODEL, 'ü���', 1, 0)) ü���
	      ,SUM(DECODE(MODEL, '�ҷ���', 1, 0)) �ҷ���
	      ,SUM(DECODE(MODEL, '�׼�Ʈ', 1, 0)) �׼�Ʈ
	      ,SUM(DECODE(MODEL, 'SM3' , 1, 0)) SM3
	      ,SUM(DECODE(MODEL, 'QM5' , 1, 0)) QM5
	FROM CAR_MODEL	
    GROUP BY CAR_YEAR
 ) A
 GROUP BY CAR_YEAR 
 ORDER BY CAR_YEAR DESC
 
 -- 11g
 SELECT * FROM (
     SELECT CAR_YEAR, MODEL
     FROM CAR_MODEL
 ) PIVOT (
     COUNT(MODEL)
     FOR MODEL IN ('�ƹ���', '�׷���', 'ü���', '�ҷ���', '�׼�Ʈ', 'SM3', 'QM5')
 ) A
 ORDER BY CAR_YEAR DESC
 