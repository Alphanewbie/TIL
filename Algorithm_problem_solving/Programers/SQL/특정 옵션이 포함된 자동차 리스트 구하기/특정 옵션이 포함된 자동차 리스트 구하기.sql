-- https://school.programmers.co.kr/learn/courses/30/lessons/157343
SELECT CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS
FROM CAR_RENTAL_COMPANY_CAR 
WHERE INSTR(OPTIONS , '네비게이션') > 0
ORDER BY CAR_ID DESC