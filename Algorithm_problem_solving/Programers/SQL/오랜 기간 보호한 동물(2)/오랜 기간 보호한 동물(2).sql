-- https://school.programmers.co.kr/learn/courses/30/lessons/157342
SELECT result.ANIMAL_ID, result.NAME
FROM (  
    SELECT ins.ANIMAL_ID, ins.NAME, (outs.DATETIME - ins.DATETIME) AS STAY_DATES
    FROM ANIMAL_INS AS ins INNER JOIN ANIMAL_OUTS AS outs
    ON ins.ANIMAL_ID = outs.ANIMAL_ID
    ORDER BY STAY_DATES DESC
    LIMIT 0, 2
) AS result
