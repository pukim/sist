-- step1 
SELECT make_dates
     , LEVEL
FROM (
	SELECT TO_DATE('201510', 'YYYYMM') make_dates
	FROM DUAL
) A
CONNECT BY LEVEL <= 31
;

-- step2
SELECT (make_dates + LEVEL - 1) dates
     , LEVEL
FROM (
	SELECT TO_DATE('201510', 'YYYYMM') make_dates
	FROM DUAL
) A
CONNECT BY LEVEL <= 31
;

-- step3
SELECT DECODE(TO_CHAR(dates, 'D'), 1, TO_CHAR(dates, 'DD')) 일
     , DECODE(TO_CHAR(dates, 'D'), 2, TO_CHAR(dates, 'DD')) 월
     , DECODE(TO_CHAR(dates, 'D'), 3, TO_CHAR(dates, 'DD')) 화
     , DECODE(TO_CHAR(dates, 'D'), 4, TO_CHAR(dates, 'DD')) 수
     , DECODE(TO_CHAR(dates, 'D'), 5, TO_CHAR(dates, 'DD')) 목
     , DECODE(TO_CHAR(dates, 'D'), 6, TO_CHAR(dates, 'DD')) 금
     , DECODE(TO_CHAR(dates, 'D'), 7, TO_CHAR(dates, 'DD')) 토
 FROM (
	SELECT (make_dates + LEVEL - 1) dates
	     , LEVEL
	FROM (
		SELECT TO_DATE('201510', 'YYYYMM') make_dates
		FROM DUAL
	) A
	CONNECT BY LEVEL <= 31
)	
;

-- step4
SELECT TO_CHAR(dates, 'W')
     , MIN(DECODE(TO_CHAR(dates, 'D'), 1, TO_CHAR(dates, 'DD'))) 일
     , MIN(DECODE(TO_CHAR(dates, 'D'), 2, TO_CHAR(dates, 'DD'))) 월
     , MIN(DECODE(TO_CHAR(dates, 'D'), 3, TO_CHAR(dates, 'DD'))) 화
     , MIN(DECODE(TO_CHAR(dates, 'D'), 4, TO_CHAR(dates, 'DD'))) 수
     , MIN(DECODE(TO_CHAR(dates, 'D'), 5, TO_CHAR(dates, 'DD'))) 목
     , MIN(DECODE(TO_CHAR(dates, 'D'), 6, TO_CHAR(dates, 'DD'))) 금
     , MIN(DECODE(TO_CHAR(dates, 'D'), 7, TO_CHAR(dates, 'DD'))) 토
 FROM (
	SELECT (make_dates + LEVEL - 1) dates
	     , LEVEL
	FROM (
		SELECT TO_DATE('201510', 'YYYYMM') make_dates
		FROM DUAL
	) A
	CONNECT BY LEVEL <= 31
)	
GROUP BY TO_CHAR(dates, 'W')
;


-- step5
SELECT NVL(MIN(DECODE(TO_CHAR(dates, 'D'), 1, TO_CHAR(dates, 'DD'))),' ') 일
     , NVL(MIN(DECODE(TO_CHAR(dates, 'D'), 2, TO_CHAR(dates, 'DD'))),' ') 월
     , NVL(MIN(DECODE(TO_CHAR(dates, 'D'), 3, TO_CHAR(dates, 'DD'))),' ') 화
     , NVL(MIN(DECODE(TO_CHAR(dates, 'D'), 4, TO_CHAR(dates, 'DD'))),' ') 수
     , NVL(MIN(DECODE(TO_CHAR(dates, 'D'), 5, TO_CHAR(dates, 'DD'))),' ') 목
     , NVL(MIN(DECODE(TO_CHAR(dates, 'D'), 6, TO_CHAR(dates, 'DD'))),' ') 금
     , NVL(MIN(DECODE(TO_CHAR(dates, 'D'), 7, TO_CHAR(dates, 'DD'))),' ') 토
 FROM (
	SELECT (make_dates + LEVEL - 1) dates
	     , LEVEL
	FROM (
		SELECT TO_DATE('201510', 'YYYYMM') make_dates
		FROM DUAL
	) A
	CONNECT BY (make_dates + LEVEL - 1) <= LAST_DAY(make_dates)
)	
GROUP BY DECODE(TO_CHAR(dates, 'D'), 1, TO_CHAR(dates, 'IW') + 1
                                      , TO_CHAR(dates, 'IW'))
ORDER BY DECODE(TO_CHAR(dates, 'D'), 1, TO_CHAR(dates, 'IW') + 1
                                      , TO_CHAR(dates, 'IW'))                                        
;

 
